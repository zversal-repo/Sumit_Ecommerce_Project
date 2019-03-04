package org.sumit.ECom.Client;

import java.io.IOException;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
//import org.glassfish.jersey.filter.LoggingFilter;
//import com.rest.dto.EarUnearmarkCollateralInput;

public class CustomClient {

	private Client client;
	private static WebTarget target = null;
	private String baseUrl = "https://localhost:8008/ECommerce/webapi/";
	private static String userName = "username";
	private static String passWord = "password";

	CustomClient() throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext sc = SSLContext.getInstance("SSL");
		TrustManager[] trustAllCerts = { new InsecureTrustManager() };
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HostnameVerifier allHostsValid = new InsecureHostnameVerifier();
		//
		this.client = ClientBuilder.newBuilder().sslContext(sc).hostnameVerifier(allHostsValid).build();
		//
		String baseUrl = "https://localhost:7002/VaquarKhanWeb/employee/api/v1/informations/employee";
		this.client.register(HttpAuthenticationFeature.basic(userName, passWord));
		target = this.client.target(baseUrl);
	}

	/*
	 * public void sslRestClientGETReport() {
	 * 
	 * target = this.client.target(this.baseUrl); // target.register(new
	 * LoggingFilter()); //
	 * 
	 * }
	 * 
	 * public void sslRestClientGET(){
	 * 
	 * target =
	 * target.path("employee/api/v1/informations/employee/data").queryParam(
	 * "search",
	 * "%7B\"name\":\"vaquar\",\"surname\":\"khan\",\"age\":\"30\",\"type\":\"admin\""
	 * );
	 * 
	 * //target.register(new LoggingFilter());
	 * 
	 * }
	 * 
	 * // TOD need to fix public static void sslRestClientPost() throws
	 * KeyManagementException, IOException, NoSuchAlgorithmException {
	 * 
	 * target.register(new LoggingFilter()); // Response response =
	 * target.request().put(Entity.json(employee)); String output =
	 * response.readEntity(String.class); //
	 * System.out.println("-------------------------------------------------------")
	 * ; System.out.println(output);
	 * System.out.println("-------------------------------------------------------")
	 * ;
	 * 
	 * }
	 */

}