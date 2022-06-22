package project_t1;

public class Rent_Vo {
	
	private int r_num;
	private int b_num;
	private String p_id;
	private String start_day;
	private String end_day;
	private String r_return;
	
	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

	public String getR_return() {
		return r_return;
	}

	public void setR_return(String r_return) {
		this.r_return = r_return;
	}

	public Rent_Vo() {
		
	}
	
	public Rent_Vo(int r_num, int b_nun, String p_id, String start_day, String end_day, String r_return) {
		super();
		this.r_num = r_num;
		this.b_num = b_nun;
		this.p_id = p_id;
		this.start_day = start_day;
		this.end_day = end_day;
		this.r_return = r_return;
	}
	
	


	@Override
	public String toString() {
		return "Rent_Vo [r_num=" + r_num + ", b_num=" + b_num + ", p_id=" + p_id + ", start_day=" + start_day
				+ ", end_day=" + end_day + ", r_return=" + r_return + "]";
	}
	
	

}
