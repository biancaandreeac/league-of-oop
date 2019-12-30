package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class TheDoomer extends Angel {
    TheDoomer(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.subHP(knight.getHp());
            notifyObserver(knight);
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.subHP(pyromancer.getHp());
            notifyObserver(pyromancer);
        }
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.subHP(rogue.getHp());
            notifyObserver(rogue);
        }
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.subHP(wizard.getHp());
            notifyObserver(wizard);
        }
    }
}
