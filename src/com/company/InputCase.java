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
    static void typeCase () {
        Main.setState(State.INPUT);
        System.out.println("Type your text here:");
        Main.engine.setIncomingText(Helper.scan());
        Main.engine.disassembleText(Main.engine.getIncomingText());
        System.out.println("Successful");
    }

    static void fileCase() {
        Main.setState(State.INPUT);

        System.out.println("Type path to your file:");
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
        System.out.println("Type word for search:");
        String word = Helper.scan();
        word = word.toLowerCase();
        engine.setWordForSearch(word);
        Main.engine.analyzeText(Main.engine.text, engine.getWordForSearch());
    }

    static void toScreenCase(CurEngine engine) {

        Main.setState(State.OUTPUT);
        for (String word: engine.analizedText.keySet())
            {
                System.out.println("Word " + word + " found " + engine.analizedText.get(word) + " times.");
            }
    }

    static void toFileCase(CurEngine engine) {
        Main.setState(State.OUTPUT);

        System.out.println("Type path to your directory");
        String path = getPathToFile();

        saveFile(path, engine);
    }

    static void helpCase() {
        Helper.help();
    }

    static void exitCase() {
        Main.setState(State.EXIT);
    }

    static String getPathToFile() {
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

    static void saveFile(String path, CurEngine engine) {
        //TODO realize
    }

}
