package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

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
        userInfoDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users users = Users.getUsers(UserInfoActivity.this);
                UUID uuid = user.getUuid();
                users.deleteUser(uuid);
                onBackPressed();
            }
        });
        userInfoEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, EditUserActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}