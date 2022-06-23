package Dao;

import Vo.Noticeboard;
import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeboardDao {
		// db연결 클래스
    private final MysqlConnect dbconn;
    private int num;
    private String title = "";
    private String content = "";
    private String p_id = "";

    public int getNum() {
        return num;
    }
    
    public String getTitle() {
        return title;
    }

    public String getcontent() {
        return content;
    }
    
    public String getP_id() {
        return p_id;
    }
    
    public NoticeboardDao() {dbconn = MysqlConnect.getInstance();}

    public void insert(Noticeboard p) { // 작성
        Connection conn = dbconn.getConn();

        String sql = "insert into Noticeboard(num, title, content,p_id) values(?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, p.getNum());
            pstmt.setString(2, p.getTitle());
            pstmt.setString(3,p.getContent());
            pstmt.setString(4,p.getP_id());

            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modify(Noticeboard p) { //수정
        Connection conn = dbconn.getConn();
        String sql = "update noticeboard set title=?, content=?, where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getTitle());
            pstmt.setString(2, p.getContent());
            pstmt.setInt(3, p.getNum());

            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Noticeboard> selectAll(){ //전체선택
        Connection conn = dbconn.getConn();
        ResultSet rs;
        String sql = "select * from Noticeboard order by name";
        ArrayList<Noticeboard> list = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Noticeboard(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public void delete(int num) { //삭제
        
        Connection conn = dbconn.getConn();
      
        String sql = "delete from Noticeboard where num=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
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
    }

}
