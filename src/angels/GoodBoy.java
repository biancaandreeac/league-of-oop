package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class GoodBoy extends Angel{

    GoodBoy(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.angelModifier += 0.4f;
            knight.subHP(-20);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.angelModifier += 0.5f;
            pyromancer.subHP(-30);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.angelModifier += 0.4f;
            rogue.subHP(-40);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.angelModifier += 0.3f;
            wizard.subHP(-50);
        }
    }
}
