package org.example;


public class TrainStation extends Fields {

    private int prize;
    public int rent;
    //private String trainStationName;
    public int [] rentHolder;
    public boolean bought;
    public Players owner;


    public TrainStation (int position, int p, int rent, String name, int r0, int r1, int r2, int r3) {
        super (position, name);
        this.prize = p;
        this.rent = rent;
        //this.trainStationName = name;
        this.rentHolder = createRentHolder(r0, r1, r2, r3);
        this.bought = false;
        this.owner = null;





    }

    public int getRent() {
        return rent;
    }

    public int getPrize() {
        return prize;
    }

    public Players getOwners () {
        return owner;
    }


    public String getOwnersName () {
        return owner.getPlayersName();
    }

//	public String getStationName() {
//		return trainStationName;
//	}

    public int [] createRentHolder (int r0, int r1, int r2, int r3) {
        int [] dummyHolder = new int [5];
        dummyHolder [0] = 0;
        dummyHolder [1] = r0;
        dummyHolder [2] = r1;
        dummyHolder [3] = r2;
        dummyHolder [4] = r3;
        return dummyHolder;
    }
}

