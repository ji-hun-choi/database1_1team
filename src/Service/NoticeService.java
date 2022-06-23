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
        System.out.println("게시글작성");
        System.out.print("제목:");
        String title = sc.next();
        System.out.print("내용:");
        String content = sc.next();
        String p_id = getP_id();
        dao.insert(new Noticeboard(0,title, content,p_id));
    }

    public void NoticeModify(Scanner sc) {
        System.out.println("수정할 게시글 번호선택");
        int num = sc.nextInt();
        System.out.println("제목 수정");
        String title = sc.next();
        System.out.print("내용 수정");
        String content = sc.next();

        dao.modify(new Noticeboard(num, title, content));
    }
    
     public void NoticeDelete(Scanner sc) {
         System.out.println("게시글 삭제");
	    System.out.println("삭제할 게시글번호입력");
         int num = sc.nextInt();
         System.out.print("정말로 삭제 하시겠습니까? Y or N");
         String choice = sc.next().toUpperCase();

         if (choice.equals("Y")){
             dao.delete(num);
             System.out.println("삭제 되었습니다.");
         } else {
                System.out.println("취소 하였습니다.");
    }
   }
         
         public void NoticeAll(){
             ArrayList<Noticeboard> list = dao.selectAll();
             for (Noticeboard l : list){
                 System.out.println(l);
  }
 }
}
