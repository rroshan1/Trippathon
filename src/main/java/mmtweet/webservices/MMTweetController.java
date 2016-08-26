package mmtweet.webservices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mmtweet.pojos.vo.BaseResponse;
import mmtweet.pojos.vo.DoCommentRequest;
import mmtweet.pojos.vo.GetLiveMessagesRequest;
import mmtweet.pojos.vo.GetLiveMessagesResponse;
import mmtweet.pojos.vo.GetMyCommentsRequest;
import mmtweet.pojos.vo.GetMyCommentsResponse;
import mmtweet.pojos.vo.GetMyMessagesRequest;
import mmtweet.pojos.vo.GetMyMessagesResponse;
import mmtweet.pojos.vo.SendMessageRequest;


@Controller
public class MMTweetController {
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse sendMessage(@RequestBody SendMessageRequest request){
		return new BaseResponse(true);
	}

	@RequestMapping(value = "/doComment", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse doComment(@RequestBody DoCommentRequest request){
		return new BaseResponse(true);
	}

	@RequestMapping(value = "/getMyMessages", method = RequestMethod.GET)
	@ResponseBody
	public GetMyMessagesResponse getMyMessages(@RequestBody GetMyMessagesRequest request){
		return new GetMyMessagesResponse();
	}

	@RequestMapping(value = "/getMyComments", method = RequestMethod.GET)
	@ResponseBody
	public GetMyCommentsResponse getMyComments(@RequestBody GetMyCommentsRequest request){
		return new GetMyCommentsResponse();
	}

	@RequestMapping(value = "/getLiveMessages", method = RequestMethod.GET)
	@ResponseBody
	public GetLiveMessagesResponse getLiveMessages(@RequestBody GetLiveMessagesRequest request){
		return new GetLiveMessagesResponse();
	}
	
}
