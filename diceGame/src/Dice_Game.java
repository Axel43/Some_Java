import java.util.Random;
import java.util.Scanner;

public class Dice_Game {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int dice1Player_1;
        int dice2Player_1;
        int dice1Player_2;
        int dice2Player_2;
        int Player_1Victories = 0;
        int Player_2Victories = 0;
        Random generator = new Random();
        while (true) {
            System.out.println("Would you like to play?");
            System.out.println("Player1 won " + Player_1Victories + " times\n"
            + "Player2 won " + Player_2Victories + " times");
            String ans = read.nextLine();
            ans = ans.toLowerCase();
            if (ans.equals("yes")) {
                dice1Player_1 = generator.nextInt(6) + 1;
                dice2Player_1 = generator.nextInt(6) + 1;
                dice1Player_2 = generator.nextInt(6) + 1;
                dice2Player_2 = generator.nextInt(6) + 1;
                System.out.println("Player1 dices: " + dice1Player_1 + " and " + dice2Player_1);
                System.out.println("Player2 dices: " + dice1Player_2 + " and " + dice2Player_2);

                int Player_1 = dice1Player_1 + dice2Player_1;
                int Player_2 = dice1Player_2 + dice2Player_2;
                if (Player_1 > Player_2) {
                    Player_1Victories++;
                    System.out.println("Player1 won");
                } else if (Player_2 > Player_1) {
                    Player_2Victories++;
                    System.out.println("Player2 won");
                } else {
                    System.out.println("It's a draw");
                }
            } else if (ans.equals("no")) {
                System.out.println("Player1 won " + Player_1Victories + " times");
                System.out.println("Player2 won " + Player_2Victories + " times");
                System.out.println("See you next time then");
                break;
            } else {
                System.out.println("Wrong input! Please, answer accordingly");
                //ans = read.nextLine();
            }
        }
    }
}
