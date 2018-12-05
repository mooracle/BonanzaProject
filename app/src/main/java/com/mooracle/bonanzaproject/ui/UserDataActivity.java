package com.mooracle.bonanzaproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.mooracle.bonanzaproject.R;
import com.mooracle.bonanzaproject.model.User;

public class UserDataActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText fullnameEditText;
    private EditText userAgeEditText;
    private EditText userLocationEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton genderRadioButton;

    public static final String TAG = UserDataActivity.class.getSimpleName(); /*This is only for debug*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        usernameEditText = findViewById(R.id.editTextUsername);
        fullnameEditText = findViewById(R.id.editTextRealName);
        userAgeEditText = findViewById(R.id.editTextAge);
        userLocationEditText = findViewById(R.id.editTextLocation);
        genderRadioGroup = findViewById(R.id.radioGroupGender);

        Button submitButton = findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User user = createNewUser();

                    /*Debug the user creation:*/
                    Log.d(TAG, "onClickAge:" + user.getAge());
                    Log.d(TAG, "onClick username: " + user.getUsername());
                    Log.d(TAG, "onClick gender: " + user.getGender());

                    startNewUser(user);
                } catch (NumberFormatException e){
                    Toast.makeText(UserDataActivity.this,
                            "age format not supported", Toast.LENGTH_SHORT).show();

                } catch (IllegalArgumentException e){
                    Toast.makeText(UserDataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e){
                    Toast.makeText(UserDataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void startNewUser(User user) {
        Intent intent = new Intent(this, NewUserActivity.class);

        intent.putExtra(getString(R.string.key_user), user);
        startActivity(intent);
    }

    private User createNewUser() throws IllegalArgumentException{
        String username = usernameEditText.getText().toString();

        String fullName = fullnameEditText.getText().toString();

        int userAge = Integer.parseInt(userAgeEditText.getText().toString());
        String userLocation = userLocationEditText.getText().toString();

        genderRadioButton = findViewById(genderRadioGroup.getCheckedRadioButtonId());
        String gender = genderRadioButton.getText().toString();
        if (gender == null){throw new NullPointerException("gender must be specified");}

        return new User(username, fullName, userAge, userLocation, gender);
    }
}
