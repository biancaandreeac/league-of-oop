package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class DarkAngel extends Angel {

    DarkAngel(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final int hp = 40;
        if (!knight.isDead()) {
            knight.subHP(hp);
            notifyObserver(knight);
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final int hp = 30;
        if (!pyromancer.isDead()) {
            pyromancer.subHP(hp);
            notifyObserver(pyromancer);
        }
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final int hp = 10;
        if (!rogue.isDead()) {
            rogue.subHP(hp);
            notifyObserver(rogue);
        }
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final int hp = 20;
        if (!wizard.isDead()) {
            wizard.subHP(hp);
            notifyObserver(wizard);
        }
    }
}
