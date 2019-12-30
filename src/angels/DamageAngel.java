package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class DamageAngel extends Angel {

    DamageAngel(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.angelModifier += 0.15f;
            notifyObserver(knight);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.angelModifier += 0.2f;
            notifyObserver(pyromancer);

        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.angelModifier += 0.3f;
            notifyObserver(rogue);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.angelModifier += 0.3f;
            notifyObserver(wizard);
        }
    }
}
