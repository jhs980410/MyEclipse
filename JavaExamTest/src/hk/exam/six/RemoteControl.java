package hk.exam.six;

public interface RemoteControl extends Record, Silence{
	// 사용가능한 Tv이름
	 String REMOTE_CONTROL_TV_NAME = "HK02 Fighting Tv";
	
	@Override
	default void silence(Tv tv) {
		
		
	}
	@Override
	default void recordButton(Tv tv) {
		
		
	}
	// 전원 버튼
	void powerButton(Tv tv);
	// 볼륨 낮추기 버튼
	void volumeDown(Tv tv);
	// 볼륨 올리기 버튼 
	void volumeUp(Tv tv);
	// 채널 올리기 버튼
	void channelUp(Tv tv);
	// 채널 낮추기 버튼
	void channelDown(Tv tv);
	
	// 현재 Tv 정보표시 (Tv 채널, 볼륨 표시 및 Tv이름)
	void representationInfoButton(Tv tv);
	
}
