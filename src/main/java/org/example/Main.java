package org.example;

public class Main {

    public static void main(String[] args) {

        Streets street1 = new Streets (39, 400, 50, "Schloss Alle", 200, 50, 200, 600, 1400, 1700, 2000);
        Taxes taxes1 = new Taxes (38, "Zusatzsteuer", 100);
        Streets street2 = new Streets (37, 350, 35, "Parkstraße", 200, 35, 175, 500, 1100, 1300, 1500);
        SpecialFields sf1 = new SpecialFields (36, "3. Ereignisfeld", "Recently I introduced two of my lisping friends to each other."
                + " - After a short but rough fist fight they realized that neither was mocking the other");
        TrainStation trainStation1 = new TrainStation (35, 250, 25, "Nordbahnhof", 25, 50, 100, 200);
        Streets street3 = new Streets (34, 320, 28, "Bahnhofstraße", 200, 28, 150, 450, 1000, 1200, 1400);
        SpecialFields sf2 = new SpecialFields (33, "3. Gemeinschaftsfeld ", "It has four legs and it can fly, what is it?"
                + " - Two birds!");
        Streets street4 = new Streets (32, 300, 26, "Hauptstraße", 200, 26, 130, 390, 900, 1100, 1275);
        Streets street5 = new Streets (31, 300, 26, "Rathausplatz", 200, 26, 130, 390, 900, 1100, 1275);
        OtherFields field1 = new OtherFields (20, "Gefängnis!!", "_");
        Streets street6 = new Streets (29, 280, 24, "Göthestraße", 150, 24, 120, 360, 850, 1025, 1200);
        Factories f1 = new Factories (28, "Wasserwerke", 150);
        Streets street7 = new Streets (27, 260, 22, "Schillerstraße", 150, 22, 110, 330, 800, 975, 1150);
        Streets street8 = new Streets (26, 260, 22, "Lessingstraße", 150, 22, 110, 330, 800, 975, 1150);
        TrainStation trainStation2 = new TrainStation (25, 250, 25, "Westbahnhof", 25, 50, 100, 200);
        Streets street9 = new Streets (24, 230, 20, "Opernplatz", 150, 20, 100, 300, 750, 925, 1100);
        Streets street10 = new Streets (23, 220, 18, "Museumstraße", 150, 18, 90, 250, 700, 875, 1050);
        SpecialFields sf3 = new SpecialFields (22, "2. Ereignisfeld ", "Wow, honey, I never thought our son would go that far!"
                + "  - Yeah, the catapult is really amazing. Go get our daughter!");
        Streets street11 = new Streets (21, 220, 18, "Theaterstraße", 150, 18, 90, 250, 700, 875, 1050);
        OtherFields field2 = new OtherFields (20, "Jaaaaackpot!!", "_");
        Streets street12 = new Streets (19, 200, 16, "Berlinerstraße", 100, 16, 80, 220, 600, 800, 1000);
        Streets street13 = new Streets (18, 180, 14, "Wiener Straße", 100, 14, 70, 200, 550, 750, 950);
        SpecialFields sf4 = new SpecialFields (17, "2. Gemeinschaftsfeld ", "What do you get when you cross a bunny and a Rottweiler?"
                + " - Just the Rottweile!");
        Streets street14 = new Streets (16, 180, 14, "Münchner Straße", 100, 14, 70, 200, 550, 750, 950);
        TrainStation trainStation3 = new TrainStation (15, 250, 25, "Südbahnhof", 25, 50, 100, 200);
        Streets street15 = new Streets (14, 160, 12, "Neue Straße", 100, 12, 60, 180, 500, 700, 900);
        Streets street16 = new Streets (13, 140, 10, "Hafenstraße", 100, 10, 50, 150, 450, 625, 750);
        Factories f2 = new Factories (12, "Elektrizitätswerke", 150);
        Streets street17 = new Streets (11, 140, 10, "Seestraße", 100, 10, 50, 150, 450, 625, 750);
        OtherFields field3 = new OtherFields (10, "Nur zu Besuch!", "_");
        Streets street18 = new Streets (9, 120, 8, "Poststraße", 50, 8, 40, 100, 300, 450, 600);
        Streets street19 = new Streets (8, 100, 6, "Elisenstraße", 50, 6, 30, 90, 270, 400, 550);
        SpecialFields sf5 = new SpecialFields (7, "1. Ereignisfeld ", "What is cold and stands under a street lamp? "
                + "- A frostitute.");
        Streets street20 = new Streets (6, 100, 6, "Chaussestraße", 50, 6, 30, 90, 270, 400, 550);
        TrainStation trainStation4 = new TrainStation (5, 250, 25, "Hauptbahnhof", 25, 50, 100, 200);
        Taxes taxes2 = new Taxes (4, "Einkommenssteuer", 200);
        Streets street21 = new Streets (3, 60, 4, "Turmstraße", 50, 4, 20, 60, 180, 320, 450);
        SpecialFields sf6 = new SpecialFields (2, "1. Gemeinschaftsfeld ", "Which bus never drove on any street? "
                + " - The globus.");
        Streets street22 = new Streets (1, 60, 2, "Badstraße", 50, 2, 10, 30, 90, 160, 250);
        OtherFields field4 = new OtherFields (0, "Starting position", "_");

        Players player1 = new Players("Veronika");
        Players player2 = new Players("Julius");
        Players player3 = new Players("Raphael");
        Players player4 = new Players("Papa");

        int numberOfPlayers = 4;

        GameBoard gameboard = new GameBoard(street22, street21, street20, street19, street18, street17, street16, street15, street14, street13, street12, street11, street10, street9, street8, street7, street6, street5, street4, street3,
                street2, street1, trainStation4, trainStation3, trainStation2, trainStation1, taxes2, taxes1, sf6, sf5, sf4, sf3, sf2, sf1, f2, f1, field4, field3, field2, field1);

        Game hereAndNow = new Game(player1, player2, player3, player4, gameboard, numberOfPlayers);

        hereAndNow.launchGame();

    }

}