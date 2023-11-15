package org.example;


public class SpecialFields extends Fields {

    String specialFieldName;
    String joke;

    public SpecialFields (int position, String name, String joke) {
        super(position, name);
        this.joke = joke;
    }


    public int getPosition () {
        return position;
    }

    public String getJoke() {
        return joke;
    }



}

