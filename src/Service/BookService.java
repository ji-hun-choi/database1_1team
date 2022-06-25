package Service;

import Dao.BookDao;
import Vo.Book;


import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
        private BookDao dao;
    
        public BookService() {
            dao = new BookDao();
        }
    
        // 도서등록
        public void addBook(Scanner sc) {

            System.out.print("name:");
            String name = sc.next();
            
            System.out.print("author:");
            String author = sc.next();
    
            System.out.print("genre:");
            String genre = sc.next();

            boolean rent = false;


           Book  p = new Book(name, author, genre , rent);
           dao.insert(p);
        }
    
        // 도서번호로 검색
        public void getBookByNum(Scanner sc) {
            System.out.print("search num:");
            int num = sc.nextInt();
    
            Book p = dao.selectNum(num);
            if (p == null) {
                System.out.println("없는 도서번호");
            } else {
                System.out.println(p);
            }
        }
    
    
        // 제목으로 검색
        public void getBookByName(Scanner sc) {
            System.out.print("search name:");
            String name = sc.next();
    
            Book b = dao.selectName(name);
            if (b == null) {
                System.out.println("없는 도서");
            } else {
                System.out.println(b);
            }
        }
    
        // 수정
        public void editBook(Scanner sc) {
            System.out.print("edit num:");
            int num = sc.nextInt();
    
            System.out.print("new name:");
            String name = sc.next();
    
            System.out.print("new author:");
            String author = sc.next();
    
            System.out.print("new genre:");
            String genre = sc.next();

            boolean rent = false;

            dao.update(new Book(num, name, author,genre,rent));
    
        }
    
        // 삭제
        public void delBook(Scanner sc) {
            System.out.print("삭제할 도서번호 :");
            int num = sc.nextInt();
            dao.bookDelete(num);
            System.out.println("삭제완료");
        }
    
        // 전체조회
        public void printAll() {
            ArrayList<Book> list = dao.bookSelectAll();
            for (Book p : list) {
                System.out.println(p);
            }
        }
    }
