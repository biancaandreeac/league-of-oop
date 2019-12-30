package heroes.strategies;

import heroes.Hero;

public class PyromancerHighHP implements HeroStrategy {
    /**
     * dacă (1/4 * MAX_LEVEL_HP) < CURRENT_HP < (1/3 * MAX_LEVEL_HP),
     * el va renunța la 1/4 din HP-ul curent și va crește coeficienții cu 70%
     */

    @Override
    public void applyStrategy(Hero hero) {
        hero.subHP(hero.getHp() / 4);
        hero.angelModifier += 0.7f;
    }
}
