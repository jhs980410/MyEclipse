package hk.exam.eight;

public class Computer extends Product {
	
	public Computer() {
		super(200000.00);
	}
	
	
	public Computer(String name, String explain) {
		this();
		super.name = name;
		super.explain = explain;
	}
	
	
}
