package hk.exam.ten2;

public class ResultPrinter{
	
    public void printWinner(Player player, int targetNumber, int count) {
        System.out.println(player.getName() + "님");
        System.out.println("병뚜껑 번호 " + targetNumber + " 맞추셨습니다.");
        System.out.println("총 시도 횟수는 " + count + "번입니다.");
    }

    public void printPlayerResult(Player player, boolean passCheck , int targetNumber) {
        if (passCheck) {
            System.out.println("병뚜껑 숫자를 맞추신 분은 [name=" + player.getName() + 
                               " 입니다., userAnswer=" + targetNumber + 
                               ", passCheck=" + passCheck + "] 벌칙 면제~ ^^");
        } else {
            System.out.println("[name=" + player.getName() + 
                               "] 님은 생존하셨습니다. , passCheck=" + passCheck + " 축하합니다~");
        }
    }
}
