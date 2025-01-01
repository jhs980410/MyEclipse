package hk.exam.six;

public class Tv {

	protected boolean power; // tv전원 전원이 꺼진 상태에서는 다른 기능들이 절대 작동되어서는 안된다.
	protected int channel; // 채널 제일 작은 채널값은 1 최대값 5 5를 넘기면 1이 되어야 함 / 1에서 내려가면 5

	protected int volume; // 볼륨 최소 0 최대 3 0에서는 더 내려가지 않음 / 3에서 더 올라가면 안됨
	private boolean silence = false; // 음소거 상태
	private int previousVolume = 0; // 음소거 이전 볼륨 상태
	private boolean record = false; // 녹화 상태

	public Tv() {
		this.power = false;
		this.channel = 1;
		this.volume = 0;
		
	}

	// tv전원 키거나 끔
	public void powerButton() {
		this.power = !power;
		if (power) {
			System.out.println("Tv켜짐");
		} else {
			System.out.println("Tv꺼짐");
		}
	}

	public boolean getPower() {
		return power;
	}

	// 채널 올리기
	public void channelUp() {

		if (power == true) {
			this.channel++;
			if (this.channel > 5) {
				this.channel = 1;
			}
			System.out.println("현재 채널: " + this.channel);

		}

	}

	// 채널 낮추기
	public void channelDown() {
		if (power == true) {
			this.channel--;
			if (this.channel < 1) {
				this.channel = 5;
			}
			System.out.println("현재 채널: " + this.channel);
		}
	}

	// 볼륨 올리기
	public void volumeUp() {
		if (power == true) {
			if (this.volume < 3) {
				this.volume++;
				System.out.println("현재 볼륨: " + this.volume);
			} else {

				System.out.println("볼륨을 더 이상 높일 수 없습니다.");
				System.out.println("현재 볼륨: " + this.volume);
			}

		}

	}

	// 볼륨 낮추기
	public void volumeDown() {

		if (power == true) {
			if (this.volume > 0) {
				this.volume--;

			}

			if (this.volume <= 0) {
				System.out.println("볼륨을 더이상 낮출 수 없습니다.");
			}
			System.out.println("현재 볼륨: " + this.volume);
		}

	}

	// 음소거 버튼
	public void silenceButton() {
		silence = !silence;
		if (silence) {
			System.out.println("-----음소거모드 사용중-----");
			previousVolume = volume;
			volume = 0;
		} else {
			System.out.println("-----음소거모드 종료-----");
			volume = previousVolume;
			System.out.println("현재 볼륨: " + volume);
		}
	}

	// 녹화 버튼
	public void recordingButton() {
		this.record = !record;
		if (record) {
			System.out.println("녹화시작");
		} else {
			System.out.println("녹화종료");
		}
	}

	// Tv 정보표시
	@Override
	public String toString() {
		if (power == false) {
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append("Tv 전원이 켜져있지 않습니다 \n");
			strBuffer.append("Tv 전원을 켜주십시요 \n");
			return strBuffer.toString();
		}else {
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append("HK02 Fighting TV\n");
			strBuffer.append("현재 채널은 ");
			strBuffer.append(channel + "\n");
			strBuffer.append("현재 볼륨은 ");
			strBuffer.append(volume + " 입니다\t");

			return strBuffer.toString();
		}
		
	}
}
