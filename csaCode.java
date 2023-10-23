import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Hangman {
    public static ArrayList<String> secretWords = new ArrayList<>();
    public static ArrayList<String> displayList = new ArrayList<>();

    //constructor
    public Hangman() {
      secretWords.add("apple");
      secretWords.add("orange");
      secretWords.add("banana");
      secretWords.add("pear");
    }

    //method to pick random secret word from list
    public static String randomSecretWord() {
        int minIndex = 0;
        int maxIndex = secretWords.size();
        Random rand = new Random();
        int randInt = rand.nextInt(secretWords.size());

        String chosenSecretWord = secretWords.get(randInt);

        for (int i = 0; i < chosenSecretWord.length(); i++) {
            displayList.add("-");
        }
        return chosenSecretWord;
    }

    //method that takes user input
    public static String userInput() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter a word: ");
      String userWord = scanner.next();
      return userWord;
    }

    //method that checks whether displayList still has dashes
    public static boolean containsDash() {
        for (int i = 0; i < displayList.size(); i++) {
            if (displayList.get(i) == "-") {
                return true;
            } 
        }
        return false;
    }

    //hangman display function
    public static void hangmanDisplay(String guessed, String secret) {
        for (int i = 0; i < guessed.length(); i++) {
            for (int j = 0; j < secret.length(); j++) {
                if (guessed.charAt(i) == secret.charAt(j) && displayList.get(j).equals("-")) {
                    displayList.set(j, String.valueOf(guessed.charAt(i)));
                }
            }
        }
        String printResult = String.join("", displayList);
        System.out.println(printResult);
    }


    //main method
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        String secret = randomSecretWord();

        while (containsDash() == true) {
            String guessed = userInput();
            hangmanDisplay(guessed, secret);
        }
    }
}
