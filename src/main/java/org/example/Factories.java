package org.example;

public class Factories extends Fields {

    //private String factoryName;
    private int prize;
    public int rent;
    public boolean bought;
    public Players owner;

    public Factories (int position, String name, int prize) {
        super(position, name);
        //this.factoryName = name;
        this.prize = prize;
        this.rent = 0;
        this.bought = false;
        this.owner = null;

    }

    public Players getOwner () {
        return owner;
    }

    public String getOwnersName() {
        return owner.getPlayersName();

    }

    public int getPrize () {
        return prize;
    }


//	public String getFactoryName () {
//		return factoryName;
//	}

}
