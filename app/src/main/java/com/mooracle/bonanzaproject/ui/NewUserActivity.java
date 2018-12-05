package com.mooracle.bonanzaproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.mooracle.bonanzaproject.R;
import com.mooracle.bonanzaproject.model.User;

public class NewUserActivity extends AppCompatActivity {

    public static final String TAG = NewUserActivity.class.getSimpleName(); /*<- log debug tag*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Intent intent = getIntent();

        /*Getting the user data from the intent*/
        User user = intent.getParcelableExtra(getString(R.string.key_user));

        /*Log debug for all user data intent:*/
        Log.d(TAG, "username: " + user.getUsername());
        Log.d(TAG, "User full name: "+ user.getFullName());
        Log.d(TAG, "User Age: " + user.getAge());
        Log.d(TAG, "User Location: " + user.getLocation());
        Log.d(TAG, "User gender: " + user.getGender());
    }
}
