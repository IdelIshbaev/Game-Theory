////4
//package gametheory.assignment2.students2021;
//
//import gametheory.assignment2.Player;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CheckLoses implements Player{
//    int myLastMove;
//    List<Integer> payoffs = new ArrayList<Integer>();
//    int lastBest = 0;
//
//
//    @Override
//    public void reset() {
//        this.payoffs.clear();
//        this.lastBest = 0;
//        this.myLastMove = 0;
//    }
//
//    @Override
//    public int move(int opponentLastMove, int xA, int xB, int xC) {
//        int nextMove = 0;
//
//        int sizePayoffs = payoffs.size()-1;
//        int flag = 0;
//        if((sizePayoffs >= 2) && (payoffs.get(sizePayoffs-2) == 0 ) && payoffs.get(sizePayoffs-1) == 0 ){ // size > 2, round -2 == 2
//
//            if((xA == 0 && xB == 0) || (xB == 0 && xC == 0) || (xA == 0 && xC == 0) ){
//                flag = 0;
//                // there are 2 zeros
//            }else{
//                flag = 1;
//                if (xA > xB && xA > xC){ // flag = 0 // choose best
//                    if(xB > xC) nextMove = 2;
//                    else nextMove = 3;
//                }else if( xB > xA && xB > xC){
//                    if(xA > xC) nextMove = 1;
//                    else nextMove = 3;
//                }else if(xC > xA && xC > xB){
//                    if(xA > xB) nextMove = 1;
//                    else nextMove = 2;
//                }else if(xA == xB || xB == xC || xA == xC) {
//                    if(xA == xB && xB == xC){
//                        nextMove = randomABC();
//                    }else if(xA == xB){
//                        nextMove = randomAB();
//                    }else if(xB == xC){
//                        nextMove = randomBC();
//                    }else if(xA == xC){
//                        nextMove = randomAC();
//                    }
//                }
//            }
//        }
//        if (flag == 1) {
//            ;
//        }else if (xA > xB && xA > xC){ // flag = 0 // choose best
//            nextMove = 1;
//        }else if( xB > xA && xB > xC){
//            nextMove = 2;
//        }else if(xC > xA && xC > xB){
//            nextMove = 3;
//        }else if(xA == xB || xB == xC || xA == xC) {
//            if(xA == xB && xB == xC){
//                nextMove = randomABC();
//            }else if(xA == xB){
//                nextMove = randomAB();
//            }else if(xB == xC){
//                nextMove = randomBC();
//            }else if(xA == xC){
//                nextMove = randomAC();
//            }
//        }
//        if(opponentLastMove != 0){
//            if (myLastMove == opponentLastMove){
//                payoffs.add(0);
//            }else{
//                payoffs.add(1);
//            }
//        }
//        this.myLastMove = nextMove;
//        return nextMove;
//    }
//    private int randomAB(){
//        int temp = 0;
//        double rand = Math.random()*2;
//        int intRand = (int) rand + 1;
//        temp = intRand;
//        return temp;
//    }
//    private int randomBC(){
//        int temp = 0;
//        double rand = Math.random()*2;
//        int intRand = (int) rand + 2;
//        temp = intRand;
//        return temp;
//    }
//    private int randomAC(){
//        int temp = 0;
//        double rand = Math.random()*2;
//        int intRand = (int) rand + 1;
//        if(intRand == 2) temp = 3;
//        else temp = 1;
//        return temp;
//    }
//    private int randomABC(){
//        int temp = 0;
//        double rand = Math.random()*3;
//        int intRand = (int) rand+1;
//        temp = intRand;
//        return temp;
//    }
//
//    @Override
//    public String getEmail() {
//        return "i.ishbaev@innopolis.university";
//    }
//}
//
//
//
