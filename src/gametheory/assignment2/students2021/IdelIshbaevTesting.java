package gametheory.assignment2.students2021;

import gametheory.assignment2.Player;

import java.util.ArrayList;
import java.util.List;

public class IdelIshbaevTesting {

    public static void main(String[] args) {
//        Player firstMoose = new NewIdelIshbaev();
//        Player secondMoose = new NewIdelIshbaev();
        List<Player> firstListPlayers = new ArrayList<Player>();
        List<Player> secondListPlayers = new ArrayList<Player>();

        Player temp1 = new ImprovedBest();
        Player temp11 = new ImprovedBest();

        Player temp2 = new RandomAgent();
        Player temp22 = new RandomAgent();

        Player temp3 = new AlwaysBestAgent();
        Player temp33 = new AlwaysBestAgent();

        Player temp4 = new CheckLoses();
        Player temp44 = new CheckLoses();

        Player temp5 = new CheckLosesBigNoRandom();
        Player temp55 = new CheckLosesBigNoRandom();

//        Player temp6 = new AlwaysLess();

        Player temp7 = new IdelIshbaevCode();
        Player temp77 = new IdelIshbaevCode();


//
//        Player temp2 = new ImprovedBest();
//        Player temp22 = new ImprovedBest();
//
//        Player temp3 = new ImprovedBest();
//        Player temp33 = new ImprovedBest();
//
//        Player temp4 = new ImprovedBest();
//        Player temp44 = new ImprovedBest();
//
//        Player temp5 = new ImprovedBest();
//        Player temp55 = new ImprovedBest();
//
//        Player temp6 = new ImprovedBest();
//
//        Player temp7 = new CoopNewIdelIshbaev();
//        Player temp77 = new ImprovedBest();

        firstListPlayers.add(temp1);
        secondListPlayers.add(temp11);
        firstListPlayers.add(temp2);
        secondListPlayers.add(temp22);
        firstListPlayers.add(temp3);
        secondListPlayers.add(temp33);
        firstListPlayers.add(temp4);
        secondListPlayers.add(temp44);
        firstListPlayers.add(temp5);
        secondListPlayers.add(temp55);
        firstListPlayers.add(temp7);
        secondListPlayers.add(temp77);


        int agAmount = 6;
        String[][] eval = new String[agAmount+1][agAmount+1];
        int[][] intEval = new int[agAmount][agAmount];

        eval[0][0] = "Gaame th";

        eval[0][1] = "ImproBest";
        eval[0][2] = "RandomAge";
        eval[0][3] = "AlwaysBes";
        eval[0][4] = "CheckLose";
        eval[0][5] = "CheckRand";
        eval[0][6] = "Cooperate";

        eval[1][0] = "IprovBest";
        eval[2][0] = "RandomAge";
        eval[3][0] = "AlwaysBes";
        eval[4][0] = "CheckLose";
        eval[5][0] = "CheckRand";
        eval[6][0] = "Cooperate";




        for(int w = 0; w < agAmount; w++) {
            Player firstMoose = firstListPlayers.get(w);
            for (int q = 0; q < agAmount; q++) {
//                System.out.print(w);
//                System.out.println(" "+ q);
                Player secondMoose = secondListPlayers.get(q);
                int myWin = 0;
                int opWin = 0;
                int eqDraw = 0;

                double totalFirst = 0.0;
                double totalSecond = 0.0;

                for(int k = 0; k < 1000; k++) {
//            int xA = 1;//(int)Math.random()*5 + 1;
//            int xB = 1;//(int)Math.random()*5 + 1;
//            int xC = 1;//(int)Math.random()*5 + 1;

                    int[] fields = new int[3];
                    fields[0] = 1;
                    fields[1] = 1;
                    fields[2] = 1;

                    double gainFirst = 0.0;
                    double gainSecond = 0.0; //(10*Math.exp(x))/(1+Math.exp(x)) - 5;

                    int first = 0;
                    int second = 0;
                    int firstPrev = 0;

                    for (int i = 1; i < 101; i++) {

                        // get moves
                        if (i == 1) {
                            first = firstMoose.move(0, fields[0], fields[1], fields[2]) - 1;
                            second = secondMoose.move(0, fields[0], fields[1], fields[2]) - 1;
                            // 0 1 2
                            firstPrev = first;

                        } else {
                            first = firstMoose.move(second + 1, fields[0], fields[1], fields[2]) - 1;
                            second = secondMoose.move(firstPrev + 1, fields[0], fields[1], fields[2]) - 1;
                            firstPrev = first;
                            // 0 1 2
                        }

                        //evaluate
                        if (first == second) {

                            for (int j = 0; j < 3; j++) fields[j] += 1;

                            fields[first] = Math.max(fields[first] - 2, 0);

                        } else {
                            int x = fields[first];
                            gainFirst += (10 * Math.exp(x)) / (1 + Math.exp(x)) - 5;

                            int y = fields[second];
                            gainSecond += (10 * Math.exp(y)) / (1 + Math.exp(y)) - 5;

                            for (int j = 0; j < 3; j++) fields[j] += 1;

                            fields[first] = Math.max(fields[first] - 2, 0);

                            fields[second] = Math.max(fields[second] - 2, 0);
                        }
//                        System.out.println("FIELDS: " + fields[0] + " " + fields[1] + " " + fields[2]);
//                        System.out.println("steps: " + (first+1) + " | " + (second+1));
//                        System.out.print("GAINS: " + Math.round(gainFirst) + " ");
//                        System.out.println(Math.round(gainSecond));
//                        System.out.println();

                    }
                    if(gainFirst > gainSecond){
                        myWin += 1;
                    }else if (gainSecond > gainFirst){
                        opWin += 1;
                    }else{
                        eqDraw += 1;
                    }


                    totalFirst += gainFirst;
                    totalSecond += gainSecond;
                    firstMoose.reset();
                    secondMoose.reset();
                }
                int total = eqDraw + myWin + opWin;
                intEval[w][q]  = (int)totalFirst/total;

                String tempf = String.valueOf(Math.round(totalFirst/total));
                String temps = String.valueOf(Math.round(totalSecond/total));
                if(Math.round(totalFirst/total) < 100) {tempf = " " + tempf;}
                if(Math.round(totalFirst/total) < 10) {tempf = " " + tempf;}

                if(Math.round(totalSecond/total) < 100) {temps = " " + temps;}
                if(Math.round(totalSecond/total) < 10) {temps = " " + temps;}

                eval[w+1][q+1] = (tempf+" | " + temps);

//                System.out.println(eval[w+1][q+1]);
//                System.out.println(intEval[w][q]);
//                System.out.println();

//                System.out.println("TOTAL: " + total);
//                System.out.print(w);
//                System.out.println(q);
//
//                System.out.println("MY AVERAGE: " + Math.round(totalFirst / total));
//                System.out.println("OP AVERAGE: " + Math.round(totalSecond / total));
//                System.out.println();
//                System.out.println("NUMBER OF MY WINS: " + myWin);
//                System.out.println("NUMBER OF OPPONENT'S WINS: " + opWin);
//                System.out.println("NUMBER OF DRAWS: " + eqDraw);
//                System.out.println();


            }
        }
        double avr = 0;
        for(int w = 0; w < agAmount+1; w++){
            for( int q = 0; q < agAmount+1; q++){
                System.out.print(eval[w][q] + "     ");
                if(q != 0 && w != 0) {
                    avr += intEval[w-1][q-1];
                }
            }
            System.out.print("AVERAGE: " + Math.round(avr/agAmount));
            avr = 0;
            System.out.println();
        }

    }
}


