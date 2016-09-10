package com.learning.pranavjain.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Making a random object
        Random random = new Random();
        final int randomNumber = random.nextInt(100);

        final EditText input = (EditText) findViewById(R.id.editText);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });

        /*Window window = (Window) activity.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(activity.getResources().getColor(R.color.my_statusbar_color));*/

        TextView higher = (TextView) findViewById(R.id.textView2);
        TextView right = (TextView) findViewById(R.id.textView3);
        TextView lower = (TextView) findViewById(R.id.textView4);

        higher.setVisibility(View.INVISIBLE);
        right.setVisibility(View.INVISIBLE);
        lower.setVisibility(View.INVISIBLE);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                count++;
                HigherOrLower(view,randomNumber,count);
            }
        });
    }

    public void HigherOrLower(View view,int randomNumber, int count){

        //Control over Input
        EditText input = (EditText) findViewById(R.id.editText);

        //Control over the Output
        TextView higher = (TextView) findViewById(R.id.textView2);
        TextView right = (TextView) findViewById(R.id.textView3);
        TextView lower = (TextView) findViewById(R.id.textView4);

        //Get the Number
        if(input.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();
        }else {
            int inputNumber = Integer.parseInt(input.getText().toString());

            //logic
            if (inputNumber == randomNumber) {
                higher.setVisibility(View.INVISIBLE);
                right.setVisibility(View.VISIBLE);
                lower.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You did it in " + count + " turns!", Toast.LENGTH_SHORT).show();
            } else if (inputNumber <= randomNumber) {
                higher.setVisibility(View.VISIBLE);
                right.setVisibility(View.INVISIBLE);
                lower.setVisibility(View.INVISIBLE);
            } else {
                higher.setVisibility(View.INVISIBLE);
                right.setVisibility(View.INVISIBLE);
                lower.setVisibility(View.VISIBLE);
            }
        }

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
