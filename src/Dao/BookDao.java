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


	// 도서 목록 전체 조회
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
				String name = rs.getString("name");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				boolean rent = rs.getBoolean("rent");
				
				Book book = new Book(num, name, author, genre, rent);
				
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

	// 도서 추가 
	public void insert(Book b) {
		Connection conn = dbconn.getConn();
		String query = "INSERT INTO Book "
				     + "VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(?, 'RRRR/MM/DD'), ?)";
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

	// 2. 도서 정보 수정
	public int update(Book book) {
		Connection conn = dbconn.getConn();
		String query = "UPDATE BOOK "
				     + "SET NAME = ?, AUTHOR = ?, GENRE = ?, RENT = ?"
				     + "WHERE num = ?";
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

	// 3. 도서 아이디로 조회
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
				book = new Book(rs.getInt("NUM"),
								rs.getString("NAME"),
								rs.getString("AUTHOR"),
								rs.getString("GENRE"),
								rs.getBoolean("RENT"));
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

	// 4. 도서 제목으로 조회
	public Book selectTitle(String bookTitle) {
		Connection conn = dbconn.getConn();
		String query = "SELECT * FROM BOOK "
				     + "WHERE title = ?";
		Book b = null;
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			
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

}
