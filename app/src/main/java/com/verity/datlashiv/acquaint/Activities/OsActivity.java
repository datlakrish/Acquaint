package com.verity.datlashiv.acquaint.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.system.Os;
import android.view.View;

import com.verity.datlashiv.acquaint.Adapter.RecyclerAdapter;
import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;
import com.verity.datlashiv.acquaint.R;
import com.verity.datlashiv.acquaint.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OsActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<MainCourse> mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);

        rv = findViewById(R.id.recyclerView_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        mc = new ArrayList<>();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        try {
            JSONObject jsonObject = new JSONObject(RawJson());
            JSONArray jsonArray = jsonObject.getJSONArray("acquaint");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                JSONArray array = object.getJSONArray("os_fields");
                for (int j = 0; j < array.length(); j++) {
                    JSONObject object1 = array.getJSONObject(j);
                    mc.add(new MainCourse(object1.getString("os_name"),
                            object1.getString("imageUrl")
                    ));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerAdapter = new RecyclerAdapter( getApplicationContext(), mc);
        rv.setAdapter(recyclerAdapter);


        rv.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position) {
                    case 0:
                        Intent i = new Intent(OsActivity.this, SubWindowsList.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i2 = new Intent(OsActivity.this, SubLinuxList.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(OsActivity.this, SubUnixList.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(OsActivity.this, SubMacList.class);
                        startActivity(i4);
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));
    }

    private String RawJson() {
        String JSONString = null;
        StringBuilder builder = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.raws);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((JSONString = bufferedReader.readLine()) != null) {
                builder.append(JSONString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(builder);
    }

}
