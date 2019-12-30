package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class Dracula extends Angel{
    Dracula(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.angelModifier -= 0.2f;
            knight.subHP(60);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.angelModifier -= 0.3f;
            pyromancer.subHP(40);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.angelModifier -= 0.1f;
            rogue.subHP(35);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.angelModifier -= 0.4f;
            wizard.subHP(20);
        }
    }
}
