package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Ignite extends Ability {

    private float damage;
    private float periodicDamage;

    public Ignite(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        preferredLand = CellType.Volcanic;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE      = 0.8f;
        static final float KNIGHT     = 1.2f;
        static final float PYROMANCER = 0.9f;
        static final float WIZARD     = 1.05f;
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Rogue opponent) {
        applyAbility(pyromancer, RaceModifiers.ROGUE + pyromancer.angelModifier);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Knight opponent) {
        applyAbility(pyromancer, RaceModifiers.KNIGHT + pyromancer.angelModifier);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Pyromancer opponent) {
        applyAbility(pyromancer, RaceModifiers.PYROMANCER + pyromancer.angelModifier);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return Math.round(damage);
    }

    @Override
    public final float useAbility(final Hero pyromancer, final Wizard opponent) {
        applyAbility(pyromancer, RaceModifiers.WIZARD + pyromancer.angelModifier);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return Math.round(damage);
    }

    @Override
    public final float applyAbility(final Hero pyromancer, final float raceAmplifier) {
        damage = baseDamage(pyromancer);
        damage *= raceAmplifier;

        int dmgPerRoundAddLvl = 30;
        int dmgPerRound = 50;

        periodicDamage = dmgPerRound + pyromancer.getLvl() * dmgPerRoundAddLvl;
        if (pyromancer.getLocationType() == CellType.Volcanic) {
            periodicDamage *= landAmplifier;
            periodicDamage = Math.round(periodicDamage);
        }
        periodicDamage *= raceAmplifier - 0.000001f;

        return Math.round(damage);
    }

}
