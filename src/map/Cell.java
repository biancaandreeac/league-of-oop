package map;

import heros.Hero;

import java.util.ArrayList;

public class Cell {
    private final CellType type;
    private ArrayList<Hero> heroesHere;

    Cell (CellType type) {
        this.type = type;
        heroesHere = new ArrayList<>();
    }

    public void visit(Hero hero) {
        heroesHere.add(hero);
    }

    public void leave(Hero hero) {
        heroesHere.remove(hero);
    }

    public CellType getType() {
        return type;
    }

    public Hero getOpponent(Hero hero) {
        if (heroesHere.size() <= 1) return null;
        return (heroesHere.get(0) == hero) ? heroesHere.get(1) : heroesHere.get(0);
    }
}
