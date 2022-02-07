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
import com.shop.model.NikonNoticeVO;

public class NikonBoardDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//게시판 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해주는 역할의 메서드
	public ArrayList<NikonBoardVO> getBoardList(HashMap<String, Object> listOpt) { 
		ArrayList<NikonBoardVO> boardList = null;
		
        String opt = (String) listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String) listOpt.get("condition"); // 검색내용
        int start = (Integer) listOpt.get("start"); // 현재 페이지번호
		
        String sql = null;
		try {
			con = DBConn.getConnection();
			
            if(opt == null) {
                // BOARD_RE_REF(그룹번호)의 내림차순 정렬 후 동일한 그룹번호일 때는
                // BOARD_RE_SEQ(답변글 순서)의 오름차순으로 정렬 한 후에
                // 10개의 글을 한 화면에 보여주는(start번째 부터 start+9까지) 쿼리
                // desc : 내림차순, asc : 오름차순 ( 생략 가능 )
                sql = "select * from (select rownum rnum, BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_COUNT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_DATE  FROM (select * from BOARD order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) where rnum>=? and rnum<=?";  
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, start);
                stmt.setInt(2, start+9);
            } else if(opt.equals("0")) {// 제목으로 검색
                sql = "select * from (select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ FROM (select * from BOARD where BOARD_SUBJECT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) where rnum>=? and rnum<=?";
                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%"+condition+"%");
                stmt.setInt(2, start);
                stmt.setInt(3, start+9);
            } else if(opt.equals("1")) { // 내용으로 검색
                sql = "select * from (select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ FROM (select * from BOARD where BOARD_CONTENT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) where rnum>=? and rnum<=?";
                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%"+condition+"%");
                stmt.setInt(2, start);
                stmt.setInt(3, start+9);
            } else if(opt.equals("2")) { // 제목+내용으로 검색
                sql = "select * from (select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ FROM (select * from BOARD where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) where rnum>=? and rnum<=?";
                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%"+condition+"%");
                stmt.setString(2, "%"+condition+"%");
                stmt.setInt(3, start);
                stmt.setInt(4, start+9);
            } else if(opt.equals("3")) { // 글쓴이로 검색
                sql = "select * from (select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ FROM (select * from BOARD where BOARD_ID like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) where rnum>=? and rnum<=?";
                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%"+condition+"%");
                stmt.setInt(2, start);
                stmt.setInt(3, start+9);
            }
			
