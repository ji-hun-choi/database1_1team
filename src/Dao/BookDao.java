package Dao;

import Vo.Book;
import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	private final MysqlConnect dbconn;

	public BookDao() {
		dbconn = MysqlConnect.getInstance();
	}


	// ���� ��� ��ü ��ȸ
	public ArrayList<Book> bookSelectAll() {
		String query = "SELECT * FROM Book";
		Connection conn = dbconn.getConn();
		ResultSet rs ;
		ArrayList<Book> bookList = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			while(rs.next()) {
				int num = rs.getInt("num");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				boolean rent = rs.getBoolean("rent");
				
				Book book = new Book(num, bname, author, genre, rent);
				
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return bookList;
	}

	// ���� �߰� 
	public void insert(Book b) {
		Connection conn = dbconn.getConn();
		String query = "INSERT INTO Book(bname, author, genre,rent) " +
				"values(?,?,?,?) ";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getname());
			pstmt.setString(2, b.getauthor());
			pstmt.setString(3, b.getgenre());
			pstmt.setBoolean(4, b.getrent());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	public void bookDelete(int num) {
		Connection conn = dbconn.getConn();
		String query = "DELETE FROM Book "
				     + "WHERE NUM = ?";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	// 2. ���� ���� ����
	public int update(Book book) {
		Connection conn = dbconn.getConn();
		String query = "update book set bname = ?, author = ?, genre = ?, rent = ? where num = ?";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getname());
			pstmt.setString(2, book.getauthor());
			pstmt.setString(3, book.getgenre());
			pstmt.setBoolean(4, book.getrent());
			pstmt.setInt(5, book.getnum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 3. ���� ���̵�� ��ȸ
	public Book selectNum(int num) {
		Connection conn = dbconn.getConn();
		String query = "SELECT * FROM BOOK "
				     + "WHERE NUM = ?";
		ResultSet rs;
		Book book = null;
	
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("num"),
								rs.getString("bname"),
								rs.getString("author"),
								rs.getString("genre"),
								rs.getBoolean("rent"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return book;
	}

	// 4. ���� �������� ��ȸ
	public Book selectName(String bookName) {
		Connection conn = dbconn.getConn();
		String query = "SELECT * FROM BOOK "
				     + "WHERE bname = ?";
		Book b = null;
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getBoolean(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return b;
	}
	public boolean rentCheck(int b_num) {
		Connection conn = dbconn.getConn();
		ResultSet rs;
		String query = "select rent from book where num = ?";
		boolean t = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				t = rs.getBoolean(1);
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
		return t;
	}

	public void rentmodify(int b_num) {
		Connection conn = dbconn.getConn();
		ResultSet rs;
		String query = "update book set rent = ? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1,true);
			pstmt.setInt(2, b_num);

			pstmt.executeUpdate();
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
}
