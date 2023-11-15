package org.example;


public class Players implements ICanBeCompared {

    private String playersName;
    private Streets[] streetHolder;
    public int budget;
    private int freeIndex;
    public int position;
    public int overallWealth;
    public int trainStationIndex;
    public int factoryIndex;


    public Players(String name) {
        this.playersName = name;
        this.streetHolder = new Streets[30];
        budget = 1500;
        overallWealth = 1500;
        freeIndex = 0;
        position = 0;
        trainStationIndex = 0;
        factoryIndex = 0;

    }

    public String getPlayersName() {
        return playersName;
    }

    public int getBudget() {
        return budget;
    }

    public void addStreet(Streets s1) {
        streetHolder[freeIndex] = s1;
        freeIndex++;
    }

    public int getPosition() {
        return position;
    }

    public String getDescription() {
        return ("The player " + getPlayersName() + " has a bduget of " + getBudget() + " and is on position "
                + getPosition());
    }

    public void buysStreet(Streets s1) {
        this.budget = this.budget - s1.getPrize();
        addStreet(s1);
        s1.bought = true;
        s1.owner = this;
    }

    public void payRent(Streets s1) {
        s1.owner.budget = s1.owner.budget + s1.getRent();
        this.budget = this.budget - s1.getRent();
        s1.owner.overallWealth = s1.owner.overallWealth + s1.getRent();
        this.overallWealth = this.overallWealth -s1.getRent();

    }

    public void buyingHouses (int howMany, Streets s1) {
        if (s1.getNumberOfHouses() <5) {
            this.budget = this.budget - (howMany * s1.getCostForOneHouse());
            s1.numberOfHouses = s1.numberOfHouses + howMany;
            s1.rent = s1.rentHolder [s1.numberOfHouses];
        }
        else;


    }

    public void payingTaxes ( Taxes t1) {
        this.budget = this.budget - t1.getTaxes();
        this.overallWealth = this.overallWealth - t1.getTaxes();


    }

    public void buyingTrainStation (TrainStation t1) {
        this.budget = this.budget - t1.getPrize();
        this.trainStationIndex ++;
        t1.bought = true;
        t1.owner = this;
        t1.rent = t1.rentHolder [t1.owner.trainStationIndex];
    }

    public void getJackpot (int jackpot) {
        this.budget = this.budget + jackpot;
        this.overallWealth = this.overallWealth + jackpot;
    }

    public void goToPrison () {
        this.budget = this.budget -50;
        this.overallWealth = this.overallWealth -50;
        this.position = 10;
    }

    public String getNewBudget () {
        return (this.getPlayersName() + "'s new budget is: " + this.getBudget());
    }

    public void payTrainRent (TrainStation t1) {
        t1.owner.budget = t1.owner.budget + t1.getRent();
        this.budget = this.budget - t1.getRent();
        t1.owner.overallWealth = t1.owner.overallWealth + t1.getRent();
        this.overallWealth = this.overallWealth -t1.getRent();
    }

    public void buyingFactory (Factories f1) {

        this.budget = this.budget - f1.getPrize();
        this.factoryIndex ++;
        f1.bought = true;
        f1.owner = this;

    }

    public void payingFactoryRent (int rent, Factories f1) {

        f1.owner.budget = f1.owner.budget + rent;
        this.budget = this.budget - rent;
        f1.owner.overallWealth = f1.owner.overallWealth + rent;
        this.overallWealth = this.overallWealth -rent;
    }


    public boolean isGreaterThan(ICanBeCompared ican) {
        boolean result = false;
        if(ican instanceof Players) {
            Players other = (Players)ican;
            result = other.overallWealth < this.overallWealth;
        }
        return result;
    }

}

