package Menu;

import Service.BookService;
import Service.NoticeService;
import Service.PersonService;
import Service.RentService;
import Vo.RentVo;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMenu {
    private PersonService pservice;
    private BookService bservice;
    private RentService rservice;
    private NoticeService nservice;

    public PersonMenu(PersonService p) {
        pservice = p;
        bservice = new BookService();
//        rservice = new RentService();
        nservice = new NoticeService();
    }

    public void run(Scanner sc) {
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("����� �ý��� �Դϴ�.");
            System.out.println("1.������ȸ | 2.�뿩���� | 3.�Խ�����ȸ | 4.�������� ���� " +
                    " | 5.�������� ��ȸ | 6.ȸ��Ż�� | 7.�α׾ƿ�");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    bookPerson(sc);
                    break;
                case 2:
                    rentPerson(sc);
                    break;
                case 3:
                    noticePerson(sc);
                    break;
                case 4:
                    pservice.peopleModify(sc);
                    break;
                case 5:
                    pservice.peopleSelection(sc);
                    break;
                case 6:
                    pservice.peopleDelete(sc);
                    flag = false;
                    break;
                case 7:
                    pservice.peopleLogout(sc);
                    flag = false;
                    break;
            }
        }
    }

    // ��ü��ȸ, ����ȸ, ����  (���ʿ��ϴ� ������°� ���ּ���)
    public void bookPerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("���� �ý���");
            System.out.println("1.��ü��ȸ | 2.�̸���ȸ | 3.��ȣ��ȸ | 4.����"); // ���� ���
            c = sc.nextInt();
            switch (c){
                case 1:
                    bservice.printAll();
                    break;
                case 2:
                    bservice.getBookByName(sc);
                    break;
                case 3:
                    bservice.getBookByNum(sc);
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }


    // �����ȸ, �뿩, �ݳ�, ����

    public void rentPerson(Scanner sc) {
        boolean flag = true;
        int c = 0;

        while (flag) {
            System.out.println("Rent �Ϲ� ����� �ý���");
            System.out.println("1. å �뿩�ϱ�"); // ���� ���
            System.out.println("2. �� �뿩���");
            System.out.println("3. å �ݳ��ϱ�");
            System.out.println("4. ����");

            while (c == 0) { //���ڸ� �Է��ϴ��� üũ.
                try {
                    System.out.println("Enter number: ");
                    c = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("not a correct number!");
                    c = 0;
                }
            }

            switch (c) {
                case (1):
                    System.out.println("å�� �뿩�մϴ�");
                    rservice.addRent(sc);
                case (2):
                    System.out.println("�� �뿩���");
                    ArrayList<RentVo> list1 = rservice.selectByPidUser("");//@@@@@@@@@@@@@@@@@@@@@@@@@@@@"" �� u_id�� ��ȯ.
                    for (RentVo rent : list1) {
                        System.out.println(rent);
                    }
                case (3):
                    System.out.println("å�� �ݳ��մϴ�");
                    rservice.updateRentUser(sc);
                case (4):
                    System.out.println("���� �մϴ�");
                    flag = false;
                    break;
            }
        }
    }

    // ��üȮ��

    // ��üȮ��
    public void noticePerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("�Խ��� �ý���");
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

            }
        }
    }

}
