package com.shop.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.*;

public class ProlistDAO {
		private Connection con = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		//제품 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
		public ArrayList<ProlistVO> getProList() { 
			ArrayList<ProlistVO> proList = null;
			try {
				con = DBConn.getConnection();
				String sql = "select * from prolist order by proid desc, protype asc";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				proList = new ArrayList<ProlistVO>();
				while(rs.next()) {
					//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기 
					int proid = rs.getInt("proid");
					String protype = rs.getString("protype");
					String proname = rs.getString("proname");
					String procom = rs.getString("procom");
					int price = rs.getInt("price");
					int cnt = rs.getInt("cnt");
					String imgData = rs.getString("imgdata");
					int visited = rs.getInt("visited");
					
					//각 지역변수에 담긴 필드값을 VO에 담기
					ProlistVO pro = new ProlistVO();

					pro.setProid(proid);
					pro.setProtype(protype);
					pro.setProname(proname);
					pro.setProcom(procom);
					pro.setPrice(price);
					pro.setCnt(cnt);
					pro.setImgData(imgData);
					pro.setVisited(visited);
					//VO에 담긴 데이터를 LIST에 담기
					proList.add(pro);
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
			return proList;
		}
		
		public ProlistVO getPro(ProlistVO vo) {
			ProlistVO pro = null;
			try {
				con = DBConn.getConnection();
				String sql;
//				String sql = "update prolist set visited=visited+1 where proid = ?";
//				stmt = con.prepareStatement(sql);
//				stmt.setInt(1, vo.getProid());
//				int num = stmt.executeUpdate();
//				stmt.close();
//				if(num>0) {
					sql = "select * from prolist where proid = ?";
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
//					}
				}	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(rs, stmt, con);
			}
			return pro;
		}
		public int updatePro(ProlistVO vo) {
			int num = 0;
			try {
				con = DBConn.getConnection();
				String sql = "update prolist set protype=?, proname=?, procom=?, price=?, cnt=?, imgdata=? where proid=?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vo.getProtype());
				stmt.setString(2, vo.getProname());
				stmt.setString(3, vo.getProcom());
				stmt.setInt(4, vo.getPrice());
				stmt.setInt(5, vo.getCnt());
				stmt.setString(6, vo.getImgData());
				stmt.setInt(7, vo.getProid());
				num = stmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(stmt, con);
			}
			return num;
		}
		public int deletePro(ProlistVO vo) {
			int num=0;
			try {
				con = DBConn.getConnection();
				String sql = "delete from prolist where proid=?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getProid());
				num = stmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(stmt, con);
			}
			return num;
		}
		public int addPro(ProlistVO vo) {
			int num = 0;
			try {
				con = DBConn.getConnection();
				String sql = "insert into prolist values(prolist_seq.nextval, ?, ?, ?, ?, ?, ?, 0)";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vo.getProtype());
				stmt.setString(2, vo.getProname());
				stmt.setString(3, vo.getProcom());
				stmt.setInt(4, vo.getPrice());
				stmt.setInt(5, vo.getCnt());
				stmt.setString(6, vo.getImgData());
				num = stmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(stmt, con);
			}
			return num;
		}
}
