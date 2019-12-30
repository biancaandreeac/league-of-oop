package game;

import heroes.Hero;
import map.Map;

import java.util.ArrayList;

public class GameInput {
    private Map map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;
    private ArrayList<AngelsInput> angels;

    public GameInput(final Map map, final ArrayList<Hero> heroes, final ArrayList<String> rounds,
                     final ArrayList<AngelsInput> angels) {
        this.map = map;
        this.heroes = heroes;
        this.rounds = rounds;
        this.angels = angels;
    }

    public final Map getMap() {
        return map;
    }

    final ArrayList<Hero> getHeroes() {
        return heroes;
    }

    final ArrayList<String> getRounds() {
        return rounds;
    }

    public ArrayList<AngelsInput> getAngels() {
        return angels;
    }
}
