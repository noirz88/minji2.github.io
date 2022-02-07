package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.NikonInVO;
import com.shop.model.NikonProductVO;

public class NikonInDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//장바구니 내역 목록 - ArrayList<BasketVO> :  getBasketList(회원아이디) - getBasketList()
	//장바구니 상세 내역 - BasketVO : getBasket(장바구니아이디, 회원아이디) - getBasket(장바구니아이디)
	//장바구니 수정 - int : updateBasket(장바구니아이디, 회원아이디) - updateBasket(장바구니아이디, 회원아이디)
	//장바구니 삭제(취소) - int : deleteBasket(장바구니아이디)
			//삭제 원인 - 회원이 삭제, 결제를 완료
	//장바구니 추가 - int : addBasket(BasketVO)
			//추가 원인 - 회원이 추가, 구매하기에서 결제를 하지 않은 경우
	public ArrayList<NikonInVO> getUserInList(NikonInVO vo){
		ArrayList<NikonInVO> nikoninList = null;
		String sql;
		try {
			con = DBConn.getConnection();
			sql = "select * from nikonbasket where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			rs = stmt.executeQuery();
			nikoninList = new ArrayList<NikonInVO>();
			while(rs.next()) {
				//각 데이터베이스 필드를 VO에 담기
				NikonInVO nikonin = new NikonInVO();
				nikonin.setBasketno(rs.getInt("basketno"));
				nikonin.setPcode(rs.getString("pcode"));
				nikonin.setMid(rs.getString("mid"));
				//VO에 담긴 데이터를 LIST에 담기
				nikoninList.add(nikonin);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikoninList;
	}
	public int addIn(NikonInVO vo) { //장바구니 추가
		int cnt=0;
		String sql;
		try {
			con = DBConn.getConnection();
			sql = "insert into nikonbasket values(nikonbasket_seq.nextval, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getPcode());
			stmt.setString(2, vo.getMid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int changeIn(NikonInVO vo) {
		int cnt=0, ret=0;
		String sql;
		try {
			//ret = this.deleteBasket(vo.getBasketid());	//장바구니에 있는 정보는 삭제
			if(ret>0) {
				//장바구니 정보를 결제 정보로 넘겨 처리하여 결제 처리해야함
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deleteIn(NikonInVO vo) {
		int cnt=0;
		String sql;
		try {
			con = DBConn.getConnection();
			sql = "delete from nikonbasket where basketno=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getBasketno());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public NikonProductVO getPro(int pcode) {
		NikonProductVO pro = null;
		try {
			String sql;
			sql = "select * from nikonproduct where pcode = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pcode);
			rs = stmt.executeQuery();
			if(rs.next()) {
				pro = new NikonProductVO();
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPinfo(rs.getString("getPinfo"));
				pro.setPprice(rs.getInt("pprice"));
				pro.setPimg(rs.getString("pimg"));
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
}