//			String sql = "select * from board order by board_date desc";
//			stmt = con.prepareStatement(sql);
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
	
    // 글의 개수를 가져오는 메서드
    public int getBoardListCount(HashMap<String, Object> listOpt)  {
        int result = 0;
        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        String sql = null;
        try {
        	con = DBConn.getConnection();
            
            if(opt == null) {   // 전체글의 개수
                sql = "select count(*) from BOARD";
                stmt = con.prepareStatement(sql);
            }  else if(opt.equals("0")) { // 제목으로 검색한 글의 개수
                sql = "select count(*) from BOARD where BOARD_SUBJECT like ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, '%'+condition+'%');
            }  else if(opt.equals("1")) { // 내용으로 검색한 글의 개수
                sql = "select count(*) from BOARD where BOARD_CONTENT like ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, '%'+condition+'%');
            } else if(opt.equals("2")) { // 제목+내용으로 검색한 글의 개수
                sql = "select count(*) from BOARD where BOARD_SUBJECT like ? or BOARD_CONTENT like ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, '%'+condition+'%');
                stmt.setString(2, '%'+condition+'%');
            } else if(opt.equals("3")) { // 글쓴이로 검색한 글의 개수
                sql = "select count(*) from BOARD where BOARD_ID like ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, '%'+condition+'%');
            }
            rs = stmt.executeQuery();
            if(rs.next())    result = rs.getInt(1);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
			DBConn.close(rs, stmt, con);
		}
        return result;
    } // end getBoardListCount
	
	
	public NikonBoardVO getBoard(NikonBoardVO vo) {
		NikonBoardVO board = null;
		try {
			con = DBConn.getConnection();
			String sql;
			sql ="update board set board_count=board_count+1 where board_num = ?"; 
			stmt = con.prepareStatement(sql); stmt.setInt(1, vo.getNum()); 
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
					board.setSubject(rs.getString("board_subject"));
					board.setContent(rs.getString("board_content"));
					board.setFile(rs.getString("board_file"));
					board.setReRef(rs.getInt("board_re_ref"));
					board.setReLevel(rs.getInt("board_re_lev"));
					board.setReSeq(rs.getInt("board_re_seq"));
					board.setCount(rs.getInt("board_count"));
					board.setResDate(rs.getDate("board_date"));
				}
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return board;
	}
	
    public NikonBoardVO getDetail(NikonBoardVO vo)  {    
        NikonBoardVO board = null;
        String sql;
        try {
            con = DBConn.getConnection();
            
            sql = "select * from BOARD where BOARD_NUM = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, vo.getNum());
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                board = new NikonBoardVO();
                board.setNum(rs.getInt("BOARD_NUM"));
                board.setId(rs.getString("BOARD_ID"));
                board.setSubject(rs.getString("BOARD_SUBJECT"));
                board.setContent(rs.getString("BOARD_CONTENT"));
                board.setFile(rs.getString("BOARD_FILE"));
                board.setCount(rs.getInt("BOARD_COUNT"));
                board.setReRef(rs.getInt("BOARD_RE_REF"));
                board.setReLevel(rs.getInt("BOARD_RE_LEV"));
                board.setReSeq(rs.getInt("BOARD_RE_SEQ"));
                board.setResDate(rs.getDate("BOARD_DATE"));
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
			DBConn.close(rs, stmt, con);
		}
        
        return board;
    } // end getDetail()

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
	
    public String getFileName(int boardNum) {
        String fileName = null;
        String sql;
        try {
            con = DBConn.getConnection();
            
            sql = "SELECT BOARD_FILE from BOARD where BOARD_NUM=?";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, boardNum);
            
            rs = stmt.executeQuery();
            if(rs.next()) fileName = rs.getString("BOARD_FILE");
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
			DBConn.close(rs, stmt, con);
		}        
        return fileName;
    } 

	
	public int deleteBoard(int boardNum) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from board where board_num=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardNum);
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
			String sql = "insert into board values (payment_seq, ?,?,?,?,?,?,?,sysdate)";
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
            String sql = "SELECT BOARD_NUM.NEXTVAL FROM DUAL";
            
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
  public int updateReSeq(NikonBoardVO board) {
      int cnt;
      int ref = board.getReRef();     // 원본글 번호(그룹번호)
      int seq = board.getReSeq();     // 답변글의 순서
      String sql = null;
      try {    
          con = DBConn.getConnection();
          
          // ref(그룹번호)와 seq(답글순서)을 확인하여 원본 글에 다른 답변 글이 있으면, 
          // 답변 글 중 답변 글보다 상위에 있는 글의 seq보다 높은 글의 seq값을 1씩 증가시킨다.
          sql = "update BOARD set BOARD_RE_SEQ = BOARD_RE_SEQ+1 where BOARD_RE_REF = ? and BOARD_RE_SEQ > ?";
          stmt = con.prepareStatement(sql);
          stmt.setInt(1, ref);
          stmt.setInt(2, seq);
          cnt = stmt.executeUpdate();          
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      } finally {
    	  DBConn.close(stmt, con);
      }
      return cnt;    
}

  public int boardReplyInsert(NikonBoardVO board) {
      int cnt;
      
      try {
          con = DBConn.getConnection();
          
          String sql = "INSERT INTO BOARD(BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_COUNT, BOARD_DATE) VALUES (?,?,?,?,?,?,?,?,?,sysdate)";

          // 시퀀스 값을 글번호와 그룹번호로 사용
          int num = board.getNum();
          stmt = con.prepareStatement(sql.toString());
          stmt.setInt(1, num);
          stmt.setString(2, board.getId());
          stmt.setString(3, board.getSubject());
          stmt.setString(4, board.getContent());
          stmt.setString(5, board.getFile());
          
          if(board.getReSeq()==0) {// re_seq==0 은 답변글이 없는경우, 즉 부모글일경우    
              stmt.setInt(6, num);    
          } else {
              stmt.setInt(6, board.getReRef());
          }
          stmt.setInt(7, board.getReLevel());
          stmt.setInt(8, board.getReSeq());
          stmt.setInt(9, 0);

          cnt = stmt.executeUpdate();          
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      } finally {
    	  DBConn.close(stmt, con);
      }
      return cnt;    
  }
}
