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
        System.out.println("ȸ������");
        String id = "";
        while (true) {
            System.out.print("id:");
            id = sc.next();
            if (dao.searchId(id)) {
                System.out.println("�ߺ��� ���̵��Դϴ�.");
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
        System.out.println("���̵� ã��");
        System.out.print("�̸� �Է�");
        String name = sc.next();
        System.out.print("�ڵ�����ȣ �Է�");
        String phone = sc.next();
        String answer = dao.searchId(name, phone);
        if (answer.equals("")){
            System.out.println("�̸� Ȥ�� ��ȣ Ȯ��");
        } else {
            System.out.println("Id : " + answer);
        }
    }


}
