/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.aalkuhlani95.technicaltest.tt.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import me.aalkuhlani95.technicaltest.tt.mbs.context.Record;

/**
 *
 * @author Ahmed
 */
public class GeoCodeAPI {

    static public String getFormattedAddress(String lat, String lng, String api_key) {
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=4" + lat + "," + lng + "-73.961452&key=" + api_key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(1000);
            conn.setRequestProperty("Accept", "application/json;  charset=utf-8");
            if (conn.getResponseCode() != 200) {
//                System.out.println(conn.getResponseCode());
                return null;
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                String output;
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = null;
                String u = "";
                while ((output = br.readLine()) != null) {
                    u = u.concat(output);
                    System.out.println(output);
                }
                try {
                    jsonObject = jsonParser.parse(u).getAsJsonObject();
                    System.out.println("" + jsonObject.get("status").getAsString());
                    if (jsonObject.get("status").getAsString() == "OK") {
                        JsonArray ja = jsonObject.get("results").getAsJsonArray();
                        for (int i = 0; i < ja.size(); i++) {
                            if (!ja.get(i).getAsJsonObject().get("formatted_address").isJsonNull()) {
                                return ja.get(i).getAsJsonObject().get("formatted_address").getAsString();
                            }
                        }
                    } else {
                        return null;
                    }
                    conn.disconnect();
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
