package mmtweet.webservices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mmtweet.dal.IMmtweetDal;
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
	
	IMmtweetDal dal;
	GetLiveMessageService getLiveMessageService = new GetLiveMessageService();
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse sendMessage(@RequestBody SendMessageRequest request){
		boolean status = false;
		if (request != null)
		{
			status = dal.addMessage(request.getUserId(), request.getMessage());
		}
		return new BaseResponse(status);
	}

	@RequestMapping(value = "/doComment", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse doComment(@RequestBody DoCommentRequest request){
		boolean status = false;
		if (request != null)
		{
			status = dal.addComment(request.getUserId(), request.getMessageId(), request.getComment());
		}
		return new BaseResponse(status);
	}

	@RequestMapping(value = "/getMyMessages", method = RequestMethod.GET)
	@ResponseBody
	public GetMyMessagesResponse getMyMessages(@RequestBody GetMyMessagesRequest request){
		GetMyMessagesResponse response = new GetMyMessagesResponse();
		if (request != null)
		{
			response.setMessageList(dal.getMessagesByUserId(request.getUserId()));
		}
		return response;
	}

	@RequestMapping(value = "/getMyComments", method = RequestMethod.GET)
	@ResponseBody
	public GetMyCommentsResponse getMyComments(@RequestBody GetMyCommentsRequest request){
		GetMyCommentsResponse response = new GetMyCommentsResponse();
		if (request != null)
		{
			response.setMessageList(dal.getCommentedMessagesByUserId(request.getUserId()));
		}
		return response;
	}

	@RequestMapping(value = "/getLiveMessages", method = RequestMethod.GET)
	@ResponseBody
	public GetLiveMessagesResponse getLiveMessages(@RequestBody GetLiveMessagesRequest request){
		return getLiveMessageService.getLiveMessages(request);
	}
	
}
