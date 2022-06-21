package Vo;

public class Noticeboard {
		// 게시글번호
		private int num;
		// 게시글제목
		private String title;
		// 게시글내용
		private String content;
		// 작성자ID
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
		    return " 게시글 번호 : "+this.num+ 
		    		" / 제목 : " +this.title +
		    		" / 내용 : " + this.content + 
		    		" / ID : " + this.p_id;
		} 
	}
