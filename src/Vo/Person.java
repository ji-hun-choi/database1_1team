package Vo;

public class Person {
    private String id;
    private String name;
    private String pwd;
    private String address;

    private String phoneNum;
    private boolean adminCheck;

    public Person(){
    }

    public Person(String id, String pwd, String address, String phoneNum) {
        this.id = id;
        this.pwd = pwd;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public Person(String id, String name, String pwd, String address, String phoneNum, boolean adminCheck) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.address = address;
        this.phoneNum = phoneNum;
        this.adminCheck = adminCheck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean getAdminCheck() {
        return adminCheck;
    }

    public void setAdminCheck(boolean adminCheck) {
        this.adminCheck = adminCheck;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", adminCheck='" + adminCheck + '\'' +
                '}';
    }
}
