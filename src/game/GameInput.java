package game;

import heros.Hero;
import map.Map;

import java.util.ArrayList;

public class GameInput {
    private Map map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    GameInput(Map map, ArrayList<Hero> heroes, ArrayList<String> rounds) {
        this.map = map;
        this.heroes = heroes;
        this.rounds = rounds;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }
}