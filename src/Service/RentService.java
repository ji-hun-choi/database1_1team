package Service;

import java.util.Scanner;
import java.util.ArrayList;

import Dao.BookDao;
import Dao.RentDao;
import Vo.Rent;


public class RentService {
	private RentDao rdao;
	private BookDao bdao; // +�߰�
	private Rent r_vo; // +�߰�
	private String id;


	public RentService(String id) { // +�߰�
		rdao = new RentDao();
		bdao = new BookDao(); // +�߰�
		this.id = id; // +�߰�
	}

	
	public void addRent(Scanner sc) { //�� ���̵�� �뿩�� �ϴ� ���̴�. ������ ���� �Է¹޾Ƽ�.
		 int b_num = 0;
		 while (b_num == 0) {//b_num ������ �´��� Ȯ���ϴ� ��
			try {
		 		System.out.println("book number: ");
		 		b_num = Integer.parseInt(sc.next());
	 		}
			catch (NumberFormatException e) {
			   System.out.println("not a correct number!");
			   b_num = 0;
			}
		 }
		 boolean rent = bdao.rentCheck(b_num); // +�߰�
		 if(!rent) { //+�߰�// ���࿡ b_num���� ��ȸ�� å�� �뿩���°� "�뿩����"�̶��@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ true�� book�� rent == false�� �ٲٱ�!
			 int r_num = 0; // r_num�� auto_increment! �׳� �д�
			 String p_id = id; // ���̵�� ���� �޾Ƽ������� �ȴ�.@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ login���� ������ p_id�ֱ�!
			 
			 System.out.println("Enter start day: ");
			 String start_day = sc.next();
			 
			 sc.nextLine();		 
			 System.out.println("Enter end day: ");
			 String end_day = sc.next();
			 bdao.rentmodify(b_num); // +�߰�
			 String r_return = "";//�ݳ���¥�� ���� ���°��� ����.
			 
			 rdao.insert(new Rent(r_num, b_num, p_id, start_day, end_day, r_return));
			 return;

		 } else {
			 System.out.println("Book is already out for rent");
			 return;
		 }
		 
		 
		
	}
	
	public void updateRent(Scanner sc) {// r_num���� ã�Ƽ� UPDATE �ϴ� ���̴�.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num �� �����ϸ� ���
			 while (r_num == 0) {//r_num ������ �´��� Ȯ���ϴ� ��
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//�׷� r_num�� �ִ��� Ȯ���ϴ� ��.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		 
		 System.out.println(rdao.select_by_r_num(r_num));
		 
		 System.out.println("edit start");
		 
		 int b_num = 0;
		 while (b_num == 0) {//b_num ������ �´��� Ȯ���ϴ� ��
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
					 if (true) {//p_id �ִ��� Ȯ����@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ true�� p_id�� �ִ��� Ȯ���ϴ� dao�� �ٲٱ�.
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
	
	public void deleteRent(Scanner sc) {// r_num���� ã�Ƽ� delete �ϴ� ���̴�.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num �� �����ϸ� ���
			 while (r_num == 0) {//r_num ������ �´��� Ȯ���ϴ� ��
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//�׷� r_num�� �ִ��� Ȯ���ϴ� ��.
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
		
		while (r_num_flag == false) {//r_num �� �����ϸ� ���
			 while (r_num == 0) {//r_num ������ �´��� Ȯ���ϴ� ��
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//�׷� r_num�� �ִ��� Ȯ���ϴ� ��.
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
			 while (b_num == 0) {//r_num ������ �´��� Ȯ���ϴ� ��
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
	
	public void updateRentUser(Scanner sc) {// r_num���� ã�Ƽ� UPDATE �ϴ� ���̴�.
		int r_num = 0;
		boolean r_num_flag = false;
		
		while (r_num_flag == false) {//r_num �� �����ϸ� ���
			 while (r_num == 0) {//r_num ������ �´��� Ȯ���ϴ� ��
				try {
			 		System.out.println("Rent number: ");
			 		r_num = Integer.parseInt(sc.next());
		 		}
				catch (NumberFormatException e) {
				   System.out.println("not a correct number!");
				   r_num = 0;
				}
			 }
			 
			 if (rdao.select_by_r_num(r_num) != null) {//�׷� r_num�� �ִ��� Ȯ���ϴ� ��.
				 r_num_flag = true;
			 } else {
				 System.out.println("no r_num " + r_num);
				 r_num = 0;
			 }
		}
		r_vo = rdao.select_by_r_num(r_num);
		
		if(r_vo.getP_id() == id) {//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ p_id �� ���Ƽ� �ڱ�������� Ȯ��
			int b_num = r_vo.getB_num();
			String p_id = r_vo.getP_id();
			String start_day = r_vo.getStart_day();
			String end_day = r_vo.getEnd_day();
			String r_return = "000"; // "000" �� �ݳ����� �� �ܰ��� �� �Ͻ�.
			
			rdao.update(new Rent(r_num, b_num, p_id, start_day, end_day, r_return));
		} else {
			System.out.println("������ ���� å�� �ݳ��� �����մϴ�.");
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
