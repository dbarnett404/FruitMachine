import java.util.Arrays;
import java.util.Scanner;

public class FruitMachine {
    //Array (List) of fruit
    private String[] fruits = {"Apple", "Pear", "Banana", "Grape", "Orange", "Mango"};

    private int getIndex() {
        return (int)(Math.random() * fruits.length);
    }

    private String getFruits() {
        String fruitList = "";
        for (int i = 0; i < 4; i++) {
            fruitList += fruits[getIndex()] + " ";
        }
        return fruitList;
    }
    private String printFruit() {
        //4 matching = £10
        //3 matching = £5
        //2 matching = £1
        //Each turn costs £1
        String fruitList = getFruits();
        System.out.println(fruitList);
        return fruitList;
    }
    private int getScore(String fruitList) {
        int score = 0;
        String[] currentFruit = fruitList.split(" ");
        System.out.println(Arrays.toString(currentFruit));
        Arrays.sort(currentFruit);
        for (int i = 0; i < currentFruit.length; i++) {
            int highScore = 0;
            String checkFruit = currentFruit[i];
            for (int j = i + 1; j < currentFruit.length; j++) {
                if (checkFruit.equals(currentFruit[j])) {
                    highScore++;
                }
            }
            if (score == 1 && highScore == 1) {
                score = 4;
            }
            if (score < highScore) {
                score = highScore;
            }
        }
        return score;
    }
    public void playGame() {
        int yourMoney = 20;
        while (yourMoney >= 0) {
            String fruitList = printFruit();
            int score = getScore(fruitList);

            if (score == 1) {
                yourMoney += 1;
                System.out.println("Score is 1 pair. You win £" + 1);
            } else if (score == 2) {
                yourMoney += 5;
                System.out.println("Score is 3 matching. You win £" + 5);
            } else if (score == 3) {
                yourMoney += 10;
                System.out.println("Score is 4 matching. You win £" + 10);
            } else if (score == 4) {
                yourMoney += 2;
                System.out.println("Score is 2 pairs. You win £" + 2);
            } else {
                System.out.println("None matching");
            }
            yourMoney--;
            System.out.println("Money is £" + yourMoney);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
}

