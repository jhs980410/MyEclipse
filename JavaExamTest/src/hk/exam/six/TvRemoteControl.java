package hk.exam.six;

public class TvRemoteControl implements RemoteControl{

	@Override
	public void powerButton(Tv tv) {
		tv.powerButton();
	}

	@Override
	public void volumeDown(Tv tv) {
		tv.volumeDown();
	}

	@Override
	public void volumeUp(Tv tv) {
		tv.volumeUp();
	}

	@Override
	public void channelUp(Tv tv) {
		tv.channelUp();
	}

	@Override
	public void channelDown(Tv tv) {
		tv.channelDown();
	}

	@Override
	public void representationInfoButton(Tv tv) {
		
		System.out.println(tv.toString());
	}

	@Override
	public void silence(Tv tv) {
	
		tv.silenceButton();
	}

	@Override
	public void recordButton(Tv tv) {

		tv.recordingButton();
	}

	

	
	
	

	
}