class AlwaysBestAgent implements Player{
    int myLastMove;
    List<Integer> payoffs = new ArrayList<Integer>();

    @Override
    public void reset() {
        this.payoffs.clear();
        this.myLastMove = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int nextMove = 0;
        if (xA > xB && xA > xC){
            nextMove = 1;
        }else if( xB > xA && xB > xC){
            nextMove = 2;
        }else if(xC > xA && xC > xB){
            nextMove = 3;
        }else{
            if(xA == xB && xB > xC){
                double rand = Math.random()*2;
                int intRand = (int) rand + 1;
                nextMove = intRand;
            }else if(xB == xC && xC > xA){
                double rand = Math.random()*2;
                int intRand = (int) rand + 2;
                nextMove = intRand;
            }else if(xA == xC && xC > xB){
                double rand = Math.random()*2;
                int intRand = (int) rand + 1;
                if(intRand == 2) nextMove = 3;
                else nextMove = 1;
            }else if(xA == xB && xB == xC && xA == xC){
                double rand = Math.random()*3;
                int intRand = (int) rand+1;
                nextMove = intRand;
            }
        }

        this.myLastMove = nextMove;
        return nextMove;
    }

    @Override
    public String getEmail() {
        return "i.ishbaev@innopolis.university";
    }
}


