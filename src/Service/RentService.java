package Service;

import java.util.Scanner;
import java.util.ArrayList;

import Dao.BookDao;
import Dao.RentDao;
import Vo.Rent;


public class RentService {
	private RentDao rdao;
	private BookDao bdao; // +추가
	private Rent r_vo; // +추가
	private String id;


	public RentService(String id) { // +추가
		rdao = new RentDao();
		bdao = new BookDao(); // +추가
		this.id = id; // +추가
	}

	
	public void addRent(Scanner sc) { //내 아이디로 대여를 하는 것이다. 나머지 값은 입력받아서.
		 int b_num = 0;
		 while (b_num == 0) {//b_num 형식이 맞는지 확인하는 문
			try {
		 		System.out.println("book number: ");
		 		b_num = Integer.parseInt(sc.next());
	 		}
			catch (NumberFormatException e) {
			   System.out.println("not a correct number!");
			   b_num = 0;
			}
		 }
		 boolean rent = bdao.rentCheck(b_num); // +추가
		 if(!rent) { //+추가// 만약에 b_num으로 조회한 책의 대여상태가 "대여가능"이라면@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ true를 book의 rent == false로 바꾸기!
			 int r_num = 0; // r_num은 auto_increment! 그냥 둔다
			 String p_id = id; // 아이디는 따로 받아서넣으면 된다.@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ login에서 가져온 p_id넣기!
			 
			 System.out.println("Enter start day: ");
			 String start_day = sc.next();
			 
			 sc.nextLine();		 
			 System.out.println("Enter end day: ");
			 String end_day = sc.next();
			 bdao.rentmodify(b_num); // +추가
			 String r_return = "";//반납날짜는 아직 없는것이 맞음.
			 
			 rdao.insert(new Rent(r_num, b_num, p_id, start_day, end_day, r_return));
			 return;

		 } else {
			 System.out.println("Book is already out for rent");
			 return;
		 }
		 
		 
		
	}
	
	public void updateRent(Scanner sc) {// r_num으로 찾아서 UPDATE 하는 것이다.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num 이 존재하면 통과
			 while (r_num == 0) {//r_num 형식이 맞는지 확인하는 문
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//그런 r_num이 있는지 확인하는 문.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		 
		 System.out.println(rdao.select_by_r_num(r_num));
		 
		 System.out.println("edit start");
		 
		 int b_num = 0;
		 while (b_num == 0) {//b_num 형식이 맞는지 확인하는 문
			try {
		 		System.out.println("Book number: ");
		 		b_num = Integer.parseInt(sc.next());
	 		}
			catch (NumberFormatException e) {
			   System.out.println("not a correct number!");
			   b_num = 0;
			}
		 }
		 
		 System.out.println("p_id: ");
		 String p_id = "";
		 boolean p_id_flag = true;
		 while (p_id_flag) {
			 p_id = sc.next();
					 if (true) {//p_id 있는지 확인차@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ true를 p_id가 있는지 확인하는 dao로 바꾸기.
						 p_id_flag = false;
					 } else {
						 System.out.println("no such p_id as " + p_id);
						 p_id = "";
					 }
		 }
		 
		 System.out.println("start_day: ");
		 String start_day = sc.next();
		 System.out.println("end_day: ");
		 String end_day = sc.next();
		 System.out.println("r_return: ");
		 String r_return = sc.next();		 
		 
		rdao.update(new Rent(r_num, b_num, p_id, start_day, end_day, r_return));
		
		return;
	}
	
	public void deleteRent(Scanner sc) {// r_num으로 찾아서 delete 하는 것이다.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num 이 존재하면 통과
			 while (r_num == 0) {//r_num 형식이 맞는지 확인하는 문
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//그런 r_num이 있는지 확인하는 문.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		 
		 System.out.println(rdao.select_by_r_num(r_num));
		 
		 System.out.println("Delete?");
		 System.out.println("'1'yes    '2'no ");
		 
		 int yn = 0;
		 while (yn == 0) {
			 try {
				 yn = Integer.parseInt(sc.next());
			 } catch (Exception e){
				 yn = 0;
			 }
			 if (yn == 1) {
				 rdao.delete(r_num);
				 return;
			 } else if (yn == 2) {
				 System.out.println("no deletion");
				 return;
			 } else {
				 System.out.println("enter 1 or 2. ");
				 yn = 0;
			 }
		 }		 
		 return;
	}
	
	public Rent selectRentRnum(Scanner sc) {
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num 이 존재하면 통과
			 while (r_num == 0) {//r_num 형식이 맞는지 확인하는 문
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//그런 r_num이 있는지 확인하는 문.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		 
		r_vo = rdao.select_by_r_num(r_num);
				
		return r_vo;
	}

	public ArrayList<Rent> selectAll() {
		ArrayList<Rent> list = null;
		list = rdao.selectAll();
		
		return(list); 
	}
	
	public ArrayList<Rent> selectByBnum(Scanner sc) {
		ArrayList<Rent> list = null;
		
		int b_num = 0;
			 while (b_num == 0) {//r_num 형식이 맞는지 확인하는 문
				try {
			 		System.out.println("Book number: ");
			 		b_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   b_num = 0;
				}
			}
		list = rdao.select_by_b_num(b_num);
	return list;
	}
	
	public ArrayList<Rent> selectByPid(Scanner sc) {
		ArrayList<Rent> list = null;
		
		System.out.println("Enter p_id: ");
		String p_id = sc.next();
		list = rdao.select_by_p_id(p_id);
	
	return(list); 
	}
	
	public void selectByPidUser() {
		ArrayList<Rent> list = rdao.select_by_p_id(id);
		for (Rent r : list){
			System.out.println(r);
		}

	}
	
	public void updateRentUser(Scanner sc) {// r_num으로 찾아서 UPDATE 하는 것이다.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num 이 존재하면 통과
			 while (r_num == 0) {//r_num 형식이 맞는지 확인하는 문
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//그런 r_num이 있는지 확인하는 문.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		r_vo = rdao.select_by_r_num(r_num);
		
		if(r_vo.getP_id() == id) {//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ p_id 가 같아서 자기것인지를 확인
			int b_num = r_vo.getB_num();
			String p_id = r_vo.getP_id();
			String start_day = r_vo.getStart_day();
			String end_day = r_vo.getEnd_day();
			String r_return = "000"; // "000" 이 반납승인 전 단계라는 것 암시.
			
			rdao.update(new Rent(r_num, b_num, p_id, start_day, end_day, r_return));
		} else {
			System.out.println("본인이 빌린 책만 반납이 가능합니다.");
		}
		return;
	}
	
	
	
	public ArrayList<Rent> selectByRreturn(Scanner sc) {
		ArrayList<Rent> list = null;
		
		System.out.println("Enter r_return: ");
		String r_return = sc.next();
		list = rdao.select_by_r_return(r_return);
	
	return(list); 
	}
}
