package com.company;

import java.util.ArrayList;

/**
 * Created by User on 06.10.2015.
 */
public interface Engine {
    ArrayList<ArrayList<String>> analizedText = new ArrayList<ArrayList<String>>();
    ArrayList<String> text = new ArrayList<String>();

    void dissasembleText (String inputText);
    void analyzeText (ArrayList<String> text);
}
