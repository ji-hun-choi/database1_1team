package Dao;

import Vo.Person;
import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao {

    private final MysqlConnect dbconn;
    private String id = "";
    private String pwd = "";
    private boolean adminCheck = false;
    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean isAdminCheck() {
        return adminCheck;
    }


    public PersonDao() {dbconn = MysqlConnect.getInstance();}

    public void insert(Person p) { // ok
        Connection conn = dbconn.getConn();

        String sql = "insert into Person(id, name, pwd,address, phone_num, admin_check) values(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getId());
            pstmt.setString(2, p.getName());
            pstmt.setString(3,p.getPwd());
            pstmt.setString(4,p.getAddress());
            pstmt.setString(5,p.getPhoneNum());
            pstmt.setBoolean(6,p.getAdminCheck());

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
    public String searchId(String name, String phonenum) { // ok
        Connection conn = dbconn.getConn();
        ResultSet rs;
        String sql = "select * from person where name=? and phone_num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, phonenum);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
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
        return "";
    }

    public boolean searchId(String id) { // ok
        Connection conn = dbconn.getConn();
        ResultSet rs;
        String sql = "select * from person where id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
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
        return false;
    }


    public String searchPwd(String id, String phonenum) { // ok
        Connection conn = dbconn.getConn();
        ResultSet rs ;
        String sql = "select * from person where id=? and phone_num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, phonenum);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString(3);
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
        return "";
    }

    public boolean login(String id, String pwd) { // ok
        Connection conn = dbconn.getConn();
        ResultSet rs;
        String sql = "select * from person where id=? and pwd=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();

            if(rs.next()){
                this.id = rs.getString(1);
                this.pwd = rs.getString(3);
                this.adminCheck = rs.getBoolean(6);
                return true;
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
        return false;
    }
    public boolean logout() { // ok
        if (id.equals("") && pwd.equals("")){
            return false;
        }
        else {
            this.id = "";
            this.pwd = "";
            this.adminCheck = false;
            return true;
        }
    }

    public void modify(Person p) { // ok
        Connection conn = dbconn.getConn();
        String sql = "update person set pwd=?, address=?, phone_num=? where id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getPwd());
            pstmt.setString(2, p.getAddress());
            pstmt.setString(3, p.getPhoneNum());
            pstmt.setString(4, p.getId());

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

    public Person selectOne(String id, String pwd){
        Connection conn = dbconn.getConn();
        ResultSet rs ;
        String sql = "select * from person where id=? and pwd=?";
        Person p = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            rs = pstmt.executeQuery();
            if (rs.next()){
                p = new Person(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6));
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
        return p;
    }

    public ArrayList<Person> selectAll(){ // ok
        Connection conn = dbconn.getConn();
        ResultSet rs;
        String sql = "select * from person order by name";
        ArrayList<Person> list = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6)));
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

    public boolean delete(String id, String pwd) {  // ok
        // 1. db¿¬°á
        Connection conn = dbconn.getConn();
        // 2. sql
        String sql = "delete from person where id=? and pwd=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                return true;
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
        return false;
    }

}
