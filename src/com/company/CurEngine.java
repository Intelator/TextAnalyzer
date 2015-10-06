package com.company;

import java.util.ArrayList;

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
    public void disassembleText (String inputText) {}

    @Override
    public void analyzeText (ArrayList<String> text) {}
}
