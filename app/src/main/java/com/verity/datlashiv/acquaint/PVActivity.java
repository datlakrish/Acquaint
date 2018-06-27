package com.verity.datlashiv.acquaint;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.verity.datlashiv.acquaint.Adapter.FragmentAdapter;

public class PVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pv);


        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tutorials");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        viewPager.setOffscreenPageLimit(getResources().getStringArray(R.array.tabs_name).length);
        tabLayout.setupWithViewPager(viewPager);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
