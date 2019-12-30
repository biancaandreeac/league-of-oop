package heroes.abilities;

import heroes.*;
import map.CellType;

public abstract class Ability {
    float landAmplifier;
    private int dmg;
    private int dmgAddPerLevel;
    CellType preferredLand;

    public Ability(final int dmg, final float landAmplifier, final int dmgAddPerLevel) {
        this.dmg = dmg;
        this.landAmplifier = landAmplifier;
        this.dmgAddPerLevel = dmgAddPerLevel;
    }

    /**
     * Computes the damage without race modifiers.
     * @param attacker - the player who attacks;
     * @return - the damage computed.
     */
    float baseDamage(final Hero attacker) {
        float damage;
        damage = dmg + attacker.getLvl() * dmgAddPerLevel;

        if (attacker.getLocationType() == preferredLand) {
            damage *= landAmplifier;
        }
        return Math.round(damage);
    }

    /**
     * General function used to compute the total damage given by the current ability.
     * @param hero - the player who attacks.
     * @param raceAmplifier - amplifier based on the opponent's type
     * @return - total damage.
     */
    public abstract float applyAbility(Hero hero, float raceAmplifier);

    // Abstract functions used for double dispatch
    public abstract float useAbility(Hero attacker, Pyromancer opponent);
    public abstract float useAbility(Hero attacker, Knight opponent);
    public abstract float useAbility(Hero attacker, Rogue opponent);
    public abstract float useAbility(Hero attacker, Wizard opponent);

}
