package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addUserBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addUserBtn = findViewById(R.id.addUserBtn);
        recyclerView = findViewById(R.id.recyclerView);
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUser.class);
                startActivity(intent);
            }
        });
        /*String[] users = new String[100];
        for (int i = 0; i < 100; i++) {
            users[i] = "user - " + (i + 1);
        }*/
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public void recyclerViewInit(){
        Users users = Users.getUsers(MainActivity.this);
        UserAdapter userAdapter = new UserAdapter(users.getUserList());
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
    }

    // Класс держателя одного элемента списка
    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemTextView;
        User user;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);
        }
        public void bind(User user){
            this.user = user;
            itemTextView.setText(user.getName()+" "+user.getLastname());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
            intent.putExtra("user", this.user);
            startActivity(intent);
        }
    }

     public class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> userList = new ArrayList<>();
        public UserAdapter(ArrayList<User> userList) {
            this.userList = userList;
        }
        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int position) {
            User user = userList.get(position);
            holder.bind(user);
        }
        @Override
        public int getItemCount(){
            return userList.size();
        }
    }
}