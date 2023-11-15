package org.example;

public class Fields {

    public int position;
    private String name;

    public Fields (int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition () {
        return position;
    }

    public String getName () {
        return name;
    }

}
