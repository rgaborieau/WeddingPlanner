package com.atoukprod.weddingplanner.utils;

import com.atoukprod.weddingplanner.model.Guest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeddingAPI {

    private static final String API_URL = "http://192.168.1.40:3000";
    private static final int HTTP_CODE_OK = 200;

    private static OkHttpClient client = null;

    public static ArrayList<Guest> getGuests() {
        Request request = new Request.Builder().url(API_URL + "/guest/").build();

        ArrayList<Guest> guests = new ArrayList<>();

        try {
            Response response = getClient().newCall(request).execute();
            if(response.code() == HTTP_CODE_OK){
                JsonArray array = new JsonParser().parse(response.body().string()).getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    JsonObject guestJson = array.get(i).getAsJsonObject();
                    Guest guest = new Guest(guestJson.get("firstname").getAsString(), guestJson.get("lastname").getAsString());
                    guest.setPresent(guestJson.get("present").getAsBoolean());
                    guests.add(guest);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return guests;
    }

    private static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }
}
