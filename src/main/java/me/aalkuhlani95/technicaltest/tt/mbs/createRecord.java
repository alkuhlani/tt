/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.aalkuhlani95.technicaltest.tt.mbs;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ahmed
 */
@Path("createRecord")
public class createRecord {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of createRecord
     */
    public createRecord() {
    }

    /**
     * Retrieves representation of an instance of me.aalkuhlani95.technicaltest.tt.mbs.createRecord
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of createRecord
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        JsonArray ja=new JsonArray();
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("id", UUID.randomUUID().toString());
        ja.add(jsonObject);
        return ja.toString();
    }
}
