package AdventOfCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trying to solve this as easy as possible
 * @author Isaac Jerryson
 * @version 30.04.2024
 */
public class FloorFinder {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Floor Finder!");
        System.out.println("Please enter the floor instructions: ");

        String input = in.next();
        input = input.trim();

        char[] floors = input.toCharArray();
        int counter = 0;
        int negativeCounter = 0;

        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == '(') {
                counter++;
                if (counter == -1) {
                    negativeCounter = i + 1; // Increment the position by 1 to match the character position
                    break; // Exit the loop once we find the first character causing entry to basement
                }
            } else if (floors[i] == ')') {
                counter--;
                if (counter == -1) {
                    negativeCounter = i + 1; // Increment the position by 1 to match the character position
                    break; // Exit the loop once we find the first character causing entry to basement
                }
            }
        }

        System.out.println("Number of floors: " + counter);
        System.out.println("Position of first character causing entry to basement: " + negativeCounter);


    }
}
