package Menu;

import Service.BookService;
import Service.NoticeService;
import Service.PersonService;
import Service.RentService;

import java.util.Scanner;

public class AdminMenu {

    private PersonService pservice;
    private BookService bservice;
    private RentService rservice;
    private NoticeService nservice;

    public AdminMenu(PersonService p){
        pservice = p;
        bservice = new BookService();
        rservice = new RentService();
        nservice = new NoticeService();
    }
    public void run(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("관리자 시스템 입니다.");
            System.out.println("1.도서관리 | 2.대여관리 | 3.게시판관리 | 4.개인정보 변겅 " +
                    " | 5.개인정보 조회 | 6.모든 유저 보기 | 7.유저 삭제 | 8.로그아웃");
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
    // 추가, 수정, 삭제, 책 전체 조회, 상세조회, 종료
    public void bookAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("도서 관리");
            System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.전체조회 |" +
                    " 5.책이름조회 | 6.책번호조회 | 7.종료"); // 선택 목록
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

    // 전체조회, 수정, 하나만조회, 종료
    public void rentAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("대여 관리");
            System.out.println(""); // 선택 목록
            c = sc.nextInt();
            switch (c){

            }
        }

    }

    // 작성, 확인, 삭제, 수정, 전체확인, 종료
    public void noticeAdmin(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("게시판 관리");
            System.out.println(""); // 선택 목록
            c = sc.nextInt();
            switch (c){

            }
        }
    }
}
