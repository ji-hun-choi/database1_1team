package Menu;

import Service.BookService;
import Service.NoticeService;
import Service.PersonService;
import Service.RentService;
import Vo.RentVo;
//import Service.RentService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    private PersonService pservice;
    private BookService bservice;
    private RentService rservice;
    private NoticeService nservice;

    public AdminMenu(PersonService p){
        pservice = p;
    }
    public void run(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("������ �ý��� �Դϴ�.");
            System.out.println("1.�������� | 2.�뿩���� | 3.�Խ��ǰ��� | 4.�������� ���� " +
                    " | 5.�������� ��ȸ | 6.��� ���� ���� | 7.���� ���� | 8.�α׾ƿ�");
            c = sc.nextInt();
            switch (c){
                case 1:
                    bookAdmin(sc);
                    break;
                case 2:
                    rentAdmin(sc);
                    break;
                case 3:
                    noticeAdmin(sc);
                    break;
                case 4:
                    pservice.peopleModify(sc);
                    break;
                case 5:
                    pservice.peopleSelection(sc);
                    break;
                case 6:
                    pservice.peopleAll(sc);
                    break;
                case 7:
                    pservice.peopleDeleteAdmin(sc);
                    break;
                case 8:
                    pservice.peopleLogout(sc);
                    flag = false;
                    break;
            }
        }
    }
    // �߰�, ����, ����, å ��ü ��ȸ, ����ȸ, ����
    public void bookAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("���� ����");
            System.out.println("1.�߰� | 2.���� | 3.���� | 4.��ü��ȸ |" +
                    " 5.å�̸���ȸ | 6.å��ȣ��ȸ | 7.����"); // ���� ���
            c = sc.nextInt();
            switch (c){
                case 1:
                    bservice.addBook(sc);
                    break;
                case 2:
                    bservice.editBook(sc);
                    break;
                case 3:
                    bservice.delBook(sc);
                    break;
                case 4:
                    bservice.printAll();
                    break;
                case 5:
                    bservice.getBookByName(sc);
                    break;
                case 6:
                    bservice.getBookByNum(sc);
                    break;
                case 7:
                    flag=false;
                    break;

            }
        }
    }

    // ��ü��ȸ, ����, �ϳ�����ȸ, ����
    public void rentAdmin(Scanner sc) {
        boolean flag = true;
        int c = 0;

        while (flag) {
            System.out.println("Admin �� Rent���� �ý���");
            System.out.println("1. ��üRent��� ��ȸ");
            System.out.println("2. Book�� �뿩��ϵ� ��ȸ");
            System.out.println("3. ���� �ϳ��� �뿩��ϵ� ��ȸ");
            System.out.println("4. �뿩��� ���� ��ȸ");
            System.out.println("5. Ư�� �뿩��� ����");
            System.out.println("6. Ư�� �뿩��� ����");
            System.out.println("7. �ݳ��� / ���� ��ȸ");
            System.out.println("8. ����");

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
                    System.out.println("�뿩��� ALL: ");
                    ArrayList<RentVo> list1 = rservice.selectAll();
                    for (RentVo rent : list1) {
                        System.out.println(rent);
                    }
                case (2):
                    System.out.println("Ư�� å�� �뿩��ϵ�: ");
                    ArrayList<RentVo> list2 = rservice.selectByBnum(sc);
                    for (RentVo rent : list2) {
                        System.out.println(rent);
                    }
                case (3):
                    System.out.println("�뿩��� ALL: ");
                    ArrayList<RentVo> list3 = rservice.selectByPid(sc);
                    for (RentVo rent : list3) {
                        System.out.println(rent);
                    }
                case (4):
                    System.out.println("���� �뿩��� ��ȸ: ");
                    RentVo rent = rservice.selectRentRnum(sc);
                    System.out.println(rent);
                case (5):
                    System.out.println("Ư�� �뿩��� ����");
                    rservice.updateRent(sc);
                case (6):
                    System.out.println("6. Ư�� �뿩��� ����");
                    rservice.deleteRent(sc);

                case (7):
                    System.out.println("�ݳ����� ��⵵������ r_return �� 000�� ������ �ֽ��ϴ�");
                    rservice.selectByRreturn(sc);

                case (8):
                    System.out.println("���� �մϴ�");
                    flag = false;
                    break;
            }

        }
    }

    // �ۼ�, Ȯ��, ����, ����, ��üȮ��, ����
    public void noticeAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("�Խ��� ����");
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

            }
        }
    }
}
