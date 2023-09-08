package org.example;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readline = null;
            while((readline = in.readLine()) != null){
                apiData.append(readline);
            }
            in.close();
            JSONObject  jsonObject = new JSONObject(apiData.toString());
            System.out.println(jsonObject.get("categories"));
            System.out.println(jsonObject.get("created_at"));
            System.out.println(jsonObject.get("icon_url"));
            System.out.println(jsonObject.get("id"));
            System.out.println(jsonObject.get("updated_at"));
            System.out.println(jsonObject.get("url"));
            System.out.println(jsonObject.get("value"));
        }
        else
            System.out.println("API call could not be made !!!");
    }
}