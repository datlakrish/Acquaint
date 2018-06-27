package com.verity.datlashiv.acquaint.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.verity.datlashiv.acquaint.Adapter.MainAdapter;
import com.verity.datlashiv.acquaint.ProfileActivity;
import com.verity.datlashiv.acquaint.R;
import com.verity.datlashiv.acquaint.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mAuth;
    private ViewFlipper viewFlipper;
    private int view[] = {R.drawable.anydesk, R.drawable.chrom, R.drawable.os};
    private RecyclerView recyclerView;
    private MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        switch (position) {
                            case 0:
                                Intent i = new Intent(MainActivity.this, OsActivity.class);
                                startActivity(i);
                                break;
                            case 1:
                                Intent i2 = new Intent(MainActivity.this, LanguageActivity.class);
                                startActivity(i2);
                                break;
                            case 2:
                                Intent i3 = new Intent(MainActivity.this, DataBaseActivity.class);
                                startActivity(i3);
                                break;

                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );


        viewFlipper = findViewById(R.id.viewFlipper);

        for (int views : view) {
            viewFlipper(views);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_tutorial) {

            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_codeground) {

            Toast.makeText(this, "Code Ground", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_talkback) {

            Toast.makeText(this, "Talk Back", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_logout) {

            Logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void Logout() {
        mAuth.signOut();
        Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(logoutIntent);
        finish();
    }

    public void viewFlipper(int views) {
        ImageView imageview = new ImageView(this);
        imageview.setBackgroundResource(views);

        viewFlipper.addView(imageview);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
