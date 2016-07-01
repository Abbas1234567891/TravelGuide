package com.tcs.travelguidefinalcode;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by 1256088 on 6/29/2016.
 */
public class MyConnection {

    public String getData(String uriString){
        URL url = null;
        HttpURLConnection connection = null;
        StringBuilder sb = null;

        try{


            url = new URL(uriString);
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=12b9741deaa38ff08f23b2e9c7880e59",8080));
            connection = (HttpURLConnection) url.openConnection();
           // connection.addRequestProperty("12b9741deaa38ff08f23b2e9c7880e59", "Suryansh Mishra");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){

                String line;
                sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = bufferedReader.readLine()) != null)
                {
                    sb.append(line);
                }
            }
            else{
                String line;
                sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = bufferedReader.readLine()) != null)
                {
                    sb.append(line);
                }
            }
        }
        catch(ProtocolException e)
        {
            Log.e(MyConnection.class.toString(), e.toString(), e);
            return e.toString();
        }
        catch(MalformedURLException e)
        {
            Log.e(MyConnection.class.toString(), e.toString(),e);
            return e.toString();
        }
        catch(IOException e)
        {
            Log.e(MyConnection.class.toString(), e.toString(),e);
            return e.toString();
        }

        String result = sb!=null ? sb.toString(): "";
        return result;
    }
}
