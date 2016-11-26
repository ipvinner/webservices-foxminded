package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by ipvinner on 26.11.2016.
 */
public class JerseyCalculatorClient {
    public static void main(String[] args) {
        try {
            Integer number1 = 2;
            Integer number2 = 4;
            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/calculator/rest/calc?number1=" + number1 + "&number2=" + number2);

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
