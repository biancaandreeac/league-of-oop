package heroes.strategies;

import heroes.Hero;

public class RogueHighHP implements HeroStrategy {

    @Override
    public void chooseStrategy(Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        if (maxHp / 7 < hero.getHp() && hero.getHp() < maxHp / 5) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / 7) {
            lowHP(hero);
        }
    }

    /**
     * dacă (1/7 * MAX_LEVEL_HP) < CURRENT_HP < (1/5 * MAX_LEVEL_HP)
     * el va renunța la 1/7 din HP-ul curent și va crește coeficienții cu 40%
     */
    private void highHP(Hero hero) {
        hero.subHP(hero.getHp() / 7);
        hero.angelModifier += 0.4f;
    }

    /**
     * dacă CURRENT_HP < (1/7 * MAX_LEVEL_HP),
     * el va renunța la 10% din coeficienți și va primi 1/2 din HP-ul curent
     */
    private void lowHP(Hero hero) {
        hero.angelModifier -= 0.1f;
        hero.subHP(-hero.getHp()/2);
    }
}
