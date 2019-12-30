package heroes.strategies;

import heroes.Hero;

public class RogueLowHP implements HeroStrategy{

    /**
     * dacă CURRENT_HP < (1/7 * MAX_LEVEL_HP),
     * el va renunța la 10% din coeficienți și va primi 1/2 din HP-ul curent
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.angelModifier -= 0.1f;
        hero.subHP(-hero.getHp()/2);
    }
}
