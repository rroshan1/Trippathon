package mmtweet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mmtweet.dal.AccessDal;
import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.vo.BaseResponse;
import mmtweet.pojos.vo.DoCommentRequest;
import mmtweet.pojos.vo.GetLiveMessagesResponse;
import mmtweet.pojos.vo.GetMyCommentsResponse;
import mmtweet.pojos.vo.GetMyMessagesResponse;
import mmtweet.pojos.vo.SendMessageRequest;
import mmtweet.GetLiveMessageService;

@Path("mmtweet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MmtweetResource {
	IMmtweetDal dal = new AccessDal();
	GetLiveMessageService getLiveMessageService = new GetLiveMessageService();

    @POST
    @Path("/sendMessage")
    public BaseResponse sendMessage(SendMessageRequest request){
		boolean status = false;
		if (request != null)
		{
			status = dal.addMessage(request.getUserId(), request.getMessage());
		}
		return new BaseResponse(status);
    }
    
    @POST
    @Path("/doComment")
    public BaseResponse doComment(DoCommentRequest request){
		boolean status = false;
		if (request != null)
		{
			status = dal.addComment(request.getUserId(), request.getMessageId(), request.getComment());
		}
		return new BaseResponse(status);
    }
    
    @GET
    @Path("/getMyMessages")
    public GetMyMessagesResponse getMyMessages(@QueryParam("userId") String userId){
		GetMyMessagesResponse response = new GetMyMessagesResponse();
		if (userId != null)
		{
			response.setMessageList(dal.getMessagesByUserId(userId));
		}
		return response;
    }
 
    @GET
    @Path("/getLiveMessages")
    public GetLiveMessagesResponse getLiveMessages(@QueryParam("location") String request){
    	return new GetLiveMessagesResponse();
//		return getLiveMessageService.getLiveMessages(request);
    }
    
    @GET
    @Path("/getMyComments")
    public GetMyCommentsResponse getMyComments(@QueryParam("userId") String userId){
		GetMyCommentsResponse response = new GetMyCommentsResponse();
		if (userId != null)
		{
			response.setMessageList(dal.getCommentedMessagesByUserId(userId));
		}
		return response;
    }
}
