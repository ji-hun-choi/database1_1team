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
            System.out.println("사용자 시스템 입니다.");
            System.out.println("1.도서조회 | 2.대여관리 | 3.게시판조회 | 4.개인정보 변겅 " +
                    " | 5.개인정보 조회 | 6.회원탈퇴 | 7.로그아웃");
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

    // 전체조회, 상세조회, 종료  (불필요하다 생각드는건 빼주세요)
    public void bookPerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("도서 시스템");
            System.out.println(""); // 선택 목록
            c = sc.nextInt();
            switch (c){

            }
        }
    }

    // 기록조회, 대여, 반납, 종료
    public void rentPerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("대여 시스템");
            System.out.println(""); // 선택 목록
            c = sc.nextInt();
            switch (c){

            }
        }
    }

    // 전체확인
    public void noticePerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("게시판 시스템");
            System.out.println(""); // 선택 목록
            c = sc.nextInt();
            switch (c){

            }
        }
    }

}
