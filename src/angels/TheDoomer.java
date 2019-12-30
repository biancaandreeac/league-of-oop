package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class TheDoomer extends Angel {
    TheDoomer(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.subHP(knight.getHp());
            notifyObserver(knight);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.subHP(pyromancer.getHp());
            notifyObserver(pyromancer);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.subHP(rogue.getHp());
            notifyObserver(rogue);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.subHP(wizard.getHp());
            notifyObserver(wizard);
        }
    }
}
