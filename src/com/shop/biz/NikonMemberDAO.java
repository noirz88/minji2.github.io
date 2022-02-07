package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.NikonMemberVO;

//배치(batch) 프로그래밍 : 한 곳에서 일을 한꺼번에 처리하기 위한 프로그래밍 
//custom 테이블에 접근하여 데이터 처리요청되어 온 일들을 모두 한 곳에서 처리하기 위한 모듈  
public class NikonMemberDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//회원 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
	public ArrayList<NikonMemberVO> getMemberList() { 
		ArrayList<NikonMemberVO> memberList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			memberList = new ArrayList<NikonMemberVO>();
			while(rs.next()) {
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기 
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String mtel = rs.getString("mtel");
				String memail = rs.getString("memail");
				String mzipcode = rs.getString("mzipcode");
				String maddr1 = rs.getString("maddr1");
				String maddr2 = rs.getString("maddr2");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				NikonMemberVO member = new NikonMemberVO();
				member.setMid(mid);
				member.setMpw(mpw);
				member.setMname(mname);
				member.setMtel(mtel);
				member.setMemail(memail);
				member.setMzipcode(mzipcode);
				member.setMaddr1(maddr1);
				member.setMaddr2(maddr2);
				
				//VO에 담긴 데이터를 LIST에 담기
				memberList.add(member);
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
		return memberList;
	}
	
	public NikonMemberVO getMember(NikonMemberVO vo) {
		NikonMemberVO member = null;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonmember set visited=visited+1 where mid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			int cnt = stmt.executeUpdate();
			stmt.close();
			if(cnt>0) {
				sql = "select * from nikonmember where mid = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vo.getMid());
				rs = stmt.executeQuery();
				if(rs.next()) {
					member = new NikonMemberVO();
					member.setMid(rs.getString("mid"));
					member.setMpw(rs.getString("mpw"));
					member.setMname(rs.getString("mname"));
					member.setMemail(rs.getString("memail"));
					member.setMtel(rs.getString("mtel"));
					member.setMzipcode(rs.getString("mzipcode"));
					member.setMaddr1(rs.getString("maddr1"));
					member.setMaddr2(rs.getString("maddr2"));
				}
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return member;
	}
	public int updatemember(NikonMemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonmember set mpw=?, mname=?, memail=?, mtel=?, mzipcode=?, maddr1=?, maddr2=? where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMpw());
			stmt.setString(2, vo.getMname());
			stmt.setString(3, vo.getMtel());
			stmt.setString(4, vo.getMemail());
			stmt.setString(5, vo.getMzipcode());
			stmt.setString(6, vo.getMaddr1());
			stmt.setString(7, vo.getMaddr2());
			stmt.setString(8, vo.getMid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deletemember(NikonMemberVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from member where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addMember(NikonMemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonmember values (?, ?, ?, ?, ?, ?, ?, ?)";
			//insert into custom values ('kkt09072', '4321', '김기태', 'kkt09072@naver.com', '010-1234-1234','121-10', '경기도 고양시 일산동구', '도내동 20', 1, 0, sysdate, 4);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			stmt.setString(2, vo.getMpw());
			stmt.setString(3, vo.getMname());
			stmt.setString(4, vo.getMtel());
			stmt.setString(5, vo.getMemail());
			stmt.setString(6, vo.getMzipcode());
			stmt.setString(7, vo.getMaddr1());
			stmt.setString(8, vo.getMaddr2());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}