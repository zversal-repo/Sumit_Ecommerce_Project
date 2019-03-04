package org.sumit.ECom.Controller;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class Parameters {

	private @HeaderParam("userId") String userId;
	private @HeaderParam("password") String password;
	private @HeaderParam("Authorization") String token;
	private @QueryParam("productId") String productId;
	private @QueryParam("productName") String productName;
	private @QueryParam("sellerId") String sellerId;
	private @Context UriInfo uriInfo;

	public void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public UriInfo getUriInfo() {
		return uriInfo;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getSellerId() {
		return sellerId;
	}

}
