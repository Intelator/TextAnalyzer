package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 06.10.2015.
 */
public class CurEngine implements Engine {
    ArrayList<ArrayList<String>> analizedText = new ArrayList<ArrayList<String>>();
    ArrayList<String> text = new ArrayList<String>();
    private String incomingText;

    public void setIncomingText (String text) {
        incomingText = text;
    }

    public String getIncomingText() {
        return incomingText;
    }

    @Override
    public void disassembleText (String inputText) {
        changeText();
        Scanner input = new Scanner(getIncomingText());
        while (input.hasNext()) {
            text.add(input.next());
        }
    }

    @Override
    public void analyzeText (ArrayList<String> text) {
        //TODO realize
    }

    public void analyzeText (ArrayList<String> text, String word) {
        //TODO realize
    }

    private void changeText() {
        setIncomingText(getIncomingText().toLowerCase());
        setIncomingText(getIncomingText().replace('.', ' '));
        setIncomingText(getIncomingText().replace(',', ' '));
        setIncomingText(getIncomingText().replace(':', ' '));
        setIncomingText(getIncomingText().replace(';', ' '));
        setIncomingText(getIncomingText().replace('?', ' '));
        setIncomingText(getIncomingText().replace('!', ' '));
    }
}
