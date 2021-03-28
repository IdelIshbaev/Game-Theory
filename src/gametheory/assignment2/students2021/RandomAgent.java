////1
//package gametheory.assignment2.students2021;
//
//import gametheory.assignment2.Player;
//
//public class RandomAgent implements Player{
//    int myLastMove;
//    @Override
//    public void reset() {
//        this.myLastMove = 0;
//    }
//
//    @Override
//    public int move(int opponentLastMove, int xA, int xB, int xC) {
//        int nextMove = 0;
//
//        double rand = Math.random()*3;
//        int intRand = (int) rand + 1;
//        nextMove = intRand;
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
