package slots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pacanele {
    static Scanner read = new Scanner(System.in);
    static double budget = 100.0;
    static Random generator = new Random();
    static ArrayList<String> posibilities = new ArrayList<>(Arrays.asList("DIAMOND", "CHERRY", "BAR"));

    public static void main(String[] args) {

        System.out.println("Would you like to start the game?");
        String ans = read.nextLine();
        if (ans.equals("yes")) {
            startGame(read, budget);
        } else if (ans.equals("no")) {
            System.out.println("See you next time");
        } else {
            System.out.println("Sorry, the answer is not valid");
        }
    }

    private static void startGame(Scanner read, double budget) {
        while (true) {
            System.out.println(" Enter the stake: (your budget " + budget + ") ");
            double stake = read.nextDouble();
            if (stake > budget) {
                System.out.println("You don't have that kind of money");
            } else {
                budget-=stake;
                System.out.println(" Pulling the lever! ");
                String result1 = generateRes();
                String result2 = generateRes();
                String result3 = generateRes();
                printTheResults(result1, result2, result3);
                if (result1.equals(result2) && result2.equals(result3)) {
                    System.out.println("JACKPOT");
                    double plus = (30.0/100)*stake;
                    budget += (stake+plus);
                } else if (result1.equals(result2) || result2.equals(result3) || result1.equals(result3)) {
                    System.out.println("SEMI-JACKPOT");
                    double plus = (90.0/100)*stake;
                    budget +=plus;
                } else {
                    System.out.println("You lost");
                }
                if(budget>1000){
                    System.out.println("You won!");
                    break;
                }
                if(budget<1){
                    System.out.println("You lost");
                    break;
                }
            }
        }
    }

    private static String generateRes() {
        return posibilities.get(generator.nextInt(posibilities.size()));
    }

    private static void printTheResults(String result1, String result2, String result3) {
        System.out.printf("[%s] [%s] [%s]\n", result1, result2, result3);
    }
}