package com.javacodegeeks.enterprise.rest.jersey;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mmtweet.dal.AccessDal;
import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.TweetMessage;
import mmtweet.pojos.vo.BaseResponse;
import mmtweet.pojos.vo.DoCommentRequest;
import mmtweet.pojos.vo.GetLiveMessagesResponse;
import mmtweet.pojos.vo.GetMyCommentsResponse;
import mmtweet.pojos.vo.GetMyMessagesResponse;
import mmtweet.pojos.vo.SendMessageRequest;
import mmtweet.webservices.GetLiveMessageService;
import mmtweet.webservices.UpdateMessageLocationService;

@Path("/helloWorldREST")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldREST {

    
    GetLiveMessageService getLiveMessageService = new GetLiveMessageService();
    IMmtweetDal dal = new AccessDal();
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    
	@GET
	@Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();

	}
	
	  @GET
	    @Path("/getMyMessages")
	    public GetMyMessagesResponse getMyMessages(@QueryParam(value = "userid") String userid){
	        GetMyMessagesResponse response = new GetMyMessagesResponse();
	        if (userid != null)
	        {
	            response.setMessageList(dal.getMessagesByUserId(userid));
	        }
	        return response;
	    }
	  
	  
	  @POST
	    @Path("/sendMessage")
	    public BaseResponse sendMessage(SendMessageRequest request){
	        boolean status = false;
	        if (request != null && request.getUserId() != null && request.getMessage() != null)
	        {
	        	TweetMessage message = request.getMessage();
	        	if (message.getPinned())
	        		message.setCurrentLocation(message.getOriginLocation());
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
	    @Path("/getLiveMessages")
	    public GetLiveMessagesResponse getLiveMessages(@QueryParam(value = "latitude") String latitude,@QueryParam(value = "longitude") String longitude){
	        return getLiveMessageService.getLiveMessages(latitude,longitude);
	    }
	    
	    @GET
	    @Path("/getMyComments")
	    public GetMyCommentsResponse getMyComments(@QueryParam(value = "userid") String userId){
	        GetMyCommentsResponse response = new GetMyCommentsResponse();
	        if (userId != null)
	        {
	            response.setMessageList(dal.getCommentedMessagesByUserId(userId));
	        }
	        return response;
	    }
	    

	    @GET
	    @Path("/startUpdateLocationService")
	    public BaseResponse startUpdateLocationService()
	    {
	    	if (executorService.isTerminated())
	    	{
	    		System.out.println("inside startUpdateLocationService; going to start UpdateMessageLocationService");
	    		executorService.submit(new UpdateMessageLocationService());
	    		return new BaseResponse(true);
	    	}
	    	return new BaseResponse(false);
	    }

	    @GET
	    @Path("/stopUpdateLocationService")
	    public BaseResponse stopUpdateLocationService()
	    {
	    	if (!executorService.isTerminated())
	    	{
	    		System.out.println("inside stopUpdateLocationService; going to shutdown");
	    		executorService.shutdown();
	    		return new BaseResponse(true);
	    	}
	    	return new BaseResponse(false);
	    }

}