class CheckLoses implements Player{
    int myLastMove;
    List<Integer> payoffs = new ArrayList<Integer>();
    int lastBest = 0;


    @Override
    public void reset() {
        this.payoffs.clear();
        this.lastBest = 0;
        this.myLastMove = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int nextMove = 0;

        int sizePayoffs = payoffs.size()-1;
        int flag = 0;
        if((sizePayoffs >= 2) && (payoffs.get(sizePayoffs-2) == 0 ) && payoffs.get(sizePayoffs-1) == 0 ){ // size > 2, round -2 == 2

            if((xA == 0 && xB == 0) || (xB == 0 && xC == 0) || (xA == 0 && xC == 0) ){
                flag = 0;
                // there are 2 zeros
            }else{
                flag = 1;
                if (xA > xB && xA > xC){ // flag = 0 // choose best
                    if(xB > xC) nextMove = 2;
                    else nextMove = 3;
                }else if( xB > xA && xB > xC){
                    if(xA > xC) nextMove = 1;
                    else nextMove = 3;
                }else if(xC > xA && xC > xB){
                    if(xA > xB) nextMove = 1;
                    else nextMove = 2;
                }else if(xA == xB || xB == xC || xA == xC) {
                    if(xA == xB && xB == xC){
                        nextMove = randomABC();
                    }else if(xA == xB){
                        nextMove = randomAB();
                    }else if(xB == xC){
                        nextMove = randomBC();
                    }else if(xA == xC){
                        nextMove = randomAC();
                    }
                }
            }
        }
        if (flag == 1) {
            ;
        }else if (xA > xB && xA > xC){ // flag = 0 // choose best
            nextMove = 1;
        }else if( xB > xA && xB > xC){
            nextMove = 2;
        }else if(xC > xA && xC > xB){
            nextMove = 3;
        }else if(xA == xB || xB == xC || xA == xC) {
            if(xA == xB && xB == xC){
                nextMove = randomABC();
            }else if(xA == xB){
                nextMove = randomAB();
            }else if(xB == xC){
                nextMove = randomBC();
            }else if(xA == xC){
                nextMove = randomAC();
            }
        }
        if(opponentLastMove != 0){
            if (myLastMove == opponentLastMove){
                payoffs.add(0);
            }else{
                payoffs.add(1);
            }
        }
        this.myLastMove = nextMove;
        return nextMove;
    }
    private int randomAB(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        temp = intRand;
        return temp;
    }
    private int randomBC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 2;
        temp = intRand;
        return temp;
    }
    private int randomAC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        if(intRand == 2) temp = 3;
        else temp = 1;
        return temp;
    }
    private int randomABC(){
        int temp = 0;
        double rand = Math.random()*3;
        int intRand = (int) rand+1;
        temp = intRand;
        return temp;
    }

    @Override
    public String getEmail() {
        return "i.ishbaev@innopolis.university";
    }
}


class CheckLosesBigNoRandom implements Player{
    int myLastMove;
    List<Integer> payoffs = new ArrayList<Integer>();
    int lastBest = 0;


