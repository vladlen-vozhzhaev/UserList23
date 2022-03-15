package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {
    EditText editTextName;
    EditText editTextLastname;
    EditText editTextPhone;
    Button addUserBtnInForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        editTextName = findViewById(R.id.editTextName);
        editTextLastname = findViewById(R.id.editTextLastname);
        editTextPhone = findViewById(R.id.editTextPhone);
        addUserBtnInForm = findViewById(R.id.addUserBtnInForm);
        addUserBtnInForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(editTextName.getText().toString());
                user.setLastname(editTextLastname.getText().toString());
                user.setPhone(editTextPhone.getText().toString());
                Users users = Users.getUsers();
                users.addUser(user);
                onBackPressed();
            }
        });
    }
}