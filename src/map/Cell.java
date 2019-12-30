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
        int i;
        if (heroesHere.size() <= 1) {
            return null;
        }
        for (i = 0; i < heroesHere.size(); ++i) {
            if (heroesHere.get(i) == hero) {
                ++i;
                break;
            }
        }
        for (; i < heroesHere.size(); ++i) {
            if (!heroesHere.get(i).isDead()) {
                return heroesHere.get(i);
            }
        }
        return null;
    }

    public final ArrayList<Hero> getLocationHeroes() {
        return heroesHere;
    }
}
