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
    
        // �������
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
    
        // ������ȣ�� �˻�
        public void getBookByNum(Scanner sc) {
            System.out.print("search num:");
            int num = sc.nextInt();
    
            Book p = dao.selectNum(num);
            if (p == null) {
                System.out.println("���� ������ȣ");
            } else {
                System.out.println(p);
            }
        }
    
    
        // �������� �˻�
        public void getBookByName(Scanner sc) {
            System.out.print("search name:");
            String name = sc.next();
    
            Book b = dao.selectName(name);
            if (b == null) {
                System.out.println("���� ����");
            } else {
                System.out.println(b);
            }
        }
    
        // ����
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
    
        // ����
        public void delBook(Scanner sc) {
            System.out.print("������ ������ȣ :");
            int num = sc.nextInt();
            dao.bookDelete(num);
            System.out.println("�����Ϸ�");
        }
    
        // ��ü��ȸ
        public void printAll() {
            ArrayList<Book> list = dao.bookSelectAll();
            for (Book p : list) {
                System.out.println(p);
            }
        }
    }
