package com.example.sam.ejemplologin;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MiViewModel extends ViewModel {

    private List<String> mails;
    private List<String> passwords;
    private List<String> usernames;
    private ArrayList<User> userList = new ArrayList<>();
    private MutableLiveData<ArrayList<User>> mUserList = new MutableLiveData<>();

    public MiViewModel(){
        users();
    }

    public boolean setUser(String mail, String pass, String user){
        boolean added;
        if(!mailExists(mail)){
            mails.add(mail);
            passwords.add(pass);
            usernames.add(user);
            added = true;
        }else
            added = false;

        return added;
    }

    private void users(){
        mails = new ArrayList<>();
        passwords = new ArrayList<>();
        usernames = new ArrayList<>();
        mails.add("admin");
        passwords.add("admin");
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
            if (userList.get(i).getUsername().equals(user) && userList.get(i).getPassword().equals(pass))
                valido = true;
            else
                valido = false;
        }

        return  valido;
    }

}
