package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;
import www.team4.com.scalefit.LoginForRegisterActivity;

public class UserInformationActivity extends AppCompatActivity {



    private static  final boolean On = true;
    private static  final boolean Off = false;
    private final static String TAG = UserInformationActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase("https://scalefit.firebaseio.com/users");




        Button btnRegister;
        btnRegister =(Button)findViewById(R.id.button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText fName = (EditText)findViewById(R.id.editText);
                String firstName = fName.getText().toString();
                final Firebase ref = new Firebase("https://scalefit.firebaseio.com/users");
                if (On) Log.i(TAG, "MAYBE YOU NOW");
                Map<String, Object> map = new HashMap<String , Object>();
                map.put("First Name", firstName);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginForRegisterActivity.Session_KEY2.getUid()).updateChildren(map);

                EditText lName = (EditText)findViewById(R.id.editText2);
                String lastName = lName.getText().toString();
                if (On) Log.i(TAG, "MAYBE YOU NOW");
            //    Map<String, Object> map = new HashMap<String , Object>();
                map.put("Last Name", lastName);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginForRegisterActivity.Session_KEY2.getUid()).updateChildren(map);

                EditText Age = (EditText)findViewById(R.id.editText3);
                Double age = Double.parseDouble(Age.getText().toString());
                if (On) Log.i(TAG, "MAYBE YOU NOW");
          //      Map<String, Object> map = new HashMap<String , Object>();
                map.put("Age", age);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginForRegisterActivity.Session_KEY2.getUid()).updateChildren(map);


                EditText hF = (EditText)findViewById(R.id.editText6);
                Double HF = Double.parseDouble(Age.getText().toString());
                if (On) Log.i(TAG, "MAYBE YOU NOW");
                // Map<String, Object> map = new HashMap<String , Object>();
                map.put("Hieght(feet)", HF);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginForRegisterActivity.Session_KEY2.getUid()).updateChildren(map);

                EditText hI = (EditText)findViewById(R.id.editText7);
                Double HI = Double.parseDouble(Age.getText().toString());
                if (On) Log.i(TAG, "MAYBE YOU NOW");
                // Map<String, Object> map = new HashMap<String , Object>();
                map.put("Hieght(inch)", HI);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginForRegisterActivity.Session_KEY2.getUid()).updateChildren(map);


                startActivity(new Intent(UserInformationActivity.this, MainActivity.class));
                UserInformationActivity.this.finish();

            }

        });
    }}