package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class LifeGiver extends Angel{

    LifeGiver(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            if (knight.getHpMax() - knight.getHp() < 100) {
                knight.subHP(knight.getHp() - knight.getHpMax());
            } else {
                knight.subHP(-100);
            }
            notifyObserver(knight);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            if (pyromancer.getHpMax() - pyromancer.getHp() < 80) {
                pyromancer.subHP(pyromancer.getHp() - pyromancer.getHpMax());
            } else {
                pyromancer.subHP(-80);
            }
            notifyObserver(pyromancer);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            if (rogue.getHpMax() - rogue.getHp() < 90) {
                rogue.subHP(rogue.getHp() - rogue.getHpMax());
            } else {
                rogue.subHP(-90);
            }
            notifyObserver(rogue);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            if (wizard.getHpMax() - wizard.getHp() < 120) {
                wizard.subHP(wizard.getHp() - wizard.getHpMax());
            } else {
                wizard.subHP(-120);
            }
            notifyObserver(wizard);
        }
    }
}
