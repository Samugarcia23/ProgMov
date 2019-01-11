package com.example.sam.ejemplologin;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MiViewModel extends ViewModel {

    private List<String> mails;
    private List<String> passwords;

    public MiViewModel(){
        users();
    }

    /*public List<String> getPassword(){
        if (passwords == null){
            passwords = new ArrayList<>();
            users();
        }
        return passwords;
    }

    public List<String> getMail(){
        if (mails == null){
            mails = new ArrayList<>();
            users();
        }
        return mails;
    }*/

    public boolean setUser(String mail, String pass){
        boolean added;
        if(!mailExists(mail)){
            mails.add(mail);
            passwords.add(pass);
            added = true;
        }else
            added = false;

        return added;
    }

    private void users(){
        mails = new ArrayList<>();
        passwords = new ArrayList<>();
        mails.add("admin");
        passwords.add("admin");
    }

    private boolean mailExists(String mail){
        boolean exists = false;
        /*for (int i=0; i<mails.size(); i++){
            if(mails.get(i).equals(mail)){
                exists = true;
            }else
                exists = false;
        }*/
            if(mails.contains(mail)){
                exists = true;
            }else
                exists = false;

        return exists;
    }


}
