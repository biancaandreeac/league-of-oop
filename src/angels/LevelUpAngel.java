package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class LevelUpAngel extends Angel {

    LevelUpAngel(final AngelType type) {
        super(type);
    }

    @Override
    public final void visit(final Knight knight) throws IOException {
        final float modifier = 0.1f;
        if (!knight.isDead()) {
            knight.angelModifier += modifier;
            notifyObserver(knight);
            knight.lvlUp();
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) throws IOException {
        final float modifier = 0.2f;
        if (!pyromancer.isDead()) {
            pyromancer.angelModifier += modifier;
            notifyObserver(pyromancer);
            pyromancer.lvlUp();
        }
    }

    @Override
    public final void visit(final Rogue rogue) throws IOException {
        final float modifier = 0.15f;
        if (!rogue.isDead()) {
            rogue.angelModifier += modifier;
            notifyObserver(rogue);
            rogue.lvlUp();
        }
    }

    @Override
    public final void visit(final Wizard wizard) throws IOException {
        final float modifier = 0.25f;
        if (!wizard.isDead()) {
            wizard.angelModifier += modifier;
            notifyObserver(wizard);
            wizard.lvlUp();
        }
    }
}
