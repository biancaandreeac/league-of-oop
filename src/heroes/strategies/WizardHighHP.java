package heroes.strategies;

import heroes.Hero;

public class WizardHighHP implements HeroStrategy {
    /**
     * dacă (1/4 * MAX_LEVEL_HP) < CURRENT_HP < (1/2 * MAX_LEVEL_HP)
     * el va renunța la 1/10 din HP-ul curent și va crește coeficienții cu 60%
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.subHP(hero.getHp() / 10);
        hero.angelModifier += 0.6f;
    }
}
