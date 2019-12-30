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

    Angel(AngelType type) {
        this.type = type;
    }

    public void setLocation(final int x, final int y) throws IOException {
        Cell location = Map.getCellAt(x, y);
        this.x = x;
        this.y = y;
        notifyObserver();
        ArrayList<Hero> heroes = location.getLocationHeroes();
        for (Hero hero : heroes) {
            hero.accept(this);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public AngelType getType() {
        return type;
    }

    public Boolean isGood() {
        return type != AngelType.TheDoomer && type != AngelType.Dracula
                && type != AngelType.DarkAngel;
    }

    @Override
    public void notifyObserver() throws IOException {
        angelObserver.update(this);
    }

    @Override
    public void notifyObserver(Object hero) throws IOException {
        angelObserver.update(this, hero);
    }

    @Override
    public void register(Observer observer) {
        angelObserver = observer;
    }
}
