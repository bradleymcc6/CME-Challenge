import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IsAnagram {
    String string1;
    String string2;
    boolean result;
    //Hashmap to store key-value pairs
    HashMap<String, String> hm = new HashMap<String, String>();

    public void initialise() {
        System.out.println("Welcome to the Anagram Checker. Please firstly enter a username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        //Check if input contains spaces or numbers
        while (!validateInput(username)) {
            System.out.println("The username cannot contain spaces or numbers, please enter a different value: ");
            username = scanner.nextLine();
        }
        ;
    }

    public boolean wordInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first word: ");
        string1 = scanner.nextLine();
        System.out.println("Please enter the second word: ");
        string2 = scanner.nextLine();
        if (!validateInput(string1) || !validateInput(string2)) {
            System.out.println("Looks like one of your words contains a number or space, please provide suitable words");
            wordInputs();
        } else {
            //Remove any capital letters from inputs to check as these would still be anagrams
            string1 = string1.toLowerCase();
            string2 = string2.toLowerCase();

            String anagrams = string1 + "," + string2;
            String anagrams2 = string2 + "," + string1;

            //Check if hashmap contains anagrams entered prior, in either order, before processing
            if (hm.containsKey(anagrams)) {
                if (hm.get(anagrams).equals("true")) {
                    System.out.println(anagrams);
                    System.out.println(anagrams2);
                    System.out.println("These words are anagrams");
                } else {
                    System.out.println("These words are not anagrams");

                }
            }
            //Check if anagrams exist in hashmap in different order, if two words are not the same
            else if (hm.containsKey(anagrams2) && !anagrams.equals(anagrams2)) {
                if (hm.get(anagrams2).equals("true")) {
                    System.out.println("These words are anagrams");
                } else {
                    System.out.println("These words are not anagrams");

                }
            }
            //If words not found in hashmap, check if they are anagrams
            else {
                if (anagramChecker(string1, string2)) {
                    System.out.println("These words are anagrams");
                    result = true;
                } else {
                    System.out.println("These words are not anagrams");
                    result = false;
                }

                hm.put(anagrams, String.valueOf(result));
            }
            return result;
        }

        return false;
    }

    public void writeToFile(){
        String text = string1 + "," + string2 + ":" + result + "\n";
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.createFile(text);
    }


    public boolean anagramChecker(String string1, String string2){
        //If the strings are different lengths, we can conclude they are not anagrams
        if (string1.length() != string2.length()) {
            return false;
        }
        //If the strings are anagrams, they should be equal once sorted. This is done using an array of chars
        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
    public boolean validateInput(String input){
        return !input.contains(" ") && !input.matches(".*\\d.*");
    }
}
