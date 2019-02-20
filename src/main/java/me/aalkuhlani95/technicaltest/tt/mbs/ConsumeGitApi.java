/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.aalkuhlani95.technicaltest.tt.mbs;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import me.aalkuhlani95.technicaltest.tt.mbs.context.Record;
import me.aalkuhlani95.technicaltest.tt.util.GeoCodeAPI;

/**
 *
 * @author Ahmed
 */
@Named(value = "consumeGitApi")
@ViewScoped
public class ConsumeGitApi implements Serializable {

    private List<Record> records;
    private String apiKey;

    /**
     * Creates a new instance of ConsumeGitApi
     */
    public ConsumeGitApi() {
    }

    public void prepareAllLocations() {
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        System.out.println("" + apiKey);
        records = new ArrayList<>();
        try {
            System.out.println("12");
            URL url = new URL("http://34.201.19.114:40003/recordController/getAllRecords");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(2000);
            conn.setRequestProperty("Accept", "application/json;  charset=utf-8");
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseCode());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                String output;
                JsonParser jsonParser = new JsonParser();
                JsonArray ArrayFromString = null;
                JsonObject jsonObject = null;
                String u = "";
                while ((output = br.readLine()) != null) {
                    u = u.concat(output);
                    System.out.println(output);
                }
                try {
                    System.out.println("1");
                    ArrayFromString = jsonParser.parse(u).getAsJsonArray();
                    for (int i = 0; i < ArrayFromString.size(); i++) {
                        jsonObject = (JsonObject) ArrayFromString.get(i);
                        System.out.println("id" + jsonObject.get("id").getAsString());
                        Record record = new Record(
                                (jsonObject.get("id").isJsonNull() ? null : jsonObject.get("id").getAsString()),
                                (jsonObject.get("categoryA").isJsonNull() ? null : jsonObject.get("categoryA").getAsString()),
                                (jsonObject.get("categoryB").isJsonNull() ? null : jsonObject.get("categoryB").getAsString()),
                                (jsonObject.get("comments").isJsonNull() ? null : jsonObject.get("comments").getAsString()),
                                (jsonObject.get("politicA").isJsonNull() ? null : jsonObject.get("politicA").getAsString()),
                                (jsonObject.get("politicB").isJsonNull() ? null : jsonObject.get("politicB").getAsString()),
                                (jsonObject.get("politicC").isJsonNull() ? null : jsonObject.get("politicC").getAsString()),
                                (jsonObject.get("anonymus").isJsonNull() ? null : jsonObject.get("anonymus").getAsString()),
                                (jsonObject.get("name").isJsonNull() ? null : jsonObject.get("name").getAsString()),
                                (jsonObject.get("email").isJsonNull() ? null : jsonObject.get("email").getAsString()),
                                (jsonObject.get("phone").isJsonNull() ? null : jsonObject.get("phone").getAsString()),
                                (jsonObject.get("code_state").isJsonNull() ? null : jsonObject.get("code_state").getAsString()),
                                (jsonObject.get("code_city").isJsonNull() ? null : jsonObject.get("code_city").getAsString()),
                                (jsonObject.get("gender").isJsonNull() ? null : jsonObject.get("gender").getAsString()),
                                (jsonObject.get("ipAddress").isJsonNull() ? null : jsonObject.get("ipAddress").getAsString()),
                                (jsonObject.get("ipInfo").isJsonNull() ? null : jsonObject.get("ipInfo").getAsString()),
                                (jsonObject.get("date").isJsonNull() ? null : jsonObject.get("date").getAsString()),
                                (jsonObject.get("image").isJsonNull() ? null : jsonObject.get("image").getAsString()),
                                (jsonObject.get("staName").isJsonNull() ? null : jsonObject.get("staName").getAsString()),
                                (jsonObject.get("citName").isJsonNull() ? null : jsonObject.get("citName").getAsString()),
                                (jsonObject.get("citId").isJsonNull() ? null : jsonObject.get("citId").getAsString()),
                                (jsonObject.get("latitude").isJsonNull() ? null : jsonObject.get("latitude").getAsString()),
                                (jsonObject.get("longitude").isJsonNull() ? null : jsonObject.get("longitude").getAsString()),
                                (jsonObject.get("countItems").isJsonNull() ? null : jsonObject.get("countItems").getAsString())
                        );
                        records.add(record);
                    }
                    conn.disconnect();
//                    for (int i = 0; i < records.size(); i++) {
//                        records.get(i).setFormattedAddress(
//                                GeoCodeAPI.getFormattedAddress(records.get(i).getLatitude(), records.get(i).getLatitude(), apiKey));
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (MalformedURLException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }

    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
