package Vo;

public class Book {
    private int num;
	private String name;
	private String author;
	private String genre;
	private boolean rent;

   public Book(){
    }

    public Book(int num, String name, String author, String genre,boolean rent) {
        this.num =num;
        this.name = name;
        this.author = author;
        this.genre = genre;
		this.rent = rent;
    }

	public String getnum() {
		return num;
	}

    public void setnum(String num) {
		this.num = num;
	}

    public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	public boolean getrent() {
		return rent;
	}

	public void setrent(boolean rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Book [num=" + num + ", name=" + name + ", author=" + author + ",genre="+genre +",rent="+rent +"]";
	}
}
