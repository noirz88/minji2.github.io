package com.shop.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.NikonNoticeVO;

//배치(batch) 프로그래밍 : 한 곳에서 일을 한꺼번에 처리하기 위한 프로그래밍 
//Inform 테이블에 접근하여 데이터 처리요청되어 온 일들을 모두 한 곳에서 처리하기 위한 모듈  
public class NikonNoticeDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//공지사항 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
	public ArrayList<NikonNoticeVO> getNoticeList() {  //int startRow, int endRow
		ArrayList<NikonNoticeVO> noticeList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonnotice order by regdate desc, seq asc";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			noticeList = new ArrayList<NikonNoticeVO>();
			while(rs.next()) {
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기 
				int seq = rs.getInt("seq");
				String nname = rs.getString("nname");
				String ntit = rs.getString("ntit");
				String ncon = rs.getString("ncon");
				Date regdate = rs.getDate("regdate");
				int visited = rs.getInt("visited");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				NikonNoticeVO notice = new NikonNoticeVO();
				notice.setSeq(seq);
				notice.setNname(nname);
				notice.setNtit(ntit);
				notice.setNcon(ncon);
				notice.setRegdate(regdate);
				notice.setVisited(visited);
				
				//VO에 담긴 데이터를 LIST에 담기
				noticeList.add(notice);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 되지 않았습니다.");
			e.printStackTrace();
		}  catch(SQLException e) {
			System.out.println("SQL 구문 또는 열이름, 변수명 등이 서로 맞지 않습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		//VO의 값을 LIST에 담은 결과를 반환
		return noticeList;
	}
	
	public NikonNoticeVO getNotice(NikonNoticeVO vo) {
		NikonNoticeVO notice = null;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonnotice set visited=visited+1 where seq = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			int cnt = stmt.executeUpdate();
			stmt.close();
			if(cnt>0) {
				sql = "select * from nikonnotice where seq = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getSeq());
				rs = stmt.executeQuery();
				if(rs.next()) {
					notice = new NikonNoticeVO();
					notice.setSeq(rs.getInt("seq"));
					notice.setNname(rs.getString("nname"));
					notice.setNtit(rs.getString("ntit"));
					notice.setNcon(rs.getString("ncon"));
					notice.setRegdate(rs.getDate("regdate"));
					notice.setVisited(rs.getInt("visited"));
				}
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return notice;
	}
	public int updateNotice(NikonNoticeVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonnotice set ntit=?, ncon=? where seq=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getNtit());
			stmt.setString(2, vo.getNcon());
			stmt.setInt(3, vo.getSeq());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deleteNotice(NikonNoticeVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonnotice where seq=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addNotice(NikonNoticeVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonnotice values(nikonnotice_seq.nextval, ?, ?, ?, sysdate, 2)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getNname());
			stmt.setString(2, vo.getNtit());
			stmt.setString(3,  vo.getNcon());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}