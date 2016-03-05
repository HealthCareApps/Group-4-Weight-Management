package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class mainActivity extends AppCompatActivity {

    private static  final boolean On = true;
    private static  final boolean Off = false;

    private final static String TAG = Activity.class.getSimpleName();



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        if (On) Log.i(TAG, "onCreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        if (On) Log.i(TAG, "Toolbar Created");
        setSupportActionBar(toolbar);



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
            if (On) Log.i(TAG, "Action Settings Selected");
            return true;
        }
        if (id == R.id.action_about) {
            if (On) Log.i(TAG, "Action About Selected");
            startActivity(new Intent(this, aboutActivity.class));
        }
        if (id == R.id.action_team) {
            if (On) Log.i(TAG, "Action Team Selected");
            startActivity(new Intent(this, teamActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
