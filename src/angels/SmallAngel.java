package angels;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import java.io.IOException;

public class SmallAngel extends Angel {

    SmallAngel(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final float modifier = 0.1f;
        final int hp = -10;
        help(knight, modifier, hp);
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final float modifier = 0.15f;
        final int hp = -15;
        help(pyromancer, modifier, hp);
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final float modifier = 0.05f;
        final int hp = -20;
        help(rogue, modifier, hp);
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final float modifier = 0.1f;
        final int hp = -25;
        help(wizard, modifier, hp);
    }

    private void help(final Hero hero, final float modifier, final int hp) throws IOException {
        if (!hero.isDead()) {
            hero.angelModifier += modifier;
            hero.subHP(hp);
            notifyObserver(hero);
        }
    }
}
