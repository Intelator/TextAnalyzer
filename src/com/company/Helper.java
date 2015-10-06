package com.company;

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
            case "type": System.out.println("type");
                break;
            case "file": System.out.println("file");
                break;
            case "count_all": System.out.println("all");
                break;
            case "count_word": System.out.println("word");
                break;
            case "to_screen": System.out.println("screen");
                break;
            case "to_file": System.out.println("to_file");
                break;
            case "help": help();
                break;
            case "exit": Main.setState(State.EXIT);
                break;
            default: {
                System.out.println("Wrong choice, try again");
                help();
            }
        }
    }
}
