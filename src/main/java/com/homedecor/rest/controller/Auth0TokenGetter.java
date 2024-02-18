package com.homedecor.rest.controller;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class Auth0TokenGetter {


    private static final String TOKEN_ENDPOINT = "https://dev-g0x0op01bv84wgly.us.auth0.com/oauth/token";
    private static final String CLIENT_ID = "3oOIvczrr6ANB0joYCypUz4waJ6BdDPL";
    private static final String CLIENT_SECRET = "xxAJ6yCb_ORy-PTvgJ-8k2fA0YHBzX4cXKYRBWbv99jLgMtBoJM9KLuCwKWdgQXC";
    private static final String AUDIENCE = "https://dev-g0x0op01bv84wgly.us.auth0.com/api/v2/";
    private static final String GRANT_TYPE = "client_credentials";

    public static void main(String[] args) {
        getAccessToken();
    }

    public static String getAccessToken() {
        JSONObject requestBody = new JSONObject()
                .put("client_id", CLIENT_ID)
                .put("client_secret", CLIENT_SECRET)
                .put("audience", AUDIENCE)
                .put("grant_type", GRANT_TYPE);

        HttpResponse<String> response = Unirest.post(TOKEN_ENDPOINT)
                .header("content-type", "application/json")
                .body(requestBody.toString())
                .asString();

        if (response.isSuccess()) {
            JSONObject jsonResponse = new JSONObject(response.getBody());
            String accessToken = jsonResponse.getString("access_token");
            return accessToken;
        } else {
            System.err.println("Failed to obtain access token. Status code: " + response.getStatus());
        }
        return null;
    }
}
