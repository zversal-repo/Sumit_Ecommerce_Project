package org.sumit.ECom.Controller;

import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sumit.ECom.Model.Product;
import org.sumit.ECom.Services.ProductsService;

@Path("/Products")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProductsContoller {

	@GET
	public Response getProducts(@BeanParam Parameters parameters) {

		ProductsService productsservice = new ProductsService();
		ArrayList<Product> productList = productsservice.getProducts(parameters.getSellerId(),
				parameters.getProductId(), parameters.getProductName());

		if (productList != null) {
			return Response.status(Status.OK).entity(productList).build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

}
