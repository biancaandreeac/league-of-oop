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

        try {
            File file = new File(myInputPath);
            Scanner sc = new Scanner(file);

            map = createMap(sc);       // use input to create the base map.
            heroes = createHeroes(sc); // use input to create heroes and place them in the map.
            rounds = createRounds(sc); // use input to create rounds.
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(map, heroes, rounds);
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
        HeroesFactory.getInstance();
        ArrayList<Hero> players;
        int noOfPlayers;

        noOfPlayers = sc.nextInt();
        sc.nextLine();  // go on next line

        players = new ArrayList<>(noOfPlayers);
        for (int i = 0; i < noOfPlayers; ++i) {
            Hero h = HeroesFactory.getHeroByType(sc.findInLine(".").charAt(0));
            assert h != null;
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
}
