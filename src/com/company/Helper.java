package com.company;

import java.util.Scanner;

/**
 * Created by User on 06.10.2015.
 */
public class Helper {

    public static void help() {
        System.out.println("Keywords:");
        System.out.println("type - to input text from keyboard");
        System.out.println("file - to input text from file");
        System.out.println("count_all - to count entry of each word");
        System.out.println("count_word - to count entry of certain word");
        System.out.println("to_screen - to output result to screen");
        System.out.println("to_file - to output results to file");
        System.out.println("help - to see legend");
        System.out.println("exit - to terminate application");
    }

    public static void process(String choice) {
        switch (choice) {
            case "type": InputCases.typeCase();
                break;
            case "file": InputCases.fileCase();
                break;
            case "count_all": InputCases.countAllCase();
                break;
            case "count_word": InputCases.countWordCase();
                break;
            case "to_screen": InputCases.toScreenCase();
                break;
            case "to_file": InputCases.toFileCase();
                break;
            case "help": InputCases.helpCase();
                break;
            case "exit": InputCases.exitCase();
                break;
            default: {
                System.out.println("Wrong choice, try again");
                help();
            }
        }
    }

    public static String scan () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
