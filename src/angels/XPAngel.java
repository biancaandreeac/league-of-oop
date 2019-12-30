package angels;

import common.Visitor;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class XPAngel extends Angel implements Visitor {
    XPAngel(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final int hp = 45;
        help(knight, hp);
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final int hp = 50;
        help(pyromancer, hp);
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final int hp = 40;
        help(rogue, hp);
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final int hp = 60;
        help(wizard, hp);
    }

    private void help(final Hero hero, final int hp) throws IOException {
        if (!hero.isDead()) {
            hero.addXP(hp);
            notifyObserver(hero);
            hero.checkLvl();
        }
    }
}
