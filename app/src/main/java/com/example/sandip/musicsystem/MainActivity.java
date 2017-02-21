package com.example.sandip.musicsystem;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cleveroad.audiowidget.AudioWidget;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AudioWidget audioWidget = new AudioWidget.Builder(context).build();

        audioWidget.controller().onControlsClickListener(new AudioWidget.OnControlsClickListener() {
                                                             @Override
                                                             public boolean onPlaylistClicked() {
                                                                 return false;
                                                             }

                                                             @Override
                                                             public void onPreviousClicked() {

                                                             }

                                                             @Override
                                                             public boolean onPlayPauseClicked() {
                                                                 return false;
                                                             }

                                                             @Override
                                                             public void onNextClicked() {

                                                             }

                                                             @Override
                                                             public void onAlbumClicked() {

                                                             }

                                                             @Override
                                                             public void onPlaylistLongClicked() {

                                                             }

                                                             @Override
                                                             public void onPreviousLongClicked() {

                                                             }

                                                             @Override
                                                             public void onPlayPauseLongClicked() {

                                                             }

                                                             @Override
                                                             public void onNextLongClicked() {

                                                             }

                                                             @Override
                                                             public void onAlbumLongClicked() {


                                                             }
        });

        audioWidget.controller().onWidgetStateChangedListener(new AudioWidget.OnWidgetStateChangedListener() {
            @Override
            public void onWidgetStateChanged(@NonNull AudioWidget.State state) {
                // widget state changed (COLLAPSED, EXPANDED, REMOVED)
            }

            @Override
            public void onWidgetPositionChanged(int cx, int cy) {
                // widget position change. Save coordinates here to reuse them next time AudioWidget.show(int, int) called.
            }
        });




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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
