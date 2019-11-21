package main;

import game.GameInput;
import game.GameInputLoader;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        GameInput game = gameInputLoader.load();
    }
}
