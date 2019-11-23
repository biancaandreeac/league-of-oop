package game;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GameLogic {
    private GameInput input;

    public GameLogic(GameInput input) {
        this.input = input;
    }

    public void play() {
        for (int i = 0; i < input.getRounds().size(); ++i) {
            playRound(input.getRounds().get(i));
        }

        for (int i = 0; i < input.getHeroes().size(); ++i) {
            if (!input.getHeroes().get(i).isDead()) {
                input.getHeroes().get(i).checkLvl();
            }
        }

        print();
    }

    private void playRound(String round) {
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

    private void moves(String round) {
        for (int i = 0; i < input.getHeroes().size(); ++i) {

            input.getHeroes().get(i).print();

            if (input.getHeroes().get(i).isDead()) {
                continue;
            }

            if (!input.getHeroes().get(i).canMove()) {
                input.getHeroes().get(i).move(0, 0);
                continue;
            }

            char c = round.charAt(i);
            switch (c) {
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
            if (input.getHeroes().get(i).isDead()) {
                continue;
            }
            input.getHeroes().get(i).fight();
        }
    }

    private void print() {
        for (int i = 0; i < input.getHeroes().size(); ++i) {
            input.getHeroes().get(i).print();
        }
    }

    public void printInFile(String out) {
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
