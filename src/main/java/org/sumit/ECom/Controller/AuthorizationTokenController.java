package org.sumit.ECom.Controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sumit.ECom.Services.AuthorizationTokenService;

@Path("/Authorization")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AuthorizationTokenController {

	@GET
	public Response getAuthorizationToken(@BeanParam Parameters parameters) {

		AuthorizationTokenService authservice = new AuthorizationTokenService();
		String token = authservice.getAuthorizationToken(parameters.getUserId(), parameters.getPassword());

		if (token != null)
			return Response.status(Response.Status.OK).header("token", token).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).entity("").build();

	}

}
