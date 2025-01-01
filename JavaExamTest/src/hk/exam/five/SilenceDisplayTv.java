package hk.exam.five;

public class SilenceDisplayTv extends SilenceTv {
	public SilenceDisplayTv() {
		
		this.power = false;
		this.channel = 1;
		this.volume = 1;
		this.silence = false;

	}
	

	@Override
	public void powerButton() {
		this.power = !this.power;
		if (power == true) {
			System.out.println("음소거 상태표시 가능 Tv 켜짐");
		}else {
			System.out.println("음소거 상태표시 가능 Tv 꺼짐");
		}

	}

	@Override
	public void silenceButton() {
		// TODO Auto-generated method stub
		if (power == true) {
			this.silence = !silence;
			
			if (this.silence) {
				this.previousVolume = this.volume;
				this.volume = 0;
			} else {
				this.volume = this.previousVolume;
			}
			
		}
		
	}

	@Override
	public String toString() {
		return "SilenceDisplayTv [power " + this.power + ", channel=" + this.channel + ", volume=" + this.volume
				+ " silence=" + this.silence + "]";
	}

	@Override
	public void channelUp() {
		
		if (power == true) {
			this.channel++;
			if (this.channel > 5 ) {
				this.channel = 1;
			}
			System.out.println("현재 채널: " + this.channel);
			
			
		}
		
	}

	@Override
	public void channelDown() {
		if (power == true) {
			this.channel--;
			if (this.channel < 1 ) {
				this.channel = 5;
			}
			System.out.println("현재 채널: " + this.channel);
		}
	}

	@Override
	public void volumeUp() {
		if (power == true) {
			if (this.volume < 3) {
				this.volume++;
				System.out.println("현재 볼륨: " + this.volume);
			}else {
				
				System.out.println("볼륨을 더 이상 높일 수 없습니다.");
				System.out.println("현재 볼륨: " + this.volume);
			}
			
			
		}
				
	}

	@Override
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

}