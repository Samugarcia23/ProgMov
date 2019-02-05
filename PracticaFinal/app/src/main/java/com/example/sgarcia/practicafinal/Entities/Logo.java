package com.example.sgarcia.practicafinal.Entities;

/*
 *
 *   Clase Logo. Contiene:
 *
 *   - name --> Nombre del logo
 *   - img --> imagen del logo
 *   - guessed --> Logo acertado o no acertado
 *
 */

import com.example.sgarcia.practicafinal.Others.Alphabet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Logo {

    //Definicion de parametros

    private String name;
    private int img;
    private boolean guessed;
    private ArrayList<Character> charList;


    //Constructor por defecto

    public Logo(){}

    //Constructor por parametros

    public Logo(String name, int img, boolean guessed) {

        this.name = name;
        this.img = img;
        this.guessed = guessed;
        this.charList = new ArrayList<>();


        char[] answer;
        int howmany;
        Random rnd = new Random();
        answer = name.toCharArray();
        Alphabet.selectedName = new char[answer.length];

        for (char letter : answer){
            charList.add(letter);
        }

        if (answer.length < 10)
            howmany = answer.length * 2;
        else
            howmany = 21;

        for (int i = answer.length; i<howmany; i++)
            charList.add(Alphabet.alphabet[rnd.nextInt(Alphabet.alphabet.length)]);

        Collections.shuffle(charList);
    }

    //GETTERS & SETTERS

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    public ArrayList<Character> getCharList() {
        return charList;
    }
}
