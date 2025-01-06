package hk.exam.nine;

public class HitterPlayer extends Human {
    private boolean isWinner;

    public HitterPlayer() {
		super();
	}


	public HitterPlayer(String name) {

    }
	public String getName() {
		return name;
	}
	public void setName() {
		super.name = name;
	}
    
    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public String toString() {
        return "HitterPlayer{name='" + name + "', isWinner=" + isWinner + "}";
    }
}
