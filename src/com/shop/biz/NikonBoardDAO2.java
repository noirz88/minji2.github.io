package com.shop.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.shop.model.NikonBoardVO;
import com.shop.model.DBConn;

public class NikonBoardDAO2 {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//게시판 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
	public ArrayList<NikonBoardVO> getBoardList() { 
		ArrayList<NikonBoardVO> boardList = null;
		
        String sql = null;
		try {
			con = DBConn.getConnection();			
            sql = "select * from  BOARD order by board_num desc";  
            stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			boardList = new ArrayList<NikonBoardVO>();
			while(rs.next()) {
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int board_num = rs.getInt("board_num");
				String board_id = rs.getString("board_id");
				String board_subject = rs.getString("board_subject");
				String board_content = rs.getString("board_content");
				String board_file = rs.getString("board_file");
				int board_re_ref = rs.getInt("board_re_ref");
				int board_re_lev = rs.getInt("board_re_lev");
				int board_re_seq = rs.getInt("board_re_seq");
				int board_count = rs.getInt("board_count");
				Date board_date = rs.getDate("board_date");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				NikonBoardVO board = new NikonBoardVO();
				board.setNum(board_num);
				board.setId(board_id);
				board.setSubject(board_subject);
				board.setContent(board_content);
				board.setFile(board_file);
				board.setReRef(board_re_ref);
				board.setReLevel(board_re_lev);
				board.setReSeq(board_re_seq);
				board.setCount(board_count);
				board.setResDate(board_date);
				//VO에 담긴 데이터를 LIST에 담기
				boardList.add(board);
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
		return boardList;
	}

	public NikonBoardVO getBoard(NikonBoardVO vo) {
		NikonBoardVO board = null;
		try {
			con = DBConn.getConnection();
			String sql = "update board set board_count=board_count+1 where board_num = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getNum());
			int cnt = stmt.executeUpdate();
			stmt.close();
			if(cnt>0) {
				sql = "select * from board where board_num = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getNum());
				rs = stmt.executeQuery();
				if(rs.next()) {
					board = new NikonBoardVO();
					board.setNum(rs.getInt("board_num"));
					board.setId(rs.getString("board_id"));
					String board_subject = rs.getString("board_subject");
					String board_content = rs.getString("board_content");
					String board_file = rs.getString("board_file");
					int board_re_ref = rs.getInt("board_re_ref");
					int board_re_lev = rs.getInt("board_re_lev");
					int board_re_seq = rs.getInt("board_re_seq");
					int board_count = rs.getInt("board_count");
					Date board_date = rs.getDate("board_date");
				}
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return board;
	}
	public int updateBoard(NikonBoardVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update board set board_subject=?, board_content=?, board_file=? where board_num=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getSubject());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getFile());
			stmt.setInt(4, vo.getNum());

			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deleteBoard(NikonBoardVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from board where board_num=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getNum());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addBoard(NikonBoardVO vo) {
		int cnt = 0;
		try {
			int num = this.getSeq();
			con = DBConn.getConnection();
			String sql = "insert into board values (?,?,?,?,?,?,?,?,?,sysdate)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, num);
			stmt.setString(2, vo.getId());
			stmt.setString(3, vo.getSubject());
			stmt.setString(4, vo.getContent());
			stmt.setString(5, vo.getFile());
			stmt.setInt(6, num);
			stmt.setInt(7, 0);
			stmt.setInt(8, 0);
			stmt.setInt(9, 0);
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
  public int getSeq() {
        int result = 1;
        
        try {
        	con = DBConn.getConnection();
            
            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT BOARD_NUM.NEXTVAL FROM DUAL");
            
            stmt = con.prepareStatement(sql.toString());
            // 쿼리 실행
            rs = stmt.executeQuery();
            if(rs.next())    result = rs.getInt(1); 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        DBConn.close(stmt, con);
        return result;    
    }
}
