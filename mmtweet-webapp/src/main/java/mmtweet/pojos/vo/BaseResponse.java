package mmtweet.pojos.vo;

public class BaseResponse {
	
	private boolean result;

	public BaseResponse() {
		this(false);
	}
	
	public BaseResponse(boolean result)
	{ 
		this.result = result;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
}
