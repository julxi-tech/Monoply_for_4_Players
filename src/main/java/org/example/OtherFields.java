package org.example;

public class OtherFields extends Fields {

    public String notImportant;

    public OtherFields (int position, String name, String anything) {
        super (position, name);
        this.notImportant = anything;
    }


}
