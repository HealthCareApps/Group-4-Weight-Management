package www.team4.com.scalefit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    Button btnRegister;
    TextView SignIn;
    TextView skipText;

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ScaleFitEula(this).show();
        setContentView(R.layout.activity_welcome);


        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        createButtonAndLinks();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
                WelcomeActivity.this.finish();

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                WelcomeActivity.this.finish();

            }
        });
        skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();

            }
        });



    }
    public void createButtonAndLinks(){

        btnRegister =(Button)findViewById(R.id.buttonRegister);
        SignIn =(TextView)findViewById(R.id.buttonLogin);
        skipText =(TextView)findViewById(R.id.skipText);
    }

}
