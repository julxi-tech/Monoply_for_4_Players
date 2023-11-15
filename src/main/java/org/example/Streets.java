package org.example;


public class Streets extends Fields {

    private int prize;
    public int rent;
    public int [] rentHolder;
    //private String streetName;
    public int numberOfHouses;
    private int costForOneHouse;
    public boolean bought;
    public Players owner;

    public Streets(int position, int prize, int rent, String name, int costForOneHouse, int r0, int r1, int r2, int r3, int r4, int r5 ) {
        super (position, name);
        this.prize = prize;
        this.rent = rent;
        this.rentHolder = createRentHolder(r0, r1, r2, r3, r4, r5);
        //this.streetName = name;
        this.costForOneHouse = costForOneHouse;
        this.numberOfHouses = 0;
        this.bought = false;
        this.owner = null;


    }

//	public String getStreetName() {
//		return streetName;
//	}

    public int getPrize() {
        return prize;
    }

    public int getRent() {
        return rent;
    }

    public String getOwnersName() {
        return owner.getPlayersName();
    }

    public Players getOwner() {
        return owner;
    }

    public int getCostForOneHouse () {
        return costForOneHouse;
    }

    public int getNumberOfHouses () {
        return numberOfHouses;
    }

//	public String getDescription() {
//		return ("The street " + getStreetName() + " costs " + getPrize() + " and gives you a rent of " + getRent()
//				+ "it is currently owned by " + getOwnersName());
//
//	}

    public int [] createRentHolder (int r0, int r1, int r2, int r3, int r4, int r5) {
        int [] dummyHolder = new int [6];
        dummyHolder [0] = r0;
        dummyHolder [1] = r1;
        dummyHolder [2] = r2;
        dummyHolder [3] = r3;
        dummyHolder [4] = r4;
        dummyHolder [5] = r5;
        return dummyHolder;
    }

}

