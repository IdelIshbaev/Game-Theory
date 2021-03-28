////2
//package gametheory.assignment2.students2021;
//
//
//import gametheory.assignment2.Player;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AlwaysBestAgent implements Player{
//    int myLastMove;
//    List<Integer> payoffs = new ArrayList<Integer>();
//
//    @Override
//    public void reset() {
//        this.payoffs.clear();
//        this.myLastMove = 0;
//    }
//
//    @Override
//    public int move(int opponentLastMove, int xA, int xB, int xC) {
//        int nextMove = 0;
//        if (xA > xB && xA > xC){
//            nextMove = 1;
//        }else if( xB > xA && xB > xC){
//            nextMove = 2;
//        }else if(xC > xA && xC > xB){
//            nextMove = 3;
//        }else{
//            if(xA == xB && xB > xC){
//                double rand = Math.random()*2;
//                int intRand = (int) rand + 1;
//                nextMove = intRand;
//            }else if(xB == xC && xC > xA){
//                double rand = Math.random()*2;
//                int intRand = (int) rand + 2;
//                nextMove = intRand;
//            }else if(xA == xC && xC > xB){
//                double rand = Math.random()*2;
//                int intRand = (int) rand + 1;
//                if(intRand == 2) nextMove = 3;
//                else nextMove = 1;
//            }else if(xA == xB && xB == xC && xA == xC){
//                double rand = Math.random()*3;
//                int intRand = (int) rand+1;
//                nextMove = intRand;
//            }
//        }
//
//        this.myLastMove = nextMove;
//        return nextMove;
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
