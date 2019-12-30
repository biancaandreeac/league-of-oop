package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class Spawner extends Angel {

    Spawner(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final int hp = -200;
        if (knight.isDead()) {
            knight.subHP(hp);
            notifyObserver(knight);
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final int hp = -150;
        if (pyromancer.isDead()) {
            pyromancer.subHP(hp);
            notifyObserver(pyromancer);
        }
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final int hp = -180;
        if (rogue.isDead()) {
            rogue.subHP(hp);
            notifyObserver(rogue);
        }
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final int hp = -120;
        if (wizard.isDead()) {
            wizard.subHP(hp);
            notifyObserver(wizard);
        }
    }
}
