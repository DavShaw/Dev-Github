package pack3;

import java.util.Scanner;
public class App3 {
    public static void main(String args[]) {
        
        try (Scanner input = new Scanner(System.in)) {
            String word;
            String word_inverted = "";
            int word_length;
            
            
            System.out.print("\n================================\nHi, be welcome to my program!\n================================\n\n");
            System.out.print("Type something: ");
            word = input.nextLine();
            word_length = word.length();
      
            while(word_length != 0){
                word_inverted += word.substring(word_length -1,word_length);
                word_length--;
            }
            System.out.println("\n\n===================================");
            System.out.print("Inverted word: "+word_inverted+"\n");
            System.out.println("===================================");
            word = "";
            word_inverted = "";
            word_length = 0;
        }
    }
}