package mmtweet.pojos.vo;

import java.io.Serializable;
import java.util.List;

public class BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean result;

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
