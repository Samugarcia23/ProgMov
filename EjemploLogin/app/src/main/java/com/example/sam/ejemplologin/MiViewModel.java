package com.example.sam.ejemplologin;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MiViewModel extends ViewModel {

    private ArrayList<User> userList = new ArrayList<>();
    private MutableLiveData<ArrayList<User>> mUserList;

    public MiViewModel(){}

    public MutableLiveData<ArrayList<User>> getUsers(){
        if(mUserList == null){
            mUserList = new MutableLiveData<>();
            users();
        }

        return mUserList;
    }

    private void users(){
        userList.add(new User("admin", "admin", "admin@admin.com"));
        mUserList.setValue(userList);
    }

    public void addUser(String user, String pass, String mail){
        userList.add(new User(user, pass, mail));
    }

    public boolean mailExists(String mail){
        boolean exists = false;
        for (int i=0;i<userList.size();i++) {
            if (userList.get(i).getMail().equals(mail))
                exists = true;
            else
                exists = false;
        }
        return exists;
    }

    public boolean comprobarDatos(String user, String pass){
        boolean valido = false;

        for (int i=0;i<userList.size();i++) {
            valido = userList.get(i).getUsername().equals(user) && userList.get(i).getPassword().equals(pass);
        }

        return  valido;
    }

}
