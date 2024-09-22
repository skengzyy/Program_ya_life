package AdventOfCode;

import java.nio.Buffer;
import java.util.Scanner;

/**
 * This is GiftWrapping
 * @author Isaac Jerryson
 * @version 02.05.2024
 */
public class GiftWrapping {

    public static int wrapper(int length ,int width ,int height){
        return (2 * length * width) + (2 * width * height) + (2 * height * length) + (length * width);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    }
}