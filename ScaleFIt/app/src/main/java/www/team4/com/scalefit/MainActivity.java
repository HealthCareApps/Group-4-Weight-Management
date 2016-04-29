package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final boolean On = true;
    private static final boolean Off = false;
    private final static String TAG = Activity.class.getSimpleName();
    Context context;

    String TITLES[] = {
            "Home",
            "Profile",
            "Weigh In",
            "Team",
            "Settings",
            "Logout"};
    int ICONS[] = {
            R.drawable.ic_account_balance_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_assignment_black_24dp,
            R.drawable.ic_group_black_24dp,
            R.drawable.ic_settings_black_24dp,
            R.drawable.ic_keyboard_tab_black_24dp};

    String NAME = "Andrew Barbosa";
    String EMAIL = "abab@gmail.com";
    int PROFILE = R.drawable.andrew2;
    private Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (On) Log.i(TAG, "onCreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        if (On) Log.i(TAG, "Toolbar Created");
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MainMenuAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE, this);


        mRecyclerView.setAdapter(mAdapter);

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    Drawer.closeDrawers();
                    Toast.makeText(MainActivity.this,"Main MenuThe Item Clicked is: "+recyclerView.getChildAdapterPosition(child), Toast.LENGTH_SHORT).show();

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        mRecyclerView.setOnClickListener(new RecyclerView.OnClickListener() {

            public void onClick(View v) {
                Intent intent = null;

                /*switch(getAdapterPosition()) {
                    case 0:
                        intent = new Intent(context, MainActivity.class);
                        break;
                    case 1:
                        intent = new Intent(context, ProfileActivity.class);
                        break;
                    case 2:
                        intent = new Intent(context, weightScreenActivity.class);
                        break;
                    case 3:
                        intent = new Intent(context, Team4Activity.class);
                        break;
                    case 4:
                        intent = new Intent(context, Settings.class);
                        break;

                    default:
                        break;
                }*/
            }

        });

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.openDrawer,
                R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        };
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }



}



