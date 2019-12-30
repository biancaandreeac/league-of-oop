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

    /**
     * There may be times when in a cell there are heroes that were defeated.
     * We have to get only one opponent that came after the given hero.
     * @param hero - a playing searching for an opponent.
     * @return - an opponent (if possible. else null)
     */
    public final Hero getOpponent(final Hero hero) {
        int i;
        if (heroesHere.size() <= 1) {
            return null;
        }

        // search the given hero.
        for (i = 0; i < heroesHere.size(); ++i) {
            if (heroesHere.get(i) == hero) {
                ++i;
                break;
            }
        }

        // search an opponent.
        for (; i < heroesHere.size(); ++i) {
            if (!heroesHere.get(i).isDead()) {
                return heroesHere.get(i);
            }
        }
        return null;
    }

    /**
     * Gets all the heroes that are in the current cell.
     * @return - list of present heroes.
     */
    public final ArrayList<Hero> getLocationHeroes() {
        return heroesHere;
    }
}
