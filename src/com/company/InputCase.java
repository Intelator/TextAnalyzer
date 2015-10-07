package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 06.10.2015.
 */
public class InputCase {
    static void typeCase (CurEngine engine) {
        Main.setState(State.INPUT);
        System.out.println("Type your text here:");
        Main.engine.setIncomingText(Helper.scan());
        Main.engine.disassembleText(Main.engine.getIncomingText());
        System.out.println("Successful");
    }

    static void fileCase(CurEngine engine) {
        Main.setState(State.INPUT);

        String path = getPathToFile();
        readFile(path);
        Main.engine.disassembleText(Main.engine.getIncomingText());
    }

    static void countAllCase(CurEngine engine) {
        Main.setState(State.PROCESS_TEXT);
        engine.analizedText.clear();
        Main.engine.analyzeText(Main.engine.text);

    }

    static void countWordCase(CurEngine engine) {
        Main.setState(State.PROCESS_WORD);
        engine.setQuantiyOfWord(0);
        System.out.println("Type word for search:");
        String word = Helper.scan();
        word = word.toLowerCase();
        engine.setWordForSearch(word);
        Main.engine.analyzeText(Main.engine.text, engine.getWordForSearch());
    }

    static void toScreenCase(CurEngine engine) {
        State prevState = Main.getState();
        Main.setState(State.OUTPUT);
        if (prevState == State.PROCESS_TEXT)
            {
                System.out.println("Your text has those words:");
                for (String word: engine.analizedText.keySet())
                {
                    System.out.println("Word " + word + " found " + engine.analizedText.get(word) + " times.");
                }
            }
        else if (prevState == State.PROCESS_WORD)
            {
                System.out.println("Word " + engine.getWordForSearch() + " found " + engine.getQuantiyOfWord() + " times");
            }
    }

    static void toFileCase(CurEngine engine) {
        Main.setState(State.OUTPUT);
        //TODO realize
        System.out.println("to_file");
    }

    static void helpCase(CurEngine engine) {
        Helper.help();
    }

    static void exitCase(CurEngine engine) {
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

    /*
    static void output (Map text, int quantityOfWords) {
        Main.setState(State.OUTPUT);

    }
    */
}
