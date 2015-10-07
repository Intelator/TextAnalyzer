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

    public static void process(String choice, CurEngine engine) {
        switch (choice) {
            case "type": InputCase.typeCase();
                break;
            case "file": InputCase.fileCase();
                break;
            case "count_all": InputCase.countAllCase(engine);
                break;
            case "count_word": InputCase.countWordCase(engine);
                break;
            case "to_screen": InputCase.toScreenCase(engine);
                break;
            case "to_file": InputCase.toFileCase(engine);
                break;
            case "help": InputCase.helpCase();
                break;
            case "exit": InputCase.exitCase();
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
