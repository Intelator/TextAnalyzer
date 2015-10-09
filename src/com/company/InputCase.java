package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

        System.out.println("Type path to your directory:");
        String path = getPathToFile();

        saveFile(path, engine);
    }

    static void helpCase() {
        Helper.help();
    }

    static void exitCase() {
        Main.setState(State.EXIT);
    }

    static void longFile() {
        System.out.println("Type path to your directory:");
        String path = getPathToFile();

        System.out.println("Insert length of your text");
        Integer lengthOfText = new Integer(Helper.scan());

        System.out.println("Insert length of string in text");
        Integer lengthOfString = new Integer(Helper.scan());

        String fileName = path + "\\results_long_of_" + + lengthOfText + "_characters.txt";
        createFile(fileName);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            char[] text = new char[lengthOfText];
            for (int i = 0; i < lengthOfText; i++) {
                text[i] = getRandomChar();
            }

            for (int i = 0; i < lengthOfText; i++) {
                bw.write(text, i, 1);
                if ((i != 0) && (i % lengthOfString == 0)) {
                    bw.newLine();
                }
            }

            //bw.write(text, 0, lengthOfText);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Finished");

    }

    static String getPathToFile() {
        String path = Helper.scan();
        return path;
    }

    static void readFile(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String readText = ".";
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
        String fileName = path + "\\results.txt";
        createFile(fileName);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            for (String word: engine.analizedText.keySet()) {
                String output = "Word " + word + " found " + engine.analizedText.get(word) + " times.";
                bw.newLine();
                bw.write(output, 0, output.length());
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Saved in file " + fileName);
    }

    static void createFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static char getRandomChar() {
        Random r = new Random();
        String dict = "abcdefghijklmnopqrstuvwxyz1234567890";
        char c = dict.charAt(r.nextInt(dict.length()));
        return c;
    }

}
