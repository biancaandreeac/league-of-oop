package angels;

import common.Visitor;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class XPAngel extends Angel implements Visitor {
    XPAngel(AngelType type) {
        super(type);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if (!knight.isDead()) {
            knight.addXP(45);
            knight.checkLvl();
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if (!pyromancer.isDead()) {
            pyromancer.addXP(50);
            pyromancer.checkLvl();
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if (!rogue.isDead()) {
            rogue.addXP(40);
            rogue.checkLvl();
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if (!wizard.isDead()) {
            wizard.addXP(60);
            wizard.checkLvl();
        }
    }
}
