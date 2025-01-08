package hk.exam.ten;


public class Player {
	private String name;
	private boolean passCheck= false;
	
	public boolean isPassCheck() {
		return passCheck;
	}

	public void setPassCheck(boolean passCheck) {
		this.passCheck = passCheck;
	}

	public Player() {
		super();
	}

	public Player(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", passCheck=" + passCheck + "]";
	}
	
	
	
}
