package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.DBConn;
import com.shop.model.NikonNoticeVO;

public class NikonNoticeDAO2 {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// 페이징 처리를 위한 sql / 인라인뷰, rownum 사용
	public List<NikonNoticeVO> getList(int startRow, int endRow) {
		List<NikonNoticeVO> list = null;	
		try {
			con = DBConn.getConnection(); // 커넥션을 얻어옴
			String sql = "select * from (select rownum as rn, seq, nname, ntit, ncon, regdate visited from (select * from nikonnotice order by seq desc)) where rn between ? and ?";
			stmt = con.prepareStatement(sql); // sql 정의
			stmt.setInt(1, startRow); // sql 물음표에 값 매핑
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery(); // sql 실행
			if (rs.next()) { // 데이터베이스에 데이터가 있으면 실행
				list = new ArrayList<>(); // list 객체 생성
				do {
					// 반복할 때마다 ExboardDTO 객체를 생성 및 데이터 저장
					NikonNoticeVO notice = new NikonNoticeVO();
					notice.setSeq(rs.getInt("seq"));
					notice.setNname(rs.getString("nname"));
					notice.setNtit(rs.getString("ntit"));
					notice.setNcon(rs.getString("ncon"));
					notice.setRegdate(rs.getDate("regdate"));
					notice.setVisited(rs.getInt("visited"));
	
					list.add(notice); // list에 0번 인덱스부터 inform 객체의 참조값을 저장
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
	return list; // list 반환
	}
	
	// 총 레코드 수 구하는 로직
	public int getCount(){
		int count = 0;
		String sql = "select count(*) from nikonnotice";
		try {
			con = DBConn.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return count; // 총 레코드 수 리턴
	}
}