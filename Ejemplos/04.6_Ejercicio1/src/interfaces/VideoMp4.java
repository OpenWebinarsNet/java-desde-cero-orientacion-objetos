package interfaces;

public class VideoMp4 extends Video {

	public VideoMp4(int length) {
		super(length);
	}

	@Override
	public boolean isValid() {
		return length > 0 && length < 5*60;
	}
	

}
