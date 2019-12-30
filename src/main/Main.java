package main;

import game.GameInput;
import game.GameInputLoader;
import game.GameLogic;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        GameInput input = gameInputLoader.load();
        GameLogic game = new GameLogic(input);
        game.play(args[1]);
    }
}
