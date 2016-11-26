import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ipvinner on 26.11.2016.
 */
public class ClientCalculator {
    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) {
        try {
            Integer number1 = 2;
            Integer number2 = 4;

            URL url = new URL("http://localhost:8080/calculator/CalculatorRestService?number1=" + number1 + "&number2=" + number2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(parseJsonResult(output));
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private static String parseJsonResult(String jsonStr) {
        String resultTemp = jsonStr.substring(8);
        String result = resultTemp.substring(0, (resultTemp.length() - 1));
        return result;
    }
}
