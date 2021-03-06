package Service;

import Dao.PersonDao;
import Dao.RentDao;
import Vo.Person;
import Vo.Rent;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonService {
    private static String id = "";



    private static String pwd = "";
    private static boolean adminCheck = false;




    public static void setId(String id) {
        PersonService.id = id;
    }

    public static void setPwd(String pwd) {
        PersonService.pwd = pwd;
    }

    public static void setAdminCheck(boolean adminCheck) {
        PersonService.adminCheck = adminCheck;
    }

    public static String getId() {
        return id;
    }

    public static String getPwd() {
        return pwd;
    }

    public static boolean isAdminCheck() {
        return adminCheck;
    }

    PersonDao dao ;
    RentDao rdao;
    public PersonService() {
        dao = new PersonDao();
        rdao = new RentDao();
    }

    public void insertPeople(Scanner sc) {
        System.out.println("회원가입");
        String id;
        while (true) {
            System.out.print("id:");
            id = sc.next();
            if (dao.searchId(id)) {
                System.out.println("중복된 아이디입니다.");
            } else {
                break;
            }
        }
        System.out.print("name:");
        String name = sc.next();
        System.out.print("pwd:");
        String pwd = sc.next();
        System.out.print("address:");
        String address = sc.next();
        System.out.print("phone number:");
        String phonenum = sc.next();
        boolean admincheck = false;
        dao.insert(new Person(id, name,pwd,address,phonenum,admincheck));
    }

    public void insertAdmin(Scanner sc) {
        System.out.println("관리자 생성");
        String id;
        while (true) {
            System.out.print("id:");
            id = sc.next();
            if (dao.searchId(id)) {
                System.out.println("중복된 아이디입니다.");
            } else {
                break;
            }
        }
        System.out.print("name:");
        String name = sc.next();
        System.out.print("pwd:");
        String pwd = sc.next();
        System.out.print("address:");
        String address = sc.next();
        System.out.print("phone number:");
        String phonenum = sc.next();
        boolean admincheck = true;
        dao.insert(new Person(id, name,pwd,address,phonenum,admincheck));
    }

    public void peopleSearchId(Scanner sc){
        System.out.println("아이디 찾기");
        System.out.print("이름 입력");
        String name = sc.next();
        System.out.print("핸드폰번호 입력");
        String phone = sc.next();
        String answer = dao.searchId(name, phone);
        if (answer.equals("")){
            System.out.println("이름 혹은 번호 확인");
        } else {
            System.out.println("Id : " + answer);
        }
    }

    public void peopleSearchPwd(Scanner sc) {
        System.out.println("비밀번호 찾기");
        System.out.print("아이디");
        String id = sc.next();
        System.out.print("이름 입력");
        String name = sc.next();
        System.out.print("핸드폰번호 입력");
        String phone = sc.next();
        String answer = dao.searchPwd(id, name, phone);
        if (answer.equals("")){
            System.out.println("정보를 확인해 주세요.");
        } else {
            System.out.println("Pwd : " + answer);
        }
    }

    public void peopleLogin(Scanner sc) {
        System.out.println("로그인");
        System.out.print("아이디");
        String id = sc.next();
        System.out.print("비밀번호");
        String pwd = sc.next();
        if (dao.login(id, pwd)) {
            this.setId(id);
            this.setPwd(pwd);
            this.setAdminCheck(dao.getAdminCheck());
        }
        else {
            System.out.println("로그인 실패!");
        }
    }
// 이후 service는 로그인시에만 활성화
    public void peopleLogout(Scanner sc) {
        System.out.println("로그아웃");
        this.setId("");
        this.setPwd("");
        this.setAdminCheck(false);
        dao.logout();
    }

    public void peopleModify(Scanner sc) {
        System.out.println("개인정보 수정");
        String id = this.getId();
        System.out.println("비밀번호");
        String pwd = sc.next();
        this.setPwd(pwd);
        System.out.print("주소");
        String address = sc.next();
        System.out.print("번호");
        String phonenum = sc.next();

        dao.modify(new Person(id,pwd,address,phonenum));
    }

    public void peopleSelection(Scanner sc) {
        System.out.println("내 정보 보기");
        System.out.println(dao.selectOne(id, pwd));
    }

    public void peopleDelete(Scanner sc) { // 회원 탈퇴
        System.out.println("회원 탈퇴");
        System.out.print("정말로 탈퇴 하시겠습니까? Y or N : ");
        String choice = sc.next().toUpperCase();

        if (choice.equals("Y")){
            ArrayList<Rent> list = rdao.searchPid(id);
            for (Rent r : list){
                rdao.delete(r.getR_num());
            }
            dao.delete(id, pwd);
            System.out.println("삭제 되었습니다.");
            peopleLogout(sc);
        } else {
            System.out.println("취소 하였습니다.");
        }
    }

    // 이후 관리자
    public void peopleDeleteAdmin(Scanner sc) { // 회원 삭제
        System.out.println("회원 삭제");
        System.out.print("삭제할 아이디 입력:");
        String id = sc.next();
        System.out.print("비밀번호 입력:");
        String pwd = sc.next();
        System.out.print("정말로 삭제 하시겠습니까? Y or N : ");
        String choice = sc.next().toUpperCase();
        if (choice.equals("Y")){
            ArrayList<Rent> list = rdao.searchPid(id);
            for (Rent r : list){
                rdao.delete(r.getR_num());
            }
            dao.delete(id, pwd);
            System.out.println("삭제 되었습니다.");
        } else {
            System.out.println("실패");
        }
    }

    public void peopleAll(Scanner sc){
        ArrayList<Person> list = dao.selectAll();
        for (Person l : list){

            System.out.println(l);
        }
    }

}
