package hk.exam.five;

// 미구현클래스
public abstract class Tv {

	protected boolean power; // tv전원		전원이 꺼진 상태에서는 다른 기능들이 절대 작동되어서는 안된다.
	protected int channel; // 채널 			제일 작은 채널값은 1 최대값 5 5를 넘기면 1이 되어야 함 / 1에서 내려가면 5
							
	protected int volume; // 볼륨 			최소 0 최대 3 0에서는 더 내려가지 않음 / 3에서 더 올라가면 안됨

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Tv() {
		power = false;
		channel = 1;
		volume = 0;
	}

	// tv전원 키거나 끔
	public abstract void powerButton();

	// 채널을 올린다
	public void channelUp() {
		++channel;
		
		System.out.println("현재 채널: " + channel);
	}

	// 채널을 내린다
	public void channelDown() {
		--channel;
		
		System.out.println("현재 채널: " + channel);
	}

	// 볼륨을 올린다
	public void volumeUp() {
		volume++;
		
		System.out.println("현재 볼륨: " + volume);
	}

	// 볼륨을 낮춘다
	public void volumeDown() {
		volume--;
		
		System.out.println("현재 볼륨: " + volume);
	}

	@Override
	public String toString() {
		return "Tv [power " + power + ", channel=" + channel + ", volume=" + volume + "]";
	}

}