    @Override
    public void reset() {
        this.payoffs.clear();
        this.lastBest = 0;
        this.myLastMove = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int nextMove = 0;

        int sizePayoffs = payoffs.size()-1;
        int flag = 0;
        //if 2 bigger than 5 and choose second

        if((xA >= 5 && xB >= 5 && xB > xC) || (xA >= 5 && xC >= 5 && xC > xB) || (xB >= 5 && xC >= 5 && xC > xB)){
            flag = 1;
            if(xA >= 5 && xB >= 5){
                if(xA == xB) {
                    nextMove = randomAB();
                } else if(xA > xB){
                    nextMove = 2;
                }else{
                    nextMove = 1;
                }
            }else if(xB >= 5 && xC >= 5){
                if(xB == xC) {
                    nextMove = randomBC();
                }else if(xB > xC){
                    nextMove = 3;
                }else{
                    nextMove = 2;
                }
            }else if (xA >= 5 && xC >= 5){
                if(xA == xC) {
                    nextMove = randomAC();
                }else if(xA > xC){
                    nextMove = 3;
                }else{
                    nextMove = 1;
                }
            } //no payoff 2 times, choose not best
        }else if( (sizePayoffs >= 2) && (payoffs.get(sizePayoffs-2) == 0 ) && payoffs.get(sizePayoffs-1) == 0 ){ // size > 2, round -2 == 2

            if((xA == 0 && xB == 0) || (xB == 0 && xC == 0) || (xA == 0 && xC == 0) ){
                flag = 0;
                // there are 2 zeros
            }else{
                flag = 1;
                if (xA > xB && xA > xC){ // flag = 0 // choose best
                    if(xB > xC) nextMove = 2;
                    else nextMove = 3;
                }else if( xB > xA && xB > xC){
                    if(xA > xC) nextMove = 1;
                    else nextMove = 3;
                }else if(xC > xA && xC > xB){
                    if(xA > xB) nextMove = 1;
                    else nextMove = 2;
                }else if(xA == xB || xB == xC || xA == xC) {
                    if(xA == xB && xB == xC){
                        nextMove = randomABC();
                    }else if(xA == xB){
                        nextMove = randomAB();
                    }else if(xB == xC){
                        nextMove = randomBC();
                    }else if(xA == xC){
                        nextMove = randomAC();
                    }
                }
            }
        }
        if (flag == 1) {
            ;
        }else if (xA > xB && xA > xC){ // flag = 0 // choose best
            nextMove = 1;
        }else if( xB > xA && xB > xC){
            nextMove = 2;
        }else if(xC > xA && xC > xB){
            nextMove = 3;
        }else if(xA == xB || xB == xC || xA == xC) {
            if(xA == xB && xB == xC){
                nextMove = randomABC();
            }else if(xA == xB){
                nextMove = randomAB();
            }else if(xB == xC){
                nextMove = randomBC();
            }else if(xA == xC){
                nextMove = randomAC();
            }
        }
        if(opponentLastMove != 0){
            if (myLastMove == opponentLastMove){
                payoffs.add(0);
            }else{
                payoffs.add(1);
            }
        }
        if(nextMove == 0){
            nextMove = 1;
        }
        this.myLastMove = nextMove;
        return nextMove;
    }
    private int randomAB(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        temp = intRand;
        return temp;
    }
    private int randomBC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 2;
        temp = intRand;
        return temp;
    }
    private int randomAC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        if(intRand == 2) temp = 3;
        else temp = 1;
        return temp;
    }
    private int randomABC(){
        int temp = 0;
        double rand = Math.random()*3;
        int intRand = (int) rand+1;
        temp = intRand;
        return temp;
    }

    @Override
    public String getEmail() {
        return "i.ishbaev@innopolis.university";
    }
}


class ImprovedBest implements Player{
    int myLastMove;
    List<Integer> payoffs = new ArrayList<Integer>();
    int lastBest = 0;


