package hk.exam.ten2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private int lowerBound;
    private int upperBound;
    private int targetNumber;
    private int count = 0;
    private boolean gameStart = false;
    private Scanner sc = new Scanner(System.in);
    private ResultPrinter resultPrinter = new ResultPrinter();
    private GameRule gameRule = new UpDownGameRule();
    
    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTargetNumber() {
		return targetNumber;
	}

	public void setTargetNumber(int targetNumber) {
		this.targetNumber = targetNumber;
	}

	public void start() {
        gameStart = true;
        setupPlayers();
        setTargetNumber();
        playGame();
    }

	private void setupPlayers() {
	    int playerCount = 0;

	    while (true) {
	        try {
	            System.out.println("몇 명이 참가하시겠습니까? 2 ~ 11명 참여 가능");
	            playerCount = sc.nextInt(); // 숫자 입력받기
	            sc.nextLine(); // 버퍼 비우기

	            if (playerCount >= 2 && playerCount <= 11) {
	                break; // 입력이 올바르면 반복문 종료
	            } else {
	                System.out.println("2 ~ 11명만 가능합니다. 다시 입력해주세요.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("숫자만 입력해주세요.");
	            sc.nextLine(); // 버퍼비움
	        }
	    }

	    for (int i = 1; i <= playerCount; i++) {
	        System.out.println(i + "번째 참가자의 이름을 입력해주세요:");
	        String name = sc.nextLine();
	        players.add(new Player(name));
	    }
	}


    private void setTargetNumber() {
        Random random = new Random();
        targetNumber = random.nextInt(1000) + 1; //랜덤값 1~1000
		lowerBound = (targetNumber / 100) * 100; // 
		upperBound= lowerBound + 100;
		System.out.println(targetNumber);
        System.out.println("병뚜껑의 숫자를 확인 했습니다 " );
        System.out.println("상대방이 숫자의 범위를 설정했습니다.");
	
    }

    private void playGame() {
        int currentPlayerIndex = 0;
        System.out.println("게임을 시작했습니다.");
        while (gameStart) {
            Player currentPlayer = players.get(currentPlayerIndex);

            int guess = -1; // 플레이어의 추측값 초기화
            try {
                // 숫자 입력 시도
                guess = currentPlayer.guessNumber(sc, lowerBound, upperBound);

                // 입력값이 범위를 벗어나는 경우 처리
                if (guess < lowerBound) {
                    System.out.println(lowerBound+ "값보다 작은 값은 넣을수 없습니다.");
                    continue;
                }else if (guess > upperBound) {
                	 System.out.println(upperBound+ "값보다 큰 값은 넣을수 없습니다.");
                     continue;
				}
            } catch (InputMismatchException e) {
                System.out.println("잘못입력하셨습니다. 숫자만 입력가능합니다. 다시시도해주세요.");
                sc.nextLine(); // 버퍼 비움, 
                continue; // 다시 입력 받기
            }

            count++;
            if (gameRule.isCorrect(guess, targetNumber)) {
                resultPrinter.printWinner(currentPlayer, targetNumber, count);
                currentPlayer.setPassCheck(true);
                gameStart = false; // 게임 종료
            } else if (guess < targetNumber) {
                lowerBound = guess + 1;
                System.out.println("틀렸습니다. 다음 분은 큰 수를 입력하세요.");
            } else {
                upperBound = guess - 1;
                System.out.println("틀렸습니다. 다음 분은 작은 수를 입력하세요.");
            }

            // 다음 플레이어로 넘어가기
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        printResults();
    }

    private void printResults() {
        for (Player player : players) {
            resultPrinter.printPlayerResult(player, player.isPassCheck(), targetNumber);
        }
    }
}
