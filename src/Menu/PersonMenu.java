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

    public PersonMenu(PersonService p) {
        pservice = p;
        bservice = new BookService();
        rservice = new RentService(pservice.getId());
        nservice = new NoticeService(pservice.getId());
    }

    public void run(Scanner sc) {
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("사용자 시스템 입니다.");
            System.out.println("1.도서조회 | 2.대여관리 | 3.게시판조회 | 4.개인정보 변겅 " +
                    " | 5.개인정보 조회 | 6.회원탈퇴 | 7.로그아웃");
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

    // 전체조회, 상세조회, 종료  (불필요하다 생각드는건 빼주세요)
    public void bookPerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("도서 시스템");
            System.out.println("1.전체조회 | 2.이름조회 | 3.번호조회 | 4.종료"); // 선택 목록
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


    // 기록조회, 대여, 반납, 종료

    public void rentPerson(Scanner sc) {
        boolean flag = true;
        int c = 0;

        while (flag) {
            System.out.println("Rent 일반 사용자 시스템");
            System.out.println("1. 책 대여 | 2. 내 대여목록 | 3. 책 반납하기 | 4. 종료"); // 선택 목록

            while (c == 0) { //숫자만 입력하는지 체크.
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
                    System.out.println("책을 대여합니다");
                    rservice.addRent(sc);
                    break;
                case (2):
                    System.out.println("내 대여목록");
                    rservice.selectByPidUser();//@@@@@@@@@@@@@@@@@@@@@@@@@@@@"" 를 u_id로 변환.
                    break;
                case (3):
                    System.out.println("책을 반납합니다");
                    rservice.updateRentUser(sc);
                    break;
                case (4):
                    System.out.println("종료 합니다");
                    flag = false;
                    break;
            }
        }
    }

    // 전체확인

    // 전체확인
    public void noticePerson(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("게시판 시스템");
            System.out.println("1.게시판 확인 | 2.종료"); // 선택 목록
            c = sc.nextInt();
            switch (c){
                case (1):
                    System.out.println("게시글 목록");
                    nservice.NoticeAll();
                    break;
                case (2):
                    System.out.println("종료 합니다");
                    flag=false;
                    break;
            }
        }
    }

}
