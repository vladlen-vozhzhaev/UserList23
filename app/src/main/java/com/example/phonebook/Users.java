package com.example.phonebook;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> userList = new ArrayList<>();
    private static Users users;

    private Users() {
    }

    public static Users getUsers(){
        if(users == null)
            users =  new Users();
        return users;
    }

    // Метод добавленя пользователя в коллекцию
    public void addUser(User user){
        this.userList.add(user);
    }
    public ArrayList<User> getUserList(){
        return userList;
    }
}
