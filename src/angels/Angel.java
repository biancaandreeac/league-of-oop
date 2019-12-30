package angels;

import common.Observable;
import common.Observer;
import common.Visitor;
import heroes.Hero;
import map.Cell;
import map.Map;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Angel implements Visitor, Observable {
    private Observer angelObserver;
    private AngelType type;
    private int x, y;

    Angel(final AngelType type) {
        this.type = type;
    }

    public final void setLocation(final int newX, final int newY) throws IOException {
        Cell location = Map.getCellAt(newX, newY);
        x = newX;
        y = newY;
        notifyObserver();
        ArrayList<Hero> heroes = location.getLocationHeroes();
        for (Hero hero : heroes) {
            hero.accept(this);
        }
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final AngelType getType() {
        return type;
    }

    public final Boolean isGood() {
        return type != AngelType.TheDoomer && type != AngelType.Dracula
                && type != AngelType.DarkAngel;
    }

    @Override
    public final void notifyObserver() throws IOException {
        angelObserver.update(this);
    }

    @Override
    public final void notifyObserver(final Object hero) throws IOException {
        angelObserver.update(this, hero);
    }

    @Override
    public final void register(final Observer observer) {
        angelObserver = observer;
    }
}