    @Override
    public void reset() {
        this.payoffs.clear();
        this.lastBest = 0;
        this.myLastMove = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int nextMove = 0;

        int sizePayoffs = payoffs.size()-1;
        int flag = 0;
        //if 2 bigger than 5 and choose second
        double randomness = Math.random()*10;
        double randomnessBIG = Math.random()*10;

        if(randomnessBIG < 5 && (xA >= 5 && xB >= 5 && xB > xC) || (xA >= 5 && xC >= 5 && xC > xB) || (xB >= 5 && xC >= 5 && xC > xB)){
            flag = 1;
            if(xA >= 5 && xB >= 5){
                if(xA == xB) {
                    nextMove = randomAB();
                } else if(xA > xB){
                    nextMove = 2;
                }else{
                    nextMove = 1;
                }

            }else if(xB >= 5 && xC >= 5){
                if(xB == xC) {
                    nextMove = randomBC();
                }else if(xB > xC){
                    nextMove = 3;
                }else{
                    nextMove = 2;
                }
            }else if (xA >= 5 && xC >= 5){
                if(xA == xC) {
                    nextMove = randomAC();
                }else if(xA > xC){
                    nextMove = 3;
                }else{
                    nextMove = 1;
                }
            } //no payoff 2 times, choose not best
        }else if(randomness < 3 && (sizePayoffs >= 2) && (payoffs.get(sizePayoffs-2) == 0 ) && payoffs.get(sizePayoffs-1) == 0 ){ // size > 2, round -2 == 2

            if((xA == 0 && xB == 0) || (xB == 0 && xC == 0) || (xA == 0 && xC == 0) ){
                flag = 0;
                // there are 2 zeros
            }else{
                flag = 1;
                if (xA > xB && xA > xC){ // flag = 0 // choose best
                    if(xB > xC) nextMove = 2;
                    else nextMove = 3;
                }else if( xB > xA && xB > xC){
                    if(xA > xC) nextMove = 1;
                    else nextMove = 3;
                }else if(xC > xA && xC > xB){
                    if(xA > xB) nextMove = 1;
                    else nextMove = 2;
                }else if(xA == xB || xB == xC || xA == xC) {
                    if(xA == xB && xB == xC){
                        nextMove = randomABC();
                    }else if(xA == xB){
                        nextMove = randomAB();
                    }else if(xB == xC){
                        nextMove = randomBC();
                    }else if(xA == xC){
                        nextMove = randomAC();
                    }
                }
            }
        }
        if (flag == 1) {
            ;
        }else if (xA > xB && xA > xC){ // flag = 0 // choose best
            nextMove = 1;
        }else if( xB > xA && xB > xC){
            nextMove = 2;
        }else if(xC > xA && xC > xB){
            nextMove = 3;
        }else if(xA == xB || xB == xC || xA == xC) {
            if(xA == xB && xB == xC){
                nextMove = randomABC();
            }else if(xA == xB){
                nextMove = randomAB();
            }else if(xB == xC){
                nextMove = randomBC();
            }else if(xA == xC){
                nextMove = randomAC();
            }
        }
        if(opponentLastMove != 0){
            if (myLastMove == opponentLastMove){
                payoffs.add(0);
            }else{
                payoffs.add(1);
            }
        }
        this.myLastMove = nextMove;
        return nextMove;
    }
    private int randomAB(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        temp = intRand;
        return temp;
    }
    private int randomBC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 2;
        temp = intRand;
        return temp;
    }
    private int randomAC(){
        int temp = 0;
        double rand = Math.random()*2;
        int intRand = (int) rand + 1;
        if(intRand == 2) temp = 3;
        else temp = 1;
        return temp;
    }
    private int randomABC(){
        int temp = 0;
        double rand = Math.random()*3;
        int intRand = (int) rand+1;
        temp = intRand;
        return temp;
    }

    @Override
    public String getEmail() {
        return "i.ishbaev@innopolis.university";
    }
}


class RandomAgent implements Player{
    int myLastMove;
    @Override
    public void reset() {
        this.myLastMove = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int nextMove = 0;

        double rand = Math.random()*3;
        int intRand = (int) rand + 1;
        nextMove = intRand;

        this.myLastMove = nextMove;
        return nextMove;
    }

    @Override
    public String getEmail() {
        return "i.ishbaev@innopolis.university";
    }
}




