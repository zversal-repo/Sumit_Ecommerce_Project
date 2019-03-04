package org.sumit.ECom.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.sumit.ECom.Model.Link;
import org.sumit.ECom.Model.User;
import org.sumit.ECom.Services.LoginService;

@Path("/Login")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class LoginController {

	@GET
	public Response login(@BeanParam Parameters parameters) throws URISyntaxException {

		LoginService loginservice = new LoginService();

		User user = loginservice.getUserInfo(parameters.getUserId(), parameters.getPassword());

		if (user != null) {
			ArrayList<URI> links = new ArrayList<>();
			UriInfo uri = parameters.getUriInfo();
			for (Link link : user.getLinks()) {
				links.add(new URI(uri.getBaseUri().toString() + link.getLink()));
			}
			return Response.status(Status.OK).header("token", user.getToken()).entity(links).build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("").build();
		}

	}

}
