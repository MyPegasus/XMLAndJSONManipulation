package com.example.mypegasus.xmlandjsonmanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonManipulationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*try {
            InputStream is = getAssets().open("test.json");
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            String in;
            while ((in = br.readLine()) != null) {
                buffer.append(in);
            }
            br.close();
            isr.close();
            is.close();

            JSONObject jsonObject = new JSONObject(buffer.toString());
            JSONObject languages = jsonObject.getJSONObject("languages");
            String cat = languages.getString("cat");
            System.out.println("cat: " + cat);
            JSONArray lans = languages.getJSONArray("lan");
            for (int i = 0; i < lans.length(); i++) {
                JSONObject lan = lans.getJSONObject(i);
                System.out.println("--------------------------------");
                System.out.println(String.format("id: %d, name: %s, ide: %s", lan.getInt("id"), lan.getString("name"), lan.getString("ide")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        try {
            JSONObject root = new JSONObject();
            JSONObject languages = new JSONObject();
            languages.put("cat", "it");
            JSONArray lans = new JSONArray();
            JSONObject lan1 = new JSONObject();
            lan1.put("id", 1);
            lan1.put("name", "Java");
            lan1.put("ide", "Eclipse");
            lans.put(lan1);
            JSONObject lan2 = new JSONObject();
            lan2.put("id", 2);
            lan2.put("name", "Swift");
            lan2.put("ide", "XCode");
            lans.put(lan2);
            JSONObject lan3 = new JSONObject();
            lan3.put("id", 3);
            lan3.put("name", "C#");
            lan3.put("ide", "Visual Studio");
            lans.put(lan3);

            languages.put("lan", lans);

            root.put("languages", languages);

            System.out.println(root.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
