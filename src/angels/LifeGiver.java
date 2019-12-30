package angels;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class LifeGiver extends Angel {

    LifeGiver(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final int hp = 100;
        help(knight, hp);

    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final int hp = 80;
        help(pyromancer, hp);
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final int hp = 90;
        help(rogue, hp);
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final int hp = 120;
        help(wizard, hp);
    }

    private void help(final Hero hero, final int hp) throws IOException {
        if (!hero.isDead()) {
            if (hero.getHpMax() - hero.getHp() < hp) {
                hero.subHP(hero.getHp() - hero.getHpMax());
            } else {
                hero.subHP(-hp);
            }
            notifyObserver(hero);
        }
    }
}
