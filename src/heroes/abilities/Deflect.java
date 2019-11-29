package heroes.abilities;

import heroes.Hero;
import heroes.Knight;
import heroes.Rogue;
import heroes.Wizard;
import heroes.Pyromancer;
import map.CellType;

public class Deflect extends Ability {
    private final float percent;
    private final float maxPercent = 70;
    private final float percentPerLvl;
    private float damage;

    // dmg from here is actually percent. same goes for dmgadd...
    public Deflect(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        super(dmg, landAmplifier, dmgAddPerLevel);
        final float scale = 100;
        percent = dmg / scale;
        percentPerLvl = dmgAddPerLevel / scale;
        preferredLand = CellType.Desert;
    }

    /**
     * Class containing all race modifiers.
     */
    private static class RaceModifiers {
        static final float ROGUE = 1.2f;
        static final float KNIGHT = 1.4f;
        static final float PYROMANCER = 1.3f;
    }

    @Override
    public final int useAbility(final Hero wizard, final Rogue opponent) {
        getDamageByOpponent(opponent);
        return applyAbility(wizard, RaceModifiers.ROGUE);
    }

    @Override
    public final int useAbility(final Hero wizard, final Knight opponent) {
        getDamageByOpponent(opponent);
        return applyAbility(wizard, RaceModifiers.KNIGHT);
    }

    @Override
    public final int useAbility(final Hero wizard, final Pyromancer opponent) {
        getDamageByOpponent(opponent);
        return applyAbility(wizard, RaceModifiers.PYROMANCER);
    }

    @Override
    public final int useAbility(final Hero wizard, final Wizard opponent) {
        return 0;
    }

    @Override
    public final int applyAbility(final Hero wizard, final float raceAmplifier) {
        float amplifier;
        amplifier = Math.min(maxPercent, percent + wizard.getLvl() * percentPerLvl);
        amplifier *= raceAmplifier;

        if (wizard.getLocationType() == preferredLand) {
            amplifier *= landAmplifier;
        }

        return Math.round(damage * amplifier);
    }

    /**
     * Computes the damage that is given to the attacker, but without race modifiers.
     * @param opponent - the attacked player.
     */
    private void getDamageByOpponent(final Hero opponent) {
        Ability ability;
        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(0));
        damage = ability.baseDamage(opponent);
        ability = AbilityFactory.getAbilityByType(opponent.getAbilities().get(1));
        damage += ability.baseDamage(opponent);
    }


}
