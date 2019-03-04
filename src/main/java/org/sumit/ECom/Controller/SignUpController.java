package org.sumit.ECom.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sumit.ECom.Model.User;
import org.sumit.ECom.Model.UserDatabase;
import org.sumit.ECom.Services.SignUpService;

@Path("/Signup")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SignUpController {

	SignUpService signupservice = new SignUpService();

	@POST
	public Response signUp(User user) {
		if (signupservice.signUp(user))
			return Response.status(Status.CREATED)
					.header("token", UserDatabase.getAllUsers().get(user.getUserId()).getToken()).build();

		else
			return Response.status(Status.BAD_REQUEST).entity("").build();
	}

}
