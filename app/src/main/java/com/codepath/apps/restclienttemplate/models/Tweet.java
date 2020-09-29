package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Tweet {

    public  String body;
    public  String createdAt;
    public long id;
    public User user;
    // empty constructor parcel obect
    public Tweet(){}


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt =jsonObject.getString("created_at");
        tweet.id=jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getFormattedTimestamp(String createdAt){
       String formattedTime = TimeFormatter.getTimeDifference(createdAt);
       return formattedTime;

    }


    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }


}
