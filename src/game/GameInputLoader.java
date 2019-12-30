package game;

import heroes.Hero;
import heroes.HeroesFactory;
import map.Map;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInputLoader {
    private String myInputPath;

    public GameInputLoader(final String inputPath) {
        myInputPath = inputPath;
    }

    public final GameInput load() {
        Map map = null;
        ArrayList<Hero> heroes = null;
        ArrayList<String> rounds = null;
        ArrayList<AngelsInput> angels = null;

        try {
            File file = new File(myInputPath);
            Scanner sc = new Scanner(file);

            map = createMap(sc);       // use input to create the base map.
            heroes = createHeroes(sc); // use input to create heroes and place them in the map.
            rounds = createRounds(sc); // use input to create rounds.
            angels = createAngels(sc, rounds.size()); // use input to create angels

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(map, heroes, rounds, angels);
    }

    private Map createMap(final Scanner sc) {
        ArrayList<ArrayList<Character>> map;
        int lines, cols;

        lines = sc.nextInt();
        cols = sc.nextInt();
        sc.nextLine();  // go on next line

        map = new ArrayList<>(lines);
        ArrayList<Character> line = new ArrayList<>(cols);

        for (int i = 0; i < lines; ++i) {
            String s = sc.nextLine();
            for (int j = 0; j < cols; ++j) {
                line.add(s.charAt(j));
            }
            map.add(new ArrayList<>(line));
            line.clear();
        }

        return Map.getInstance(map);
    }

    private ArrayList<Hero> createHeroes(final Scanner sc) {
        ArrayList<Hero> players;
        int noOfPlayers;

        noOfPlayers = sc.nextInt();
        sc.nextLine();  // go on next line

        players = new ArrayList<>(noOfPlayers);
        for (int i = 0; i < noOfPlayers; ++i) {
            Hero h = HeroesFactory.getHeroByType(sc.findInLine(".").charAt(0));
            assert h != null;
            h.setID(i);
            h.initLocation(sc.nextInt(), sc.nextInt()); // place the player on the map
            players.add(h);
            sc.nextLine();  // go on next line
        }
        return players;
    }

    private ArrayList<String> createRounds(final Scanner sc) {
        ArrayList<String> rounds;
        int noOfRounds;
        noOfRounds = sc.nextInt();
        sc.nextLine();  // go on next line
        rounds = new ArrayList<>(noOfRounds);
        for (int i = 0; i < noOfRounds; ++i) {
            rounds.add(sc.nextLine());
        }
        return rounds;
    }

    private ArrayList<AngelsInput> createAngels(final Scanner sc, final int noOfRounds) {
        ArrayList<AngelsInput> angels = new ArrayList<>();

        AngelsInput angelsPerRound;
        int noOfAngels, x, y, i, j;

        // get the angels for each round
        for (i = 0; i < noOfRounds; ++i) {

            noOfAngels = sc.nextInt();
            // the first integer on a line is the number of angels

            if (noOfAngels == 0) {
                angels.add(null);
                // if there are no angels for a particular round, we add null
                continue;
            }

            // get all the angels for this round
            String roundAngels = sc.nextLine();

            /* Each item from this array have a string describing the angel type  *
             * and the coordinates where the angel will be placed                 */
            String[] individualAngel = roundAngels.trim().split("\\s+");

            angelsPerRound = new AngelsInput();

            for (j = 0; j < noOfAngels; ++j) {
                String[] angelCharacteristics = individualAngel[j].split(",");

                x = Integer.parseInt(angelCharacteristics[1]); // x coordinate
                y = Integer.parseInt(angelCharacteristics[2]); // y coordinate

                angelsPerRound.addAngel(angelCharacteristics[0], x, y);
            }
            angels.add(angelsPerRound);
        }
        return angels;
    }
}
