package hk.exam.eight;

public class Book extends Product {
	
	public Book() {
		super(6700.00);
		// TODO Auto-generated constructor stub
	}

	public Book(String name, String explain) {
		this();
		super.name = name;
		super.explain = explain;
		// TODO Auto-generated constructor stub
	}


}
