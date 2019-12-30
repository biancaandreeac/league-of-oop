package heroes.strategies;

import heroes.Hero;

public class KnightLowHP implements HeroStrategy {
    /**
     *  dacă CURRENT_HP < (1/3 * MAX_LEVEL_HP),
     *  el va renunța la 20% din coeficienți și va primi 1/4 din HP-ul curent
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.angelModifier -= 0.2f;
        hero.subHP(-hero.getHp() / 4);
    }
}
