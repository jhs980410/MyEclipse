package hk.exam.nine;

import java.util.List;

public class Stadium implements GamePlay {
    private HitterPlayer firstPlayer;
    private HitterPlayer secondPlayer;
    private Emcee mc;

    public Stadium() {
        this.firstPlayer = null;
        this.secondPlayer = null;
        this.mc = null;
    }

    public void firstPlayerGameSetting() {
       
    }

    public void secondPlayerGameSetting() {
        
    }

    @Override
    public void gamePlay() {
        
    }

    public int resultStrikes(List<Integer> answerList, List<Integer> playerList) {
       
        return 0; 
    }

    public int resultBalls(List<Integer> answerList, List<Integer> playerList) {
    
        return 0; 
    }
}
