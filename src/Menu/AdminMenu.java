package Menu;

import Service.BookService;
import Service.NoticeService;
import Service.PersonService;
//import Service.RentService;

import java.util.Scanner;

public class AdminMenu {

    private PersonService pservice;
    private BookService bservice;
//    private RentService rservice;
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
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

            }
        }
    }

    // ��ü��ȸ, ����, �ϳ�����ȸ, ����
    public void rentAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("�뿩 ����");
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

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
