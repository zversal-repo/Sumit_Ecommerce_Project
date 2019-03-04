package org.sumit.ECom.Controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sumit.ECom.Model.User;
import org.sumit.ECom.Services.ProfileService;

@Path("/Profile")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ProfileController {

	@GET
	public Response getProfile(@BeanParam Parameters parameters) {

		ProfileService profileservice = new ProfileService();

		User user = profileservice.getProfile(parameters.getToken());

		if (user != null)
			return Response.status(Status.OK).entity(user).build();
		else {
			return Response.status(Status.BAD_REQUEST).entity("").build();
		}

	}

}
