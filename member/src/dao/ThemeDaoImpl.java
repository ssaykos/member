package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ThemeBean;

public class ThemeDaoImpl implements CommonDao {
	Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    ThemeBean bean = new ThemeBean();
	@Override
	public int insert(Object obj) {
		int result = 0;
		
		 try {
	            conn.setAutoCommit(false);
	            
	            if (bean.getParentId() == 0) { 
	                // 답글이 아닌 경우 그룹번호를 새롭게 구한다.
	                stmt = conn.createStatement(); 
	                rs = stmt.executeQuery(
	                    "select max(GROUP_ID) from THEME_MESSAGE"); 
	                int maxGroupId = 0; 
	                if (rs.next()) {
	                    maxGroupId = rs.getInt(1); 
	                }
	                maxGroupId++;
	                
	                bean.setGroupId(maxGroupId);
	                bean.setOrderNo(0);
	            } else {
	                // 특정 글의 답글인 경우,
	                // 같은 그룹 번호 내에서의 출력 순서를 구한다.  
	                pstmt = conn.prepareStatement( 
	                "select max(ORDER_NO) from THEME_MESSAGE "+ 
	                "where PARENT_ID = ? or THEME_MESSAGE_ID = ?"); 
	                pstmt.setInt(1, bean.getParentId());
	                pstmt.setInt(2, bean.getParentId());
	                rs = pstmt.executeQuery();
	                int maxOrder = 0;
	                if (rs.next()) {
	                    maxOrder = rs.getInt(1);
	                }
	                maxOrder ++;
	                bean.setOrderNo(maxOrder); 
	            }
	            
	            // 특정 글의 답변 글인 경우 같은 그룹 내에서
	            // 순서 번호를 변경한다.
	            if (bean.getOrderNo() > 0) {
	                pstmt = conn.prepareStatement(
	                "update THEME_MESSAGE set ORDER_NO = ORDER_NO + 1 "+
	                "where GROUP_ID = ? and ORDER_NO >= ?");
	                pstmt.setInt(1, bean.getGroupId()); 
	                pstmt.setInt(2, bean.getOrderNo()); 
	                pstmt.executeUpdate();
	            }
	            // 새로운 글의 번호를 구한다.
	            bean.setId(0);
	            // 글을 삽입한다.
	            pstmt = conn.prepareStatement( 
	            "insert into THEME_MESSAGE values (?,?,?,?,?,?,?,?,?,?,?)");
	            pstmt .setInt(1, bean.getId());
	            pstmt .setInt(2, bean.getGroupId());
	            pstmt .setInt(3, bean.getOrderNo());
	            pstmt .setInt(4, bean.getLevel()); 
	            pstmt .setInt(5, bean.getParentId());
	         //   pstmt .set(6, bean.getRegister());
	            pstmt .setString(7, bean.getName());
	            pstmt .setString(8, bean.getEmail());
	            pstmt .setString(9, bean.getImage());
	            pstmt .setString(10, bean.getPassword());
	            pstmt .setString(11, bean.getTitle()); 
	            pstmt .executeUpdate(); 
	            
	            pstmt  = conn.prepareStatement( 
	            "insert into THEME_CONTENT values (?,?)");
	            pstmt .setInt(1, bean.getId());
	            pstmt .setCharacterStream(2,null);
	            pstmt .executeUpdate(); 
	            
	            conn.commit();
	        } catch(Exception ex) {
	           	            
	            ex.printStackTrace();
	        } finally { 
	            
	        }
		 
		return result;
	}

	@Override
	public int count() {
		int count = 0;
		
		return count;
	}

	@Override
	public Object getElementById(String id) {
		Object obj= null;
		return obj;
	}

	@Override
	public List<Object> getElementsByName(String name) {
		List<Object> list = new ArrayList<Object>();
		return list;
	}

	@Override
	public List<Object> list() {
		List<Object> list = new ArrayList<Object>();
		return list;
	}

	@Override
	public int update(Object obj) {
		int result = 0;
		
		try {
            
            
            pstmt = conn.prepareStatement( 
                "update THEME_MESSAGE set NAME=?,EMAIL=?,IMAGE=?,TITLE=? "+ 
                "where THEME_MESSAGE_ID=?");
            pstmt = conn.prepareStatement( 
                "update THEME_CONTENT set CONTENT=? "+
                "where THEME_MESSAGE_ID=?"); 
            
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getEmail());
            pstmt.setString(3, bean.getImage());
            pstmt.setString(4, bean.getTitle());
            pstmt.setInt(5, bean.getId());
            pstmt.executeUpdate(); 
            
            pstmt.setCharacterStream(1, null);
            pstmt.setInt(2, bean.getId());
            pstmt.executeUpdate(); 
            
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            
        } finally { 
            
        }
		
		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		
		return result;
	}

}
