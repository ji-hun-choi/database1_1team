package project_t1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Vo.Rent_Vo

import conn.MysqlConnect;

public class Rent_Dao {
	private MysqlConnect myconn;
		
	public Rent_Dao() {
		myconn = MysqlConnect.getInstance();
	}
	
	//---------------------------------------------------
	public void insert(Rent_Vo r) {
		Connection conn = myconn.getConn();

		String sql = "insert into rent(b_num, p_id, start_day, end_day, r_return) values(?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);// PreparedStatement 객체 생성.

			//pstmt.setInt(1, r.getR_num());
			pstmt.setInt(1, r.getB_num());
			pstmt.setString(2, r.getP_id());
			pstmt.setString(3, r.getStart_day());
			pstmt.setString(4, r.getEnd_day());
			pstmt.setString(5, r.getR_return());
	
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "addition complete");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//-------------------------------
	public ArrayList<Rent_Vo> selectAll() {
		ResultSet rs = null;
		ArrayList<Rent_Vo> list = new ArrayList<Rent_Vo>();

		Connection conn = myconn.getConn();

		String sql = "select * from rent order by r_num";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//-------------------------------
	public Rent_Vo select_by_r_num(int r_num) {// r_num 기준 검색
		ResultSet rs;
		Rent_Vo r = null; 

		Connection conn = myconn.getConn();

		String sql = "select * from rent where r_num=?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
	
			pstmt.setInt(1, r_num);

			rs = pstmt.executeQuery();


			if (rs.next()) {
				int r_num1 = rs.getInt(1);
				int b_num = rs.getInt(2);
				String p_id = rs.getString(3);
				String start_day = rs.getString(4);
				String end_day = rs.getString(5);
				String r_return = rs.getString(6);
				r = new Rent_Vo(r_num1, b_num, p_id, start_day, end_day, r_return);
			} else {
				System.out.println("no such r_num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}

	//-----------------------------------------------------
	public ArrayList<Rent_Vo> select_by_p_id(String p_id) {// p_id 기준 검색
		ResultSet rs = null;
		ArrayList<Rent_Vo> list = new ArrayList<Rent_Vo>();

		Connection conn = myconn.getConn();

		String sql = "select * from rent where p_id=? order by r_num";
		

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				while (rs.next()) {
					list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
			}else {
				System.out.println("no rent found by " + p_id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<Rent_Vo> select_by_r_return(String r_return) {// r_return 기준 검색
		ResultSet rs = null;
		ArrayList<Rent_Vo> list = new ArrayList<Rent_Vo>();

		Connection conn = myconn.getConn();

		String sql = "select * from rent where r_return=? order by r_num";
		

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r_return);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				while (rs.next()) {
					list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
			}else {
				System.out.println("no rent of r_return " + r_return);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//-------------------------------	
	public ArrayList<Rent_Vo> select_by_b_num(int b_num) {// b_num 기준 검색
		ResultSet rs = null;
		ArrayList<Rent_Vo> list = new ArrayList<Rent_Vo>();

		Connection conn = myconn.getConn();

		String sql = "select * from rent where b_num=? order by r_num";
		

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				while (rs.next()) {
					list.add(new Rent_Vo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
			}else {
				System.out.println("no rent of book_id: " + b_num + " found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//------------------------------
	public void update(Rent_Vo r) { // 싸그리 세로 입력받은 Rent_Vo를 r_num 로 찾아서 update함
		Connection conn = myconn.getConn();

		String sql = "update rent set b_num=?, p_id=?,start_day=? ,end_day=? ,r_return=? where r_num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, r.getB_num());
			pstmt.setString(2, r.getP_id());
			pstmt.setString(3, r.getStart_day());
			pstmt.setString(4, r.getEnd_day());
			pstmt.setString(5, r.getR_return());
			pstmt.setInt(6, r.getR_num());

			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "Edit Complete");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	//----------------------------------
	public void delete(int r_num) { //r_num 기준 삭제.

		Connection conn = myconn.getConn();


		String sql = "delete from rent where r_num=?";// ?는 변수값이 들어갈 자리

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);// PreparedStatement 객체 생성.

			pstmt.setInt(1, r_num);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "Deleted!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//-------------------------추후추가됨
	public ArrayList<Rent_Vo> searchPid(String id){
		Connection conn = myconn.getConn();
		ResultSet rs;
		ArrayList<Rent_Vo> list = new ArrayList<>();
		String sql = "select r_num from person inner join rent where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()){
				list.add(new Rent_Vo(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
