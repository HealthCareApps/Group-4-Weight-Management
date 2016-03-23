package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreenActivity extends Activity {

    private static boolean splashCount = false;
    private final int SPLASH_LENGTH = 4000; // 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (!splashCount) {
            setContentView(R.layout.content_splash_screen);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    /*Intent ContainerIntent = new Intent(splash_Screen_Activity.this,
                            ContainerActivity.class);
                    splash_Screen_Activity.this.startActivity(ContainerIntent);*/
                    startActivity(new Intent(splashScreenActivity.this, mainActivity.class));
                    splashScreenActivity.this.finish();
                }

            }, SPLASH_LENGTH);

            splashCount = true;
        } else {
            Intent goToContainer = new Intent(splashScreenActivity.this, mainActivity.class);
            goToContainer.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToContainer);
            finish();

        }


    }

}