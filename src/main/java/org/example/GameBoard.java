package org.example;

public class GameBoard {

    public Fields [] turns = new Fields[40];

    public GameBoard(Streets s1, Streets s2, Streets s3, Streets s4, Streets s5, Streets s6, Streets s7, Streets s8,
                     Streets s9, Streets s10, Streets s11, Streets s12, Streets s13, Streets s14, Streets s15, Streets s16, Streets s17, Streets s18, Streets s19, Streets s20, Streets s21, Streets s22, TrainStation t1, TrainStation t2, TrainStation t3, TrainStation t4, Taxes taxes1, Taxes taxes2, SpecialFields sf1, SpecialFields sf2, SpecialFields sf3, SpecialFields sf4, SpecialFields sf5, SpecialFields sf6, Factories f1, Factories f2, Fields fields1, Fields fields2, Fields fields3, Fields fields4 ) {

        this.turns[0] = fields1;
        this.turns[1] = s1;
        this.turns[2] = sf1; //Gemeinschaftskarte
        this.turns[3] = s2;
        this.turns[4] = taxes1; //Steuern
        this.turns[5] = t1;
        this.turns[6] = s3;
        this.turns[7] = sf2; //Ereignisfeld
        this.turns[8] = s4;
        this.turns[9] = s5;
        this.turns[10] = fields2; //Nur zu Besuch
        this.turns[11] = s6;
        this.turns[12] = f1; //Elektrizitätswerk
        this.turns[13] = s7;
        this.turns[14] = s8;
        this.turns[15] = t2;
        this.turns[16] = s9;
        this.turns[17] = sf3; //Gemeinschaftskarte
        this.turns[18] = s10;
        this.turns[19] = s11;
        this.turns[20] = fields3; //Frei Parken
        this.turns[21] = s12;
        this.turns[22] = sf4; //Ereignisfeld
        this.turns[23] = s13;
        this.turns[24] = s14;
        this.turns[25] = t3;
        this.turns[26] = s15;
        this.turns[27] = s16;
        this.turns[28] = f2; //Wasserwerk
        this.turns[29] = s17;
        this.turns[30] = fields4; //Gefängnis
        this.turns[31] = s18;
        this.turns[32] = s19;
        this.turns[33] = sf5; //Gemeinschaftsfeld
        this.turns[34] = s20;
        this.turns[35] = t4;
        this.turns[36] = sf6; //Ereignisfeld
        this.turns[37] = s21;
        this.turns[38] = taxes2; //Steuern
        this.turns[39] = s22;

    }

//	public Streets[] getTurns() {
//		return turns;
//	}
//
//	public String getDescription() {
//		return ("Position 1: " + getTurns()[1].getDescription() + "Position 2: " + getTurns()[2].getDescription()
//				+ "Position 3: " + getTurns()[3].getDescription() + "Position 4: " + getTurns()[4].getDescription()
//				+ "Position 5: " + getTurns()[5].getDescription() + "Position 6: " + getTurns()[6].getDescription()
//				+ "Position 7: " + getTurns()[7].getDescription() + "Position 8: " + getTurns()[8].getDescription()
//				+ "Position 9: " + getTurns()[9].getDescription() + "Position 10: " + getTurns()[10].getDescription());
//
//	}
//
}