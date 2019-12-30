package heroes.strategies;

import heroes.Hero;

public class WizardLowHP implements HeroStrategy {
    /**
     * dacă CURRENT_HP < (1/4 * MAX_LEVEL_HP),
     * el va renunța la 20% din coeficienți și va primi 1/5 din HP-ul curent
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.angelModifier -= 0.2f;
        hero.subHP(-hero.getHp() / 5);

    }
}
