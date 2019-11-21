package abilities;

import heros.Hero;
import heros.HeroType;

import java.util.Map;

public class Drain extends Ability {
    int damage;

    // dmg from here is actually percent. same goes for dmgadd...
    public Drain(int dmg, float landAmplifier, int dmgAddPerLevel,
                 Map<HeroType, Float> raceAmplifier) {
        super(dmg, landAmplifier, dmgAddPerLevel, raceAmplifier);
    }


//    void computeDamage(Hero opponent) {
//        // damage = procent * min(0.3 * OPPONENT_MAX_HP, OPPONENT_CURRENT_HP)
//    }
}
