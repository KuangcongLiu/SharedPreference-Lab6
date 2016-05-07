package com.example.liukuangcong.shared_pref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        saveInfo();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    public void saveInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "uu");
        editor.putString("password", "pp");
        editor.putString("address", "ucsd");
        editor.apply();
        //Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }


    public void displayInfo(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String name=sharedPreferences.getString("username","");
        String myname=((TextView)findViewById(R.id.username)).getText().toString();

        if(name.equals(myname)) {
            String passord = sharedPreferences.getString("password", "");
            String address = sharedPreferences.getString("address", "");
            Log.d("password",passord);
            Log.d("address",address);
            TextView sname = (TextView) findViewById(R.id.sname);
            TextView sadd = (TextView) findViewById(R.id.spass);
            sname.setText(passord);
            sadd.setText(address);
        }
        else {
            TextView sname = (TextView) findViewById(R.id.sname);
            Log.d("name",name);
            Log.d("myname",myname);
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

        }

    }


    public void save (View view) {
        EditText uname = (EditText) findViewById(R.id.uname);
        EditText upass = (EditText) findViewById(R.id.upass);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", uname.getText().toString());
        editor.putString("password", upass.getText().toString());
        editor.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void display (View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String name=sharedPreferences.getString("username","");
        String passord=sharedPreferences.getString("password","");
        TextView sname=(TextView) findViewById(R.id.sname);
        TextView spass=(TextView) findViewById(R.id.spass);
        sname.setText(name);
        spass.setText(passord);
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
