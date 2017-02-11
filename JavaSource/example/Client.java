package example;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Client {

  public static void main(String[] args) {

    try {
    	
    	
    	
    		WebTarget webTarget = ClientBuilder.newClient()
    		.target("http://jbosseapjms-elte.rhcloud.com/rest2/bienvenida")
    		.path("/m2");
    		Response response = webTarget.request()
    		.post(Entity.entity(" hola", MediaType.APPLICATION_XML));
    		String message = response.readEntity(String.class);
    		System.out.println(message);
    		
    	
//        WebTarget webTarget = ClientBuilder.newClient()
//        		.target("http://localhost:8080/Rest/author")
//        		.path("/");
//        Response response = webTarget.request()
//        		.post(Entity.entity("Some Name", MediaType.APPLICATION_JSON));
//        String message = response.readEntity(String.class);
//        System.out.println(message);
        
      } catch (Exception e) {

        e.printStackTrace();

      }

    }
}