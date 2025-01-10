package hk.exam.ten2;


import java.util.Scanner;

public class Player {
    private String name;
    private boolean passCheck = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isPassCheck() {
        return passCheck;
    }

    public void setPassCheck(boolean passCheck) {
        this.passCheck = passCheck;
    }

    public int guessNumber(Scanner sc, int lowerBound, int upperBound) {
        System.out.println(name + "님,\n" + lowerBound + "과 " + upperBound + " 사이의 숫자를 입력하세요:");
        return sc.nextInt();
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', passCheck=" + passCheck + "}";
    }
}
