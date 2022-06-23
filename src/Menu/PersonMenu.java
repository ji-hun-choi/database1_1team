package Menu;

import Service.BookService;
import Service.NoticeService;
import Service.PersonService;
import Service.RentService;

import java.util.Scanner;

public class PersonMenu {
    private PersonService pservice;
    private BookService bservice;
    private RentService rservice;
    private NoticeService nservice;

    public PersonMenu(PersonService p){
        pservice = p;
        bservice = new BookService();
        rservice = new RentService();
        nservice = new NoticeService();
    }

    public void run(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("����� �ý��� �Դϴ�.");
            System.out.println("1.������ȸ | 2.�뿩���� | 3.�Խ�����ȸ | 4.�������� ���� " +
                    " | 5.�������� ��ȸ | 6.ȸ��Ż�� | 7.�α׾ƿ�");
            c = sc.nextInt();
            switch (c){
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
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

            }
        }
    }

    // �����ȸ, �뿩, �ݳ�, ����
    public void rentPerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("�뿩 �ý���");
            System.out.println(""); // ���� ���
            c = sc.nextInt();
            switch (c){

            }
        }
    }

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
