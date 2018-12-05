package com.mooracle.bonanzaproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.mooracle.bonanzaproject.R;

public class MainBonanza extends AppCompatActivity {
    RadioButton radioButtonOption;
    RadioGroup radioGroupOption;
    TextView textViewOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bonanza);

        radioGroupOption = findViewById(R.id.radioGroupOption);
        textViewOption = findViewById(R.id.textViewChoice);

        Button buttonApply = findViewById(R.id.buttonApply);

        buttonApply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int radioId = radioGroupOption.getCheckedRadioButtonId();

                radioButtonOption = findViewById(radioId);

                textViewOption.setText("Your Option :" + radioButtonOption.getText());

                startUserData();
            }
        });
    }

    private void startUserData() {
        Intent intent = new Intent(this, UserDataActivity.class);
        startActivity(intent);
    }
}
