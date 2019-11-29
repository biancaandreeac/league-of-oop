package heroes.abilities;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Drain extends Ability {
    private float percent;
    private float percentPerLvl;
    private int baseHP;

    // dmg and dmgAddPerLevel here are actually percent.
    Drain(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        final float scale = 100f;
        percent = dmg / scale;
        percentPerLvl = dmgAddPerLevel / scale;
        preferredLand = CellType.Desert;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 0.8f;
        static final float KNIGHT = 1.2f;
        static final float PYROMANCER = 0.9f;
        static final float WIZARD = 1.05f;
    }

    @Override
    public final int useAbility(final Hero wizard, final Rogue opponent) {
            baseHP = Math.min(Math.round(Constants.DRAIN_PERCENT * opponent.getHpMax()),
                        opponent.getHp());
        return applyAbility(wizard, RaceModifiers.ROGUE);
    }

    @Override
    public final int useAbility(final Hero wizard, final Knight opponent) {
        baseHP = Math.min(Math.round(Constants.DRAIN_PERCENT * opponent.getHpMax()),
                    opponent.getHp());
        return applyAbility(wizard, RaceModifiers.KNIGHT);
    }

    @Override
    public final int useAbility(final Hero wizard, final Pyromancer opponent) {
        baseHP = Math.min(Math.round(Constants.DRAIN_PERCENT * opponent.getHpMax()),
                    opponent.getHp());
        return applyAbility(wizard, RaceModifiers.PYROMANCER);
    }

    @Override
    public final int useAbility(final Hero wizard, final Wizard opponent) {
        baseHP = Math.min(Math.round(Constants.DRAIN_PERCENT * opponent.getHpMax()),
                    opponent.getHp());
        return applyAbility(wizard, RaceModifiers.WIZARD);
    }

    @Override
    public final int applyAbility(final Hero wizard, final float raceAmplifier) {
        float amplifier;

        amplifier = percent + percentPerLvl * wizard.getLvl();
        amplifier *= raceAmplifier;

        if (wizard.getLocationType() == preferredLand) {
            amplifier *= landAmplifier;
        }

        return Math.round(amplifier * baseHP);
    }


}
