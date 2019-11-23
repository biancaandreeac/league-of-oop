package main;

import game.GameInput;
import game.GameInputLoader;
import game.GameLogic;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        GameInput input = gameInputLoader.load();
        GameLogic game = new GameLogic(input);
        game.play();
        game.printInFile(args[1]);
    }
}
