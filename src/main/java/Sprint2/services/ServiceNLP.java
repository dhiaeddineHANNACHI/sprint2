package Sprint2.services;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ServiceNLP {

    public String NLP ( String ui)
    {
        String output="";
        try {
            URL url = new URL("http://127.0.0.1:5000/test");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\n" +
                    "\t\n" +
                    "\t\"test\":\""+ui+"\"\n" +
                    "}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            System.out.println("Output from Machine Learning Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                return output;
            }
        } catch (MalformedURLException e) {
            System.out.println("---------------c");
        } catch (IOException e) {
            System.out.println("---------------------b");
        }
        return output;
    }

    public String chat ( String ui)
    {
        String output="";
        try {
            URL url = new URL("http://127.0.0.1:5000/chat");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\n" +
                    "\t\n" +
                    "\t\"chat\":\""+ui+"\"\n" +
                    "}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            System.out.println("Output from Machine Learning Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                return output;
            }
        } catch (MalformedURLException e) {
            System.out.println("---------------c");
        } catch (IOException e) {
            System.out.println("---------------------b");
        }
        return output;
    }



}



