package Service;

import Dao.NoticeboardDao;
import Vo.Noticeboard;

import java.util.ArrayList;
import java.util.Scanner;

public class NoticeService {
	private static int num;
	
	private static String title;
	
	private static String content;
	
	private static String p_id;
	
    public static void setNum(int num) {
        NoticeService.num = num;
    }

    public static void setTitle(String title) {
        NoticeService.title = title;
    }

    public static void setContent(String content) {
        NoticeService.content = content;
    }
    
    public static void setP_id(String p_id) {
        NoticeService.p_id = p_id;
    }
    
    public static int getNum() {
        return num;
    }

    public static String getTitle() {
        return title;
    }
    
    public static String getContent() {
        return content;
    }
    
    public static String getP_id() {
        return p_id;
    }

    NoticeboardDao dao ;

    public NoticeService(String id){
        dao = new NoticeboardDao();
        setP_id(id);
    }

    public void Noticeinsert(Scanner sc) {
        System.out.println("�Խñ��ۼ�");
        System.out.print("����:");
        String title = sc.next();
        System.out.print("����:");
        String content = sc.next();
        String p_id = getP_id();
        dao.insert(new Noticeboard(0,title, content,p_id));
    }

    public void NoticeModify(Scanner sc) {
        System.out.println("������ �Խñ� ��ȣ����");
        int num = sc.nextInt();
        System.out.println("���� ����");
        String title = sc.next();
        System.out.print("���� ����");
        String content = sc.next();

        dao.modify(new Noticeboard(num, title, content));
    }
    
     public void NoticeDelete(Scanner sc) {
         System.out.println("�Խñ� ����");
	    System.out.println("������ �Խñ۹�ȣ�Է�");
         int num = sc.nextInt();
         System.out.print("������ ���� �Ͻðڽ��ϱ�? Y or N");
         String choice = sc.next().toUpperCase();

         if (choice.equals("Y")){
             dao.delete(num);
             System.out.println("���� �Ǿ����ϴ�.");
         } else {
                System.out.println("��� �Ͽ����ϴ�.");
    }
   }
         
         public void NoticeAll(){
             ArrayList<Noticeboard> list = dao.selectAll();
             for (Noticeboard l : list){
                 System.out.println(l);
  }
 }
}
