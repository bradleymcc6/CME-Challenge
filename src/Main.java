import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean running = true;
        IsAnagram isAnagram = new IsAnagram();
        isAnagram.initialise();
        while(running){
        isAnagram.wordInputs();
        isAnagram.writeToFile();
        System.out.println("Would you like to enter another word? Y/N");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine().toLowerCase();
        if(result.equals("n")){
            running = false;
            }
    }
}}
