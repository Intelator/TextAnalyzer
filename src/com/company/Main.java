package com.company;

import java.util.Scanner;

public class Main {
    public static CurEngine engine = new CurEngine();

    private static State state;

    protected static void setState(State state) {
        Main.state = state;
    }

    protected static State getState() {
        return state;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;


        state = State.INITIALISATION;

        Helper.help();

        while (getState() != State.EXIT) {
            input = scanner.next();
            Helper.process(input, engine);
        }
    }
}
