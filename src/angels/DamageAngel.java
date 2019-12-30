package angels;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class DamageAngel extends Angel {

    DamageAngel(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final float modifier = 0.15f;
        help(knight, modifier);
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final float modifier = 0.2f;
        help(pyromancer, modifier);
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final float modifier = 0.3f;
        help(rogue, modifier);
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final float modifier = 0.3f;
        help(wizard, modifier);
    }

    private void help(final Hero hero, final float modifier) throws IOException{
        if (!hero.isDead()) {
            hero.angelModifier += modifier;
            notifyObserver(hero);
        }
    }
}
