package com.example.work.cloud;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private void startWebActvity(String url) {
        Intent intent = new Intent(this, WebUrlActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView fb= (ImageView)findViewById(R.id.fb);
        ImageView yt= (ImageView)findViewById(R.id.yt);
        ImageView c= (ImageView)findViewById(R.id.c);

        fb.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                startWebActvity("https://touch.facebook.com/");

            }
        });
        yt.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                startWebActvity("https://m.youtube.com");

            }
        });
        c.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                startWebActvity("https://m.chase.com");

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
