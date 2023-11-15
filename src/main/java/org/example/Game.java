package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Players playerA;
    private Players playerB;
    private Players playerC;
    private Players playerD;
    private GameBoard gameboard;
    private int counter = 1;
    int numberOfPlayer;
    public int jackpot = 0;

    public Game(Players p1, Players p2, Players p3, Players p4, GameBoard g1, int n) {
        this.playerA = p1;
        this.playerB = p2;
        this.playerC = p3;
        this.playerD = p4;
        this.gameboard = g1;
        this.numberOfPlayer = n;
        this.jackpot = 0;
    }

    public void gameTurn(Players p1) {

        System.out.println("It is " + p1.getPlayersName() + "'s turn!     Current Budget: " + p1.getBudget());
        int zahl = (int) (Math.random() * 12 + 1);
        System.out.println(p1.getPlayersName() + " rolls a: " + zahl);
        p1.position = p1.position + zahl;


        if (p1.position > 39) {
            p1.position = p1.position - 40;
            if (p1.position == 0) {
                p1.budget = p1.budget + 400;
                p1.overallWealth = p1.overallWealth +400;
            } else {
                p1.budget = p1.budget + 200;
                p1.overallWealth = p1.overallWealth + 200;
                System.out.println(p1.getPlayersName() + " starts next the round and gets an extra 200! New budget: "
                        + p1.getBudget());
            }

        }


        Fields fieldAtPosition = gameboard.turns[p1.getPosition()];
        System.out.println(p1.getPlayersName() + " goes to: " + fieldAtPosition.getName());





        if (fieldAtPosition instanceof OtherFields) {

            OtherFields otherFieldsAtThisPosition = (OtherFields) fieldAtPosition; //umwandeln in OtherFields Klasse

            if (p1.position == 0) {
                System.out.println(p1.getPlayersName() + " gets an extra 400!!");
                System.out.println(p1.getNewBudget());
            }

            else if (p1.position == 10) {
                System.out.println(p1.getPlayersName() + " cannot do anything... ");
                System.out.println(p1.getPlayersName() + "'s budget is still: " + p1.getBudget());
            }

            else if (p1.position == 20) {
                p1.getJackpot(jackpot);
                System.out.println(p1.getPlayersName() + " gets the Jackpot of: " + jackpot);
                System.out.println(p1.getNewBudget());
                jackpot = 0;
            }

            else if (p1.position == 30) {
                p1.goToPrison();
                System.out.println(p1.getNewBudget());

            }
        }

        else if (fieldAtPosition instanceof Taxes) {
            Taxes taxesAtThisPosition = (Taxes) fieldAtPosition; //umwandeln in Taxes Klasse
            p1.payingTaxes(taxesAtThisPosition);
            System.out.println(p1.getPlayersName() + " has to pay " + taxesAtThisPosition.getTaxes() + " in the middle!!");
            jackpot = jackpot + taxesAtThisPosition.getTaxes();
            System.out.println("The new jackpot is now: " + jackpot);
            System.out.println(p1.getNewBudget());

        }

        else if (fieldAtPosition instanceof SpecialFields) {
            SpecialFields specialFieldAtThisPosition = (SpecialFields) fieldAtPosition; //umwandeln in SpecialField Klasse
            System.out.println("Nothing special happens... to fire up the mood, here is a short joke:");
            System.out.println(specialFieldAtThisPosition.getJoke());
            System.out.println(p1.getPlayersName() + "'s budget is still: " + p1.getBudget());

        }

        else if (fieldAtPosition instanceof Factories) {

            Factories factoryAtThisPosition = (Factories) fieldAtPosition; //umwandeln in Factories Klasse

            if (factoryAtThisPosition.bought == true) {

                if (factoryAtThisPosition.owner == p1) {

                    System.out.println("It is already your Factory. You cannot do anything");
                    System.out.println(p1.getPlayersName() + "'s budget is still: " + p1.getBudget());
                }
                else {

                    if (factoryAtThisPosition.owner.factoryIndex == 1) {

                        p1.payingFactoryRent(zahl*4, factoryAtThisPosition);
                        System.out.println(factoryAtThisPosition.getOwnersName() + " has " + factoryAtThisPosition.owner.factoryIndex + " factories!");
                        System.out.println("Therefore, " + p1.getPlayersName() + " has to pay " + zahl + " * 4 = " + zahl*4 + " as rent to " + factoryAtThisPosition.getOwnersName());
                        System.out.println(factoryAtThisPosition.owner.getNewBudget());
                        System.out.println(p1.getNewBudget());

                    }

                    else if (factoryAtThisPosition.owner.factoryIndex == 2) {

                        p1.payingFactoryRent(zahl*10, factoryAtThisPosition);
                        System.out.println(factoryAtThisPosition.getOwnersName() + " has " + factoryAtThisPosition.owner.factoryIndex + " factories!");
                        System.out.println("Therefore, " + p1.getPlayersName() + " has to pay " + zahl + " * 10 = " + zahl*10 + " as rent to " + factoryAtThisPosition.getOwnersName());
                        System.out.println(factoryAtThisPosition.owner.getNewBudget());
                        System.out.println(p1.getNewBudget());

                    }
                }

            }

            else {

                System.out.println("This factory is free! It costs: " + factoryAtThisPosition.getPrize() + "    Your budget is: " + p1.getBudget());
                System.out.println("Do you want to buy this Factory for " + factoryAtThisPosition.getPrize() + "? Type yes or no!");
                Scanner in3 = new Scanner(System.in);
                String exerciseQuestion = in3.nextLine();
                if (exerciseQuestion.equalsIgnoreCase("yes")) {
                    p1.buyingFactory(factoryAtThisPosition);

                    System.out.println(p1.getPlayersName() + " buys " + factoryAtThisPosition.getName() + " for "
                            + factoryAtThisPosition.getPrize());
                    System.out.println(p1.getNewBudget());
                } else {
                    System.out.println(p1.getPlayersName() + " does not buy this Factory.");
                }

            }
        }





        else if (fieldAtPosition instanceof TrainStation) {

            TrainStation stationAtThisPosition = (TrainStation) fieldAtPosition; //umwandeln in TrainStation Klasse

            if (stationAtThisPosition.bought == true) {

                if (stationAtThisPosition.owner == p1) {

                    System.out.println("It is already your Train Station. You cannot do anything");
                    System.out.println(p1.getPlayersName() + "'s budget is still: " + p1.getBudget());
                }

                else {

                    p1.payTrainRent(stationAtThisPosition);
                    System.out.println(p1.getPlayersName() + " pays " + stationAtThisPosition.getRent() + " as rent to "
                            + stationAtThisPosition.getOwnersName());
                    System.out.println(stationAtThisPosition.owner.getNewBudget());
                    System.out.println(p1.getNewBudget());

                }


            }
            else {

                System.out.println("This train station is free! It costs: " + stationAtThisPosition.getPrize() + "    Your budget is: " + p1.getBudget());
                System.out.println("Do you want to buy this Train Station for " + stationAtThisPosition.getPrize() + "? Type yes or no!");
                Scanner in1 = new Scanner(System.in);
                String exerciseQuestion = in1.nextLine();
                if (exerciseQuestion.equalsIgnoreCase("yes")) {
                    p1.buyingTrainStation(stationAtThisPosition);

                    System.out.println(p1.getPlayersName() + " buys " + stationAtThisPosition.getName() + " for "
                            + stationAtThisPosition.getPrize());
                    System.out.println(p1.getNewBudget());
                } else {
                    System.out.println(p1.getPlayersName() + " does not buy this Train Station.");
                }
            }


        }

        else if (fieldAtPosition instanceof Streets) {

            Streets streetAtThisPosition = (Streets) fieldAtPosition; //umwandeln in Streets Klasse

            if (streetAtThisPosition.bought == true)
                System.out.println(p1.getPlayersName() + " goes to " + streetAtThisPosition.getName()
                        + ", which is owned by: " + streetAtThisPosition.getOwnersName());
            else
                System.out.println(
                        p1.getPlayersName() + " goes to " + streetAtThisPosition.getName() + ", which is free!");

            if (streetAtThisPosition.getNumberOfHouses() > 0)
                System.out.println(streetAtThisPosition.getName() + " has " + streetAtThisPosition.getNumberOfHouses()
                        + " house(s) build on!");
            else
                ;

            if (streetAtThisPosition.bought == true) {
                if (streetAtThisPosition.owner == p1) {
                    System.out.println("It is  your Street and you have a budget of: " + p1.getBudget());
                    System.out.println("Do you want to build one or more houses for: " + streetAtThisPosition.getCostForOneHouse()
                            + "? Type yes or no!");

                    Scanner in = new Scanner(System.in);
                    String exerciseQuestion = in.nextLine();
                    if (exerciseQuestion.equalsIgnoreCase("yes")) {
                        System.out.println("How many houses do you want to build? Type in a number! (You can have at maximum 5 houses on one street)");
                        Scanner sc =new Scanner(System.in);
                        int x = sc.nextInt();
                        while ( x > 5 - streetAtThisPosition.getNumberOfHouses() || x < 0) {
                            System.out.println("You are not allowed to build " + x + " houses!");
                            System.out.println("You can at most build " + (5-streetAtThisPosition.getNumberOfHouses()) + " houses!");
                            System.out.println("How many houses do you want to build? Type in a number!");
                            x = sc.nextInt();
                        }
                        if (x <= 5 - streetAtThisPosition.getNumberOfHouses()) {
                            p1.buyingHouses(x, streetAtThisPosition);
                            System.out.println(
                                    p1.getPlayersName() + " builds " + x + " house(s) on " + streetAtThisPosition.getName());
                            System.out.println("The street now has " + streetAtThisPosition.getNumberOfHouses()
                                    + " house(s) and the new rent is: " + streetAtThisPosition.getRent());
                            System.out.println(p1.getPlayersName() + "'s new budget is: " + p1.getBudget());

                        }


                    } else
                        System.out.println(p1.getPlayersName() + " does not buy a house on this street.");
                }

                else {

                    p1.payRent(streetAtThisPosition);
                    System.out.println(p1.getPlayersName() + " pays " + streetAtThisPosition.getRent() + " as rent to "
                            + streetAtThisPosition.getOwnersName());
                    System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
                    System.out.println(
                            streetAtThisPosition.getOwnersName() + "'s new budget is: " + streetAtThisPosition.owner.budget);
                }
            } else {
                System.out.println(
                        "Do you want to buy this street for " + streetAtThisPosition.getPrize() + "? Type yes or no!");
                Scanner in2 = new Scanner(System.in);
                String exerciseQuestion = in2.nextLine();
                if (exerciseQuestion.equalsIgnoreCase("yes")) {
                    p1.buysStreet(streetAtThisPosition);
                    System.out.println(p1.getPlayersName() + " buys " + streetAtThisPosition.getName() + " for "
                            + streetAtThisPosition.getPrize());
                    System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
                } else {
                    System.out.println(p1.getPlayersName() + " does not buy this street.");
                }

            }
        }

















//		if (p1.position == 0) {
//			System.out.println(p1.getPlayersName() + " is on starting position! He gets an extra 100!!"
//					+ " his new budget is: " + p1.getBudget());
//
//		}
//
//
//
//
//
//
//
//
//
//
//
//		else {
//			Streets streetAtPosition = (Streets) gameboard.turns[p1.getPosition()];
//
//			if (streetAtPosition.bought == true)
//				System.out.println(p1.getPlayersName() + " goes to " + streetAtPosition.getName()
//						+ ", which is owned by: " + streetAtPosition.getOwnersName());
//			else
//				System.out.println(
//						p1.getPlayersName() + " goes to " + streetAtPosition.getName() + ", which is free!");
//
//			if (streetAtPosition.getNumberOfHouses() > 0)
//				System.out.println(streetAtPosition.getName() + " has " + streetAtPosition.getNumberOfHouses()
//						+ " house(s) build on!");
//			else
//				;
//
//			if (streetAtPosition.bought == true) {
//				if (streetAtPosition.owner == p1) {
//					System.out.println("It is  your Street and you have a budget of: " + p1.getBudget());
//					System.out.println("Do you want to build one or more houses for: " + streetAtPosition.getCostForOneHouse()
//							+ "? Type yes or no!");
//
//					Scanner in = new Scanner(System.in);
//					String exerciseQuestion = in.nextLine();
//					if (exerciseQuestion.equalsIgnoreCase("yes")) {
//						System.out.println("How many houses do you want to build? Type in a number! (You can hav at maximum 5 houses on one street)");
//						Scanner sc =new Scanner(System.in);
//					    int x = sc.nextInt();
//					    try {
//						p1.buyingHouses(x, streetAtPosition);
//						System.out.println(
//								p1.getPlayersName() + " builds " + x + " house(s) on " + streetAtPosition.getName());
//						System.out.println("The street now has " + streetAtPosition.getNumberOfHouses()
//								+ " house(s) and the new rent is: " + streetAtPosition.getRent());
//						System.out.println(p1.getPlayersName() + "'s new budget is: " + p1.getBudget());
//					    }
//					    catch (Exception e) {
//					    	System.out.println("You are not allowed to build " + x + " houses!");
//					    	System.out.println("You can at most build " + (5-streetAtPosition.getNumberOfHouses()) + " houses!");
//					    	System.out.println("How many houses do you want to build? Type in a number! (You can hav at maximum 5 houses on one street)");
//							Scanner sc2 =new Scanner(System.in);
//						    int x2 = sc2.nextInt();
//						    p1.buyingHouses(x2, streetAtPosition);
//							System.out.println(
//									p1.getPlayersName() + " builds " + x2 + " house(s) on " + streetAtPosition.getName());
//							System.out.println("The street now has " + streetAtPosition.getNumberOfHouses()
//									+ " house(s) and the new rent is: " + streetAtPosition.getRent());
//							System.out.println(p1.getPlayersName() + "'s new budget is: " + p1.getBudget());
//						    }
//
//
//					} else
//						System.out.println(p1.getPlayersName() + " does not buy a house on this street.");
//				}
//
//				else {
//
//					p1.payRent(streetAtPosition);
//					System.out.println(p1.getPlayersName() + " pays " + streetAtPosition.getRent() + " as rent to "
//							+ streetAtPosition.getOwnersName());
//					System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
//					System.out.println(
//							streetAtPosition.getOwnersName() + "'s new budget is: " + streetAtPosition.owner.budget);
//				}
//			} else {
//				System.out.println(
//						"Do you want to buy this street for " + streetAtPosition.getPrize() + "? Type yes or no!");
//				Scanner in2 = new Scanner(System.in);
//				String exerciseQuestion = in2.nextLine();
//				if (exerciseQuestion.equalsIgnoreCase("yes")) {
//					p1.buysStreet(streetAtPosition);
//					System.out.println(p1.getPlayersName() + " buys " + streetAtPosition.getName() + " for "
//							+ streetAtPosition.getPrize());
//					System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
//				} else {
//					System.out.println(p1.getPlayersName() + "does not buy this street.");
//				}
//
//			}
//		}

//			else
//			System.out.println(p1.getPlayersName() + " rolls a " + zahl + " and is on " + streetAtPosition.getStreetName() + ", which is not owned by anybody");
//		if (streetAtPosition.bought == false && p1.getBudget() > streetAtPosition.getPrize() + 50) {
//			p1.buysStreet(streetAtPosition);
//			System.out.println(p1.getPlayersName() + " buys " + streetAtPosition.getStreetName() + " for "
//					+ streetAtPosition.getPrize());
//			System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
//		}
//		else if (streetAtPosition.bought == false && p1.getBudget() < streetAtPosition.getPrize() + 50) {
//			System.out.println(p1.getPlayersName() + " does not have enough money to buy " + streetAtPosition.getStreetName());
//		}
//		else {
//			if (streetAtPosition.owner == p1) {
//				if (p1.budget > streetAtPosition.getCostForOneHouse() + 50) {
//					p1.buyingHouses(1, streetAtPosition);
//					System.out.println(p1.getPlayersName() + " builds 1 house on " + streetAtPosition.getStreetName());
//					System.out.println("the new rent for this street is now: " + streetAtPosition.getRent());
//				}
//				else
//					System.out.println(p1.getPlayersName() + " does not have enough budget to biuld a house!");
//
//			}
//			else {
//			p1.payRent(streetAtPosition);
//			System.out.println(p1.getPlayersName() + " pays " + streetAtPosition.getRent() + " as rent to "
//					+ streetAtPosition.getOwnersName());
//			System.out.println(p1.getPlayersName() + "'s budget is now " + p1.getBudget());
//			}
//		}
//
    }

    public void launchGame() {
        System.out.println("Press enter to start the game!");
        pressEnter();
        while (playerA.getBudget() > 0 && playerB.getBudget() > 0 && playerC.getBudget() > 0) {
//			if (counter > numberOfPlayer) {
//				counter = counter - numberOfPlayer -1;
//			}


            if (counter == 1) {
                gameTurn(playerA);
                counter++;
                System.out.println("Press enter for next turn!");
                pressEnter();

            }
            else if (counter == 2) {
                gameTurn(playerB);
                counter++;
                System.out.println("Press enter for next turn!");
                pressEnter();




            } else if (counter == 3) {
                gameTurn(playerC);
                counter ++;
                System.out.println("Press enter for next turn!");
                pressEnter();
            }

            else if (counter == 4) {
                gameTurn(playerD);
                counter = 1;
                System.out.println("Press enter for next turn!");
                pressEnter();
            }



        }


        if (playerA.getBudget() < 0 || playerB.getBudget() < 0 || playerC.getBudget() < 0 || playerD.getBudget() < 0) {
            System.out.println("The game is over!");

            //here you have to create an array of all players, and sort them with their wealth
            //Then print a nice output

            Players [] allThePlayers  = new Players [4];
            allThePlayers[0] = playerA;
            allThePlayers[1] = playerB;
            allThePlayers[2] = playerC;
            allThePlayers[3] = playerD;

            bubbleSort (allThePlayers);
            printArray (allThePlayers);

            System.out.println("The winner is:      " + allThePlayers[3].getPlayersName() + "!!  His overall wealth is: " + allThePlayers[0].overallWealth);
            System.out.println("On second place is: " + allThePlayers[2].getPlayersName() + "!!  His overall wealth is: " + allThePlayers[1].overallWealth);
            System.out.println("On third place is:  " + allThePlayers[1].getPlayersName() + "!!  His overall wealth is: " + allThePlayers[2].overallWealth);
            System.out.println("The looooooser is:  " + allThePlayers[0].getPlayersName() + "!!  His overall wealth is: " + allThePlayers[3].overallWealth);




//			if (playerA.getBudget() < 0) {
//				if (playerB.overallWealth > playerC.overallWealth) {
//					System.out.println(playerB.getPlayersName() + " has won the game!		His overall welath is: " + playerB.overallWealth);
//					System.out.println(playerC.getPlayersName() + " is on second place!		His overall welath is: " + playerC.overallWealth);
//					System.out.println(playerA.getPlayersName() + " is on third place!		His overall welath is: " + playerA.overallWealth);
//				}
//				else {
//					System.out.println(playerC.getPlayersName() + " has won the game!		His overall welath is: " + playerC.overallWealth);
//					System.out.println(playerB.getPlayersName() + " is on second place!		His overall welath is: " + playerB.overallWealth);
//					System.out.println(playerA.getPlayersName() + " is on third place		His overall welath is: " + playerA.overallWealth);
//
//				}
//
//			}
//			else if (playerB.getBudget() < 0) {
//				if (playerA.overallWealth > playerC.overallWealth) {
//					System.out.println(playerA.getPlayersName() + " has won the game!		His overall welath is: " + playerA.overallWealth);
//					System.out.println(playerC.getPlayersName() + " is on second place!		His overall welath is: " + playerC.overallWealth);
//					System.out.println(playerB.getPlayersName() + " is on third place		His overall welath is: " + playerB.overallWealth);
//				}
//				else {
//					System.out.println(playerC.getPlayersName() + " has won the game!		His overall welath is: " + playerC.overallWealth);
//					System.out.println(playerA.getPlayersName() + " is on second place!		His overall welath is: " + playerA.overallWealth);
//					System.out.println(playerB.getPlayersName() + " is on third place		His overall welath is: " + playerB.overallWealth);
//
//				}
//
//			}
//
//			else if (playerC.getBudget() < 0) {
//				if (playerA.overallWealth > playerB.overallWealth) {
//					System.out.println(playerA.getPlayersName() + " has won the game!		His overall welath is: " + playerA.overallWealth);
//					System.out.println(playerB.getPlayersName() + " is on second place!		His overall welath is: " + playerB.overallWealth);
//					System.out.println(playerC.getPlayersName() + " is on third place		His overall welath is: " + playerC.overallWealth);
//				}
//				else {
//					System.out.println(playerB.getPlayersName() + " has won the game!		His overall welath is: " + playerB.overallWealth);
//					System.out.println(playerA.getPlayersName() + " is on second place!		His overall welath is: " + playerA.overallWealth);
//					System.out.println(playerC.getPlayersName() + " is on third place		His overall welath is: " + playerC.overallWealth);
//
//				}
//
//			}
//

        }
//			System.out.println("The game is over!");
//
//			System.out.println(playerB.getPlayersName() + " has won the game!!");
//
//		else if (playerB.getBudget() < 0)
//			System.out.println(playerA.getPlayersName() + " has won the game!!");
//		else if (playerC.getBudget() < 0)
//			System.out.println(playerA.getPlayersName() + " has won the game!!");

    }

    private void pressEnter() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printArray(Players[] theArray) {
        for (int i = 0; i < theArray.length; i++)
            System.out.print(" " + theArray[i]);
        System.out.println();
    }

    public static void bubbleSort(ICanBeCompared[] data) {
        ICanBeCompared backup;
        for(int i=data.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(data[j].isGreaterThan(data[j+1])) {
                    backup = data[j];
                    data[j] = data[j+1];
                    data[j+1] = backup;
                }
            }
        }
    }

}