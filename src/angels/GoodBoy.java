package angels;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class GoodBoy extends Angel {

    GoodBoy(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final float modifier = 0.4f;
        final int hp = -20;
        help(knight, modifier, hp);
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final float modifier = 0.5f;
        final int hp = -30;
        help(pyromancer, modifier, hp);
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final float modifier = 0.4f;
        final int hp = -40;
        help(rogue, modifier, hp);
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final float modifier = 0.3f;
        final int hp = -50;
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
