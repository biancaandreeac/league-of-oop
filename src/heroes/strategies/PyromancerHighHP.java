package heroes.strategies;

import heroes.Hero;

public class PyromancerHighHP implements HeroStrategy {

    @Override
    public void chooseStrategy(Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        if (maxHp / 4 < hero.getHp() && hero.getHp() < maxHp / 3) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / 4) {
            lowHP(hero);
        }
    }

    /**
     * dacă (1/4 * MAX_LEVEL_HP) < CURRENT_HP < (1/3 * MAX_LEVEL_HP),
     * el va renunța la 1/4 din HP-ul curent și va crește coeficienții cu 70%
     */
    private void highHP(Hero hero) {
        hero.subHP(hero.getHp() / 4);
        hero.angelModifier += 0.7f;
    }

    /**
     * dacă CURRENT_HP < (1/4 * MAX_LEVEL_HP),
     * el va renunța la 30% din coeficienți și va primi 1/3 din HP-ul curent
     */
    public void lowHP(Hero hero) {
        hero.angelModifier -= 0.3f;
        hero.subHP(-hero.getHp()/3);
    }
}
