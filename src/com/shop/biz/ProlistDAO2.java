package com.shop.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.*;

public class ProlistDAO2 {
		private Connection con = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		//제품 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
		public List<ProlistVO> getProList(int startRow, int endRow) { 
			List<ProlistVO> list = null;	
			try {
				con = DBConn.getConnection();
				String sql = "select * from (select rownum as rn, proid, protype, proname, procom, price, cnt, imgdata, visited from (select * from prolist order by proid desc)) where rn between ? and ?";
				//select * from (select rownum as rn, proid, protype, proname, procom, price, cnt, imgdata, visited from (select * from prolist order by proid desc)) where rn between ? and ?";
				//select * from prolist order by proid desc, protype asc
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, startRow); // sql 물음표에 값 매핑
				stmt.setInt(2, endRow);
				rs = stmt.executeQuery();
				if (rs.next()) { // 데이터베이스에 데이터가 있으면 실행
					list = new ArrayList<>(); // list 객체 생성
					do {
						// 반복할 때마다 ExboardDTO 객체를 생성 및 데이터 저장
						ProlistVO pro = new ProlistVO();
						pro.setProid(rs.getInt("proid"));
						pro.setProtype(rs.getString("protype"));
						pro.setProname(rs.getString("proname"));
						pro.setProcom(rs.getString("procom"));
						pro.setPrice(rs.getInt("price"));
						pro.setCnt(rs.getInt("cnt"));
						pro.setImgData(rs.getString("imgdata"));
						pro.setVisited(rs.getInt("visited"));
		
						list.add(pro); // list에 0번 인덱스부터 inform 객체의 참조값을 저장
					} while (rs.next());
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
			return list;
		}
		
		// 총 레코드 수 구하는 로직
		public int getCount(){
			int count = 0;
			String sql = "select count(*) from prolist";
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
		
		public ProlistVO getPro(ProlistVO vo) {
			ProlistVO pro = null;
			try {
				con = DBConn.getConnection();
				String sql = "update prolist set visited=visited+1 where proid = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getProid());
				int num = stmt.executeUpdate();
				stmt.close();
				if(num>0) {
					sql = "select * from prolist where seq = ?";
					stmt = con.prepareStatement(sql);
					stmt.setInt(1, vo.getProid());
					rs = stmt.executeQuery();
					if(rs.next()) {
						pro = new ProlistVO();
						pro.setProid(rs.getInt("proid"));
						pro.setProtype(rs.getString("protype"));
						pro.setProname(rs.getString("proname"));
						pro.setProcom(rs.getString("procom"));
						pro.setPrice(rs.getInt("price"));
						pro.setCnt(rs.getInt("cnt"));
						pro.setImgData(rs.getString("imgdata"));
						pro.setVisited(rs.getInt("visited"));
					}
				}	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(rs, stmt, con);
			}
			return pro;
		}
}
