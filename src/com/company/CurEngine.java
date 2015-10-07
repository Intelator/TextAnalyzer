package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by User on 06.10.2015.
 */
public class CurEngine implements Engine {
    Map<String, Integer> analizedText = new HashMap<String, Integer>();
    ArrayList<String> text = new ArrayList<String>();
    private int quantiyOfWord = 0;
    private String incomingText;
    private String wordForSearch;

    public void setQuantiyOfWord(int quantity) {
        quantiyOfWord = quantity;
    }

    public int getQuantiyOfWord() {
        return quantiyOfWord;
    }
    
    public void setWordForSearch (String text) {
        wordForSearch = text;
    }

    public String getWordForSearch() {
        return wordForSearch;
    }

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
        for (String word: text) {
            if (analizedText.containsKey(word))
                {
                    int i = analizedText.get(word);
                    analizedText.put(word, ++i);
                }
            else
                {
                    analizedText.put(word, 1);
                }
        }
        System.out.println("Analysis of text finished");
    }

    public void analyzeText (ArrayList<String> text, String word) {
        analyzeText(text);
        setQuantiyOfWord(analizedText.get(word));
        System.out.println("Search of word finished");
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
