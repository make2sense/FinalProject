package com.lmcloud.jokeslibandroid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    public final static String INTENT_JOKES = "JOKES_INTENT";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        TextView jokeView = (TextView)findViewById(R.id.joke_view_aLib);
        getSupportActionBar().setTitle(R.string.barTitle);
        // Receiving the joke intent
        String joke = getIntent().getStringExtra(INTENT_JOKES);
        if(joke!=null){
            jokeView.setText(joke);
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