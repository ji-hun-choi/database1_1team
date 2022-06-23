package Service;

import Dao.PersonDao;
import Vo.Person;

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
    public PersonService() {
        dao = new PersonDao();
    }

    public void insertPeople(Scanner sc) {
        System.out.println("ȸ������");
        String id;
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
        boolean admincheck = false;
        dao.insert(new Person(id, name,pwd,address,phonenum,admincheck));
    }

    public void insertAdmin(Scanner sc) {
        System.out.println("������ ����");
        String id;
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
        boolean admincheck = true;
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

    public void peopleSearchPwd(Scanner sc) {
        System.out.println("��й�ȣ ã��");
        System.out.print("���̵�");
        String id = sc.next();
        System.out.print("�̸� �Է�");
        String name = sc.next();
        System.out.print("�ڵ�����ȣ �Է�");
        String phone = sc.next();
        String answer = dao.searchPwd(id, name, phone);
        if (answer.equals("")){
            System.out.println("������ Ȯ���� �ּ���.");
        } else {
            System.out.println("Pwd : " + answer);
        }
    }

    public void peopleLogin(Scanner sc) {
        System.out.println("�α���");
        System.out.print("���̵�");
        String id = sc.next();
        System.out.print("��й�ȣ");
        String pwd = sc.next();
        if (dao.login(id, pwd)) {
            this.setId(id);
            this.setPwd(pwd);
            this.setAdminCheck(dao.getAdminCheck());
        }
        else {
            System.out.println("�α��� ����!");
        }
    }
// ���� service�� �α��νÿ��� Ȱ��ȭ
    public void peopleLogout(Scanner sc) {
        System.out.println("�α׾ƿ�");
        this.setId("");
        this.setPwd("");
        this.setAdminCheck(false);
        dao.logout();
    }

    public void peopleModify(Scanner sc) {
        System.out.println("�������� ����");
        String id = this.getId();
        System.out.println("��й�ȣ");
        String pwd = sc.next();
        this.setPwd(pwd);
        System.out.print("�ּ�");
        String address = sc.next();
        System.out.print("��ȣ");
        String phonenum = sc.next();

        dao.modify(new Person(id,pwd,address,phonenum));
    }

    public void peopleSelection(Scanner sc) {
        System.out.println("�� ���� ����");
        System.out.println(dao.selectOne(id, pwd));
    }

    public void peopleDelete(Scanner sc) { // ȸ�� Ż��
       System.out.println("ȸ�� Ż��");
        System.out.print("������ ���� �Ͻðڽ��ϱ�? Y or N");
        String choice = sc.next().toUpperCase();

        if (choice.equals("Y")){
            dao.delete(id, pwd);
            System.out.println("���� �Ǿ����ϴ�.");
            peopleLogout(sc);
        } else {
            System.out.println("��� �Ͽ����ϴ�.");
        }
    }

    // ���� ������
    public void peopleDeleteAdmin(Scanner sc) { // ȸ�� Ż��
        System.out.println("ȸ�� ����");
        System.out.print("������ ���̵� �Է�:");
        String id = sc.next();
        System.out.print("��й�ȣ �Է�:");
        String pwd = sc.next();
        if (dao.delete(id, pwd)){
            System.out.println("���� �Ǿ����ϴ�.");
        } else {
            System.out.println("����");
        }
    }

    public void peopleAll(Scanner sc){
        ArrayList<Person> list = dao.selectAll();
        for (Person l : list){
            System.out.println(l);
        }
    }

}
