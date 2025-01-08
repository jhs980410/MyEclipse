package hk.exam.ten;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private boolean gameStart = false;
//	private ArrayList<Player> playerList;
	private int score;
	private int count;
	int playerMember;
	ArrayList<Player> players;
	Player player;
	Scanner sc = new Scanner(System.in);

	public Game() {

	}

	public int getPlayerMember() {
		return playerMember;
	}

	public void setPlayerMember(int playerMember) {
		this.playerMember = playerMember;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Player player) {
		this.players.add(player);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void start() {
		this.gameStart = true;
	}

	// 참가자의 수를 정하는 로직, arraylist초기크기 결정 //
	public void playerMemberNum() {
		while (gameStart) {

			int setPlayer;
			System.out.println(" 병뚜껑 게임에 몇명이 참여 하시겠습니까? \n 2 ~ 11명참여가능");
			if (sc.hasNextInt()) {
				setPlayer = sc.nextInt();
				sc.nextLine();
				if (setPlayer >= 2 && setPlayer <= 11) {
					this.playerMember = setPlayer;
					this.players = new ArrayList<Player>(playerMember);

					break;
				} else if (setPlayer < 2) {
					continue;
				}
			} else {

				System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
				sc.next();
			}

		}
	}

	public void addPlayer(Player player) {
		if (players.size() < playerMember) {
			players.add(player);

		} else {
			System.out.println("플레이어 수가 이미 최대값에 도달했습니다. 추가할 수 없습니다.");
		}
	}

	public void addPlayers() {
		while (players.size() < playerMember) {
			System.out.println((players.size()) + "번째 참가자의 이름을 입력해주세요:");
			String name = sc.next();

			Player player = new Player(name);
			addPlayer(player);

		}

	}
	//private으로 , 클래스내에서만 호출,
	private void printGameResult(Player player, int userAnswer, boolean passCheck) {
		if (passCheck) {
			System.out.println("[name=" + player.getName() + "] 님이 병뚜껑 숫자를 맞추셨습니다!");
			System.out.println("병뚜껑 숫자를 맞추신 분은 [name=" + player.getName() + "님 입니다., userAnswer=" + userAnswer
					+ ", passCheck=" + passCheck + "] 벌칙 면제~ ^^");
		}
		if (!passCheck) {
			System.out.println("[name=" + player.getName() + "] 님은 생존하셨습니다. [passCheck=" + passCheck + "] 축하합니다~");
		}
	}

	public void playGame() {
		if (gameStart) {
			Random random = new Random();

			int userAnswer = 0;
			int gameNum = random.nextInt(1000) + 1;
			int startNum = (gameNum / 100) * 100;
			int endNum = startNum + 100;

			System.out.println("병뚜껑 숫자를 확인 했습니다. \n상대방이 숫자의 범위를 설정 했습니다.\n게임을 시작하겠습니다.");

			while (gameStart) {
				int currentPlayerIndex = 0; // 현재 플레이어 인덱스

				while (gameStart) {
					Player currentPlayer = players.get(currentPlayerIndex); // 현재 플레이어
					System.out.println(currentPlayer.getName() + "님");
					System.out.println(startNum + "과 " + endNum + " 사이의 값을 입력하세요:");

					if (sc.hasNextInt()) {
						userAnswer = sc.nextInt();

						if (userAnswer >= startNum && userAnswer <= endNum) {
							if (userAnswer < gameNum) {
								startNum = userAnswer + 1;
								System.out.println("틀렸습니다. 다음 분은 더 큰 수를 입력하세요.");
								count++;
								System.out.println(gameNum);
							} else if (userAnswer > gameNum) {
								endNum = userAnswer - 1;
								System.out.println("틀렸습니다. 다음 분은 더 작은 수를 입력하세요.");
								count++;
							} else if (userAnswer == gameNum) {
								System.out.println(currentPlayer.getName() + "님");
								System.out.println("병뚜껑 번호" + userAnswer +"맞췄습ㄴ다");
								System.out.println("시도 횟수는 "+count + "번입니다.");
								gameStart = false;
								break;
							}
						} else {
							System.out.println("입력값이 범위를 벗어났습니다. 다시 입력해주세요.");
							continue;
						}
					} else {
						System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
						sc.next(); // 버퍼 비우기
						continue;
					}

					// 다음 플레이어로 전환
					currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
				}
			
				 for (Player player : players) {
			            if (!player.equals(players.get(currentPlayerIndex))) {
			                printGameResult(player, userAnswer, false);
			            }
			            if (player.equals(players.get(currentPlayerIndex))) {
			                printGameResult(player, userAnswer, true);
			            }
			        }
			    }
			}
		}
	}

	


