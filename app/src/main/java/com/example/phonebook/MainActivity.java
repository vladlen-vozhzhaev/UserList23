package com.example.phonebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        String[] users = new String[100];
        for (int i = 0; i < 100; i++) {
            users[i] = "user - " + (i + 1);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        UserAdapter userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
    }
    public class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String user){
            itemTextView.setText(user);
        }
    }

     public class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        String[] userList = new String[100];
        public UserAdapter(String[] userList) {
            this.userList = userList;
        }
        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int position) {
            String user = userList[position];
            holder.bind(user);
        }
        @Override
        public int getItemCount(){
            return userList.length;
        }
    }


}