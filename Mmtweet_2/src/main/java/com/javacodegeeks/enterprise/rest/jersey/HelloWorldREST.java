package com.javacodegeeks.enterprise.rest.jersey;

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

import mmtweet.pojos.vo.BaseResponse;
import mmtweet.pojos.vo.DoCommentRequest;
import mmtweet.pojos.vo.GetLiveMessagesResponse;
import mmtweet.pojos.vo.GetMyCommentsResponse;
import mmtweet.pojos.vo.GetMyMessagesResponse;
import mmtweet.pojos.vo.SendMessageRequest;

@Path("/helloWorldREST")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldREST {

	@GET
	@Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();

	}
	
	  @GET
	    @Path("/getMyMessages")
	    public GetMyMessagesResponse getMyMessages(@QueryParam(value = "user") String request){
	        return new GetMyMessagesResponse();
	    }
	  
	  
	  @POST
	    @Path("/sendMessage")
	    public BaseResponse sendMessage(SendMessageRequest request){
	        return new BaseResponse(true);
	    }

	  
	    
	    @POST
	    @Path("/doComment")
	    public BaseResponse doComment(DoCommentRequest request){
	        return new BaseResponse(true);
	    }

	    
	   /* @GET
	    @Path("/getMyMessages")
	    public GetMyMessagesResponse getMyMessages(@QueryParam(value = "user") String request){
	        return new GetMyMessagesResponse();
	    }*/

	 
	    @GET
	    @Path("/getLiveMessages")
	    public GetLiveMessagesResponse getLiveMessages(@QueryParam(value = "location") String request){
	        return new GetLiveMessagesResponse();
	    }
	    
	    @GET
	    @Path("/getMyComments")
	    public GetMyCommentsResponse getMyComments(@QueryParam(value = "userid") String request){
	        GetMyCommentsResponse response = new GetMyCommentsResponse();
	        if (request != null)
	        {
	           // response.setMessageList(dal.getCommentedMessagesByUserId(request.getUserId()));
	        }
	        return response;
	    }
	    

}
