package bean;

public class Bean {

	private String name;
	private String pw;
	
	public Bean() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Bean(String name, String pw) {
		super();
		this.name = name;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Bean [name=" + name + ", pw=" + pw + "]";
	}
	
	
	
}
