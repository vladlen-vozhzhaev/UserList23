package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {
    TextView userInfoNameTextView;
    TextView userInfoPhoneTextView;
    Button userInfoEditBtn;
    Button userInfoDelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userInfoNameTextView = findViewById(R.id.userInfoNameTextView);
        userInfoPhoneTextView = findViewById(R.id.userInfoPhoneTextView);
        userInfoEditBtn = findViewById(R.id.userInfoEditBtn);
        userInfoDelBtn = findViewById(R.id.userInfoDelBtn);
        User user = (User) getIntent().getSerializableExtra("user");
        userInfoNameTextView.setText(user.getName()+" "+user.getLastname());
        userInfoPhoneTextView.setText(user.getPhone());
    }
}