package heroes.strategies;

import heroes.Hero;

public class PyromancerLowHP implements HeroStrategy {
    /**
     * dacă CURRENT_HP < (1/4 * MAX_LEVEL_HP),
     * el va renunța la 30% din coeficienți și va primi 1/3 din HP-ul curent
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.angelModifier -= 0.3f;
        hero.subHP(-hero.getHp()/3);
    }
}
