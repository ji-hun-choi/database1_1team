package Vo;

public class Noticeboard {
		// �Խñ۹�ȣ
		private int num;
		// �Խñ�����
		private String title;
		// �Խñ۳���
		private String content;

	public Noticeboard(int num, String title, String content) {
		this.num = num;
		this.title = title;
		this.content = content;
	}

	// �ۼ���ID
		private String p_id;
		
		public Noticeboard() {	
		}

	
		public Noticeboard(int num, String title, String content, String p_id) {
		    this.num = num;
		    this.title = title;
		    this.content = content;
		    this.p_id = p_id;
		}



	public int getNum() {
		    return num;
		}

		public void setNum(int num) {
		    this.num = num;
		}

		public String getTitle() {
		    return title;
		}

		public void setTitle(String title) {
		    this.title = title;
		}

		public String getContent() {
		    return content;
		}

		public void setContent(String content) {
		    this.content = content;
		}

		public String getP_id() {
		    return p_id;
		}

		public void setP_id(String p_id) {
		    this.p_id = p_id;
		}
		
		public String toString() {
		    return " �Խñ� ��ȣ : "+this.num+ 
		    		" / ���� : " +this.title +
		    		" / ���� : " + this.content + 
		    		" / ID : " + this.p_id;
		} 
	}
