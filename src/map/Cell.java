package map;

import heroes.Hero;

import java.util.ArrayList;

public class Cell {
    private final CellType type;
    private ArrayList<Hero> heroesHere;

    Cell(final CellType type) {
        this.type = type;
        heroesHere = new ArrayList<>();
    }

    public final void visit(final Hero hero) {
        heroesHere.add(hero);
    }

    public final void leave(final Hero hero) {
        heroesHere.remove(hero);
    }

    public final CellType getType() {
        return type;
    }

    public final Hero getOpponent(final Hero hero) {
        if (heroesHere.size() <= 1) {
            return null;
        }
        return (heroesHere.get(0) == hero) ? heroesHere.get(1) : heroesHere.get(0);
    }
}
