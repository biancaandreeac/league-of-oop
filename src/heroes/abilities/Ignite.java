package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Ignite extends Ability {
    private final int dmgPerRound = 50;
    private final int dmgPerRoundAddLvl = 30;

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
    public final int useAbility(final Hero pyromancer, final Rogue opponent) {
        applyAbility(pyromancer, RaceModifiers.ROGUE);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Knight opponent) {
        applyAbility(pyromancer, RaceModifiers.KNIGHT);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Pyromancer opponent) {
        applyAbility(pyromancer, RaceModifiers.PYROMANCER);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return (int) damage;
    }

    @Override
    public final int useAbility(final Hero pyromancer, final Wizard opponent) {
        applyAbility(pyromancer, RaceModifiers.WIZARD);
        opponent.setDamageOverTime(Math.round(periodicDamage), 2, 0);
        return (int) damage;
    }

    @Override
    public final int applyAbility(final Hero pyromancer, final float raceAmplifier) {
        damage = baseDamage(pyromancer);
        damage *= raceAmplifier;
        damage = Math.round(damage);

        periodicDamage = dmgPerRound + pyromancer.getLvl() * dmgPerRoundAddLvl;
        periodicDamage *= raceAmplifier;
        if (pyromancer.getLocationType() == CellType.Volcanic) {
            periodicDamage *= landAmplifier;
            periodicDamage = Math.round(periodicDamage);
        }
        return (int) damage;
    }
}
