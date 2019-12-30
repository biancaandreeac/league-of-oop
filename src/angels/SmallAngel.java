package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class SmallAngel extends Angel {

    SmallAngel(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.angelModifier += 0.1f;
            knight.subHP(-10);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.angelModifier += 0.15f;
            pyromancer.subHP(-15);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.angelModifier += 0.05f;
            rogue.subHP(-20);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.angelModifier += 0.1f;
            wizard.subHP(-25);
        }
    }
}
