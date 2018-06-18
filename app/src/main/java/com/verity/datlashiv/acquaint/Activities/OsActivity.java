package com.verity.datlashiv.acquaint.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.verity.datlashiv.acquaint.Adapter.RecyclerAdapter;
import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;
import com.verity.datlashiv.acquaint.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class OsActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerAdapter recyclerAdapter;
    ArrayList<MainCourse> mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);
        rv = findViewById(R.id.recyclerView_view);
        recyclerAdapter = new RecyclerAdapter(getApplicationContext(),mc);
        rv.setAdapter(recyclerAdapter);
        mc = new ArrayList<>();
        rv.setHasFixedSize(true);
       rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {
            JSONObject jsonObject = new JSONObject(RawJson());
            JSONArray jsonArray = jsonObject.getJSONArray("os_fields");
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                //Log.i("Name", object.getString("name"));
                mc.add(new MainCourse(object.getString("os_name")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private String RawJson() {
        String JSONString = null;
        StringBuilder builder = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.raws);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((JSONString = bufferedReader.readLine())!= null){
                builder.append(JSONString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(builder);
    }

}
