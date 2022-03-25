package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextLastname;
    EditText editTextPhone;
    Button editUserBtnInForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        editTextName = findViewById(R.id._editTextName);
        editTextLastname = findViewById(R.id._editTextLastname);
        editTextPhone = findViewById(R.id._editTextPhone);
        editUserBtnInForm = findViewById(R.id.editUserBtnInForm);
        User user = (User) getIntent().getSerializableExtra("user");
        editTextName.setText(user.getName());
        editTextLastname.setText(user.getLastname());
        editTextPhone.setText(user.getPhone());
        editUserBtnInForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users users = Users.getUsers(EditUserActivity.this);
                user.setName(editTextName.getText().toString());
                user.setLastname(editTextLastname.getText().toString());
                user.setPhone(editTextPhone.getText().toString());
                users.updateUser(user);
                onBackPressed();
            }
        });

    }
}