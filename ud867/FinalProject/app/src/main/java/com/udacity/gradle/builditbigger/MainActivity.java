package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.jokes.Joker;


public class MainActivity extends AppCompatActivity {
    private Joker mJoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment,new MainActivityFragment()).commit();
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


    public void tellJoke(View view){
        /**
        //Toast.makeText(this, mJoker.getRandomJoke(), Toast.LENGTH_SHORT).show();
        // Getting a random joke from jokeslibandroid
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra(JokesActivity.INTENT_JOKES, joke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
         */
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new EndpointsAsyncTask(this,progressBar).execute();
    }
}
