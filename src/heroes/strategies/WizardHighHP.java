package heroes.strategies;

import heroes.Hero;

public class WizardHighHP implements HeroStrategy {

    @Override
    public void chooseStrategy(Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        if (maxHp / 4 < hero.getHp() && hero.getHp() < maxHp / 2) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / 4) {
            lowHP(hero);
        }
    }

    /**
     * dacă (1/4 * MAX_LEVEL_HP) < CURRENT_HP < (1/2 * MAX_LEVEL_HP)
     * el va renunța la 1/10 din HP-ul curent și va crește coeficienții cu 60%
     */
    private void highHP(Hero hero) {
        hero.subHP(hero.getHp() / 10);
        hero.angelModifier += 0.6f;
    }
    /**
     * dacă CURRENT_HP < (1/4 * MAX_LEVEL_HP),
     * el va renunța la 20% din coeficienți și va primi 1/5 din HP-ul curent
     */
    private void lowHP(Hero hero) {
        hero.angelModifier -= 0.2f;
        hero.subHP(-hero.getHp() / 5);
    }
}
