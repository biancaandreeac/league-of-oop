package game;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GameLogic {
    private GameInput input;

    public GameLogic(final GameInput input) {
        this.input = input;
    }

    public void play() {
        for (int i = 0; i < input.getRounds().size(); ++i) {
            playRound(input.getRounds().get(i));
        }
    }

    private void playRound(final String round) {
        applyDoT();
        moves(round);
        fights();
    }

    private void applyDoT() {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (!input.getHeroes().get(i).isDead()) {
                input.getHeroes().get(i).DoT();
            }
        }
    }

    private void moves(final String round) {
        for (int i = 0; i < input.getHeroes().size(); ++i) {

            if (input.getHeroes().get(i).isDead()) {
                continue;
            }

            if (!input.getHeroes().get(i).canMove()) {
                input.getHeroes().get(i).move(0, 0);
                continue;
            }

            switch (round.charAt(i)) {
                case 'U':
                    input.getHeroes().get(i).move(-1, 0);
                    break;
                case 'D':
                    input.getHeroes().get(i).move(1, 0);
                    break;
                case 'R':
                    input.getHeroes().get(i).move(0, 1);
                    break;
                case 'L':
                    input.getHeroes().get(i).move(0, -1);
                    break;
                case '_':
                    input.getHeroes().get(i).move(0, 0);
                    break;
            }
        }
    }

    private void fights() {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (!input.getHeroes().get(i).isDead()) {
                input.getHeroes().get(i).fight();
            }
        }
    }

    public void printInFile(final String out) {
        try {
            FileWriter fw = new FileWriter(out);
            // initialize BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);
            // write values
            for (int i = 0; i < input.getHeroes().size(); ++i) {
                bw.write(input.getHeroes().get(i).toString());
                bw.newLine();
            }
            // close the BufferedWriter object to finish operation
            bw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
