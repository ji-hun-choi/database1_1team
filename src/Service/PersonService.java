package Service;

import Dao.PersonDao;
import Vo.Person;

import java.util.Scanner;

public class PersonService {
    private static String id = "";
    private static String pwd = "";
    private static boolean adminCheck = false;

    PersonDao dao ;
    public PersonService() {
        dao = new PersonDao();
    }

    public void insertPeople(Scanner sc) {
        System.out.println("회원가입");
        String id = "";
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
        Boolean admincheck = false;
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


}
