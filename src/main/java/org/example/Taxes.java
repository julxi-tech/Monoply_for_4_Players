package org.example;


public class Taxes extends Fields{


    //String taxName;
    int howMuch;


    public Taxes (int position, String name, int howMuch) {
        super(position, name);
        this.howMuch =howMuch;
        //this.taxName = name;

    }

    public int getTaxes() {
        return howMuch;
    }

}
