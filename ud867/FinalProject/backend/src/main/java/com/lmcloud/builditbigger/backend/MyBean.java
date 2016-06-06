package com.lmcloud.builditbigger.backend;
import com.udacity.gradle.jokes.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    private Joker mJoker;

    public MyBean(String joke){
        myData = joke;
    }
    public String getData() {
        return myData;
    }
}