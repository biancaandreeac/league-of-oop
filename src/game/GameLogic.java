package game;

import admin.AngelsObserver;
import admin.HeroesObserver;
import angels.Angel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameLogic {
    private GameInput input;

    public GameLogic(final GameInput input) {
        this.input = input;
    }

    public final void play(final String outputFileName) {
        try {
            FileWriter fw = new FileWriter(outputFileName);

            // initialize BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);
            registerHeroObservers(bw);

            for (int i = 0; i < input.getRounds().size(); ++i) {
                bw.write("~~ Round " + (i + 1) + " ~~");
                bw.newLine();
                playRound(input.getRounds().get(i));
                angelsTurn(i, bw);
                bw.newLine();
            }

            printInFile(bw);
            // close the BufferedWriter object to finish operation
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Register observers for each player.
     * @param bw - used to print in a given file.
     */
    private void registerHeroObservers(final BufferedWriter bw) {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            input.getHeroes().get(i).register(new HeroesObserver(bw));
        }
    }

    private void playRound(final String round) throws IOException {
        applyDoT();
        moves(round);
        fights();
    }

    private void applyDoT() {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (!input.getHeroes().get(i).isDead()) {
                input.getHeroes().get(i).applyDamageOvertime();
            }
        }
    }


    private void moves(final String round) {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (input.getHeroes().get(i).isDead()) {
                continue;
            }

            // here we also choose a strategy if necessary
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
                default:
                    break;
            }
        }
    }

    private void fights() throws IOException {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (!input.getHeroes().get(i).isDead()) {
                input.getHeroes().get(i).fight();
            }
        }
    }

    /**
     * Now the angels are spawned.
     * @param roundNo - the number of this round.
     * @param bw - used by the observer to write in a file.
     */
    private void angelsTurn(final int roundNo, final BufferedWriter bw) throws IOException {
        AngelsInput angelsInput = input.getAngels().get(roundNo);
        if (angelsInput != null) {
            for (int i = 0; i < angelsInput.getNoOfAngels(); ++i) {
                Angel angel = angelsInput.getAngel(i);
                // every angel gets an observer.
                angel.register(new AngelsObserver(bw));
                angel.setLocation(angelsInput.getX(i), angelsInput.getY(i));
            }
        }
    }

    private void printInFile(final BufferedWriter bw) throws IOException {
        // write values
        bw.write("~~ Results ~~");
        bw.newLine();
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            bw.write(input.getHeroes().get(i).toString());
            bw.newLine();
        }

    }
}
