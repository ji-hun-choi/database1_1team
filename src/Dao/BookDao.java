package Dao;

import Vo.Book;
import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	// 도서 목록 전체 조회
	public List<Book> bookSelectAll(Connection conn) {
		String query = "SELECT * FROM Book";
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				String rent = rs.getboolean("rent");
				
				Book book = new Book(num, name, author, genre, rent);
				
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return bookList;
	}

	// 도서 추가
	public int bookInsert(Connection conn, Book b) {
		String query = "INSERT INTO Book "
				     + "VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(?, 'RRRR/MM/DD'), ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getname());
			pstmt.setString(2, b.getauthor());
			pstmt.setString(3, b.getgenre());
			pstmt.setSboolean(4, b.getrent());
	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int bookDelete(Connection conn, int num) {
		String query = "DELETE FROM Book "
				     + "WHERE NUM = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	// 2. 도서 정보 수정
	public int bookUpdate(Connection conn, Book book) {
		String query = "UPDATE BOOK "
				     + "SET NAME = ?, AUTHOR = ?, GENRE = ?, RENT = ?"
				     + "WHERE num = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getname());
			pstmt.setString(2, book.getauthor());
			pstmt.setString(3, book.getgenre());
			pstmt.setString(4, book.getrent());
			pstmt.setInt(5, book.getnum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 4. 도서 아이디로 조회
	public Book bookSelectId(Connection conn, int num) {
		String query = "SELECT * FROM BOOK "
				     + "WHERE NUM = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book(rs.getInt("NUM"),
								rs.getString("NAME"),
								rs.getString("AUTHOR"),
								rs.getString("GENRE"),
								rs.getString("RENT"),

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return book;
	}

	// 5. 도서 제목으로 조회
	public List<Book> bookSelectTitle(Connection conn, String bookTitle) {
		String query = "SELECT * FROM BOOK "
				     + "WHERE NAME LIKE ('%' || ? || '%')";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> listBook = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setnum(rs.getInt("NUM"));
				b.setTitle(rs.getString("NAME"));
				b.setAuthor(rs.getString("AUTHOR"));
				b.setPublisher(rs.getString("GENRE"));
				b.setPublisher(rs.getboolean("RENT"));
		
				
				listBook.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listBook;
	}

}
