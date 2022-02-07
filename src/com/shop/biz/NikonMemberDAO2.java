package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.model.DBConn;
import com.shop.model.NikonMemberVO;

//배치(batch) 프로그래밍 : 한 곳에서 일을 한꺼번에 처리하기 위한 프로그래밍 
//Custom 테이블에 접근하여 데이터 처리요청되어 온 일들을 모두 한 곳에서 처리하기 위한 모듈  
//getCustom(vo) : 로그인 정보(id, pw)를 Ctrl로 부터 vo로 받아  고객(custom) 테이블에서 조회하여 조회된 결과를 Ctrl로 리턴
public class NikonMemberDAO2 {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public NikonMemberVO getMember(NikonMemberVO vo) {
		NikonMemberVO member = null;
		try {
			con = DBConn.getConnection();
			String	sql = "select * from nikonmember where mid = ? and mpw = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			stmt.setString(2, vo.getMpw());
			rs = stmt.executeQuery();
			member = new NikonMemberVO();
			if(rs.next()) {				
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMemail(rs.getString("memail"));
				member.setMtel(rs.getString("mtel"));
				member.setMzipcode(rs.getString("mzipcode"));
				member.setMaddr1(rs.getString("maddr1"));
				member.setMaddr2(rs.getString("maddr2"));
				
			} else {
				System.out.println("회원이 아닙니다.");
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return member;
	}
	
	public NikonMemberVO myPage(NikonMemberVO vo) {
		NikonMemberVO member = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember where mid = ?";
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return member;
	}
	
	public int updateMember(NikonMemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonmember set mpw=?, mname=?, mtel=?, memail=?, mzipcode=?, maddr1=?, maddr2=? where mid=?";
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
			String sql = "delete from nikonmember where mid=?";
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
	public int dupCheck(NikonMemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember where mid = ?";
			System.out.println("입력한 아이디 : "+vo.getMid());
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = 1;		//사용이 불가능한 아이디
			} else {
				cnt = 0;		//사용이 가능한 아이디
			}
		} catch(Exception e) {
			System.out.println("데이터를 비교하지 못했습니다.");
			e.printStackTrace();
		}
		return cnt;
	}
}