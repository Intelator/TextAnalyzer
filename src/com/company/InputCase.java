package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 06.10.2015.
 */
public class InputCase {
    static void typeCase () {
        Main.setState(State.INPUT);
        System.out.println("Type your text here:");
        Main.engine.setIncomingText(Helper.scan());
        Main.engine.disassembleText(Main.engine.getIncomingText());
        System.out.println("Successful");
    }

    static void fileCase() {
        Main.setState(State.INPUT);

        String path = getPathToFile();
        readFile(path);
        Main.engine.disassembleText(Main.engine.getIncomingText());
    }

    static void countAllCase() {
        Main.setState(State.PROCESS);
        Main.engine.analyzeText(Main.engine.text);

    }

    static void countWordCase() {
        Main.setState(State.PROCESS);
        System.out.println("Type word for search:");
        String word = Helper.scan();
        Main.engine.analyzeText(Main.engine.text, word);
    }

    static void toScreenCase() {
        Main.setState(State.OUTPUT);
        for (String word: Main.engine.text) {
            System.out.println(word);
        }
    }

    static void toFileCase() {
        Main.setState(State.OUTPUT);
        //TODO realize
        System.out.println("to_file");
    }

    static void helpCase() {
        Helper.help();
    }

    static void exitCase() {
        Main.setState(State.EXIT);
    }

    static String getPathToFile() {
        System.out.println("Type path to your file:");
        String path = Helper.scan();
        return path;
    }

    static void readFile(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String readText = "..";
            String line = null;
            while ((line = br.readLine()) != null){
                readText += line;
            }

            Main.engine.setIncomingText(readText);
            System.out.println("Successful");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
