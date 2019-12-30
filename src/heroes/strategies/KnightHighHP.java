package heroes.strategies;

import heroes.Hero;

public class KnightHighHP implements HeroStrategy{

    @Override
    public void chooseStrategy(Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        if (maxHp / 3 < hero.getHp() && hero.getHp() < maxHp / 2) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / 3) {
            lowHP(hero);
        }
    }

    /**
     * if his current hp is between 1/3 and 1/2 of his max hp,
     * he gives up on 1/5 of his current hp and adds 50% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void highHP(Hero hero) {
        hero.subHP(hero.getHp() / 5);
        hero.angelModifier += 0.5f;
    }

    /**
     *  dacă CURRENT_HP < (1/3 * MAX_LEVEL_HP),
     *  el va renunța la 20% din coeficienți și va primi 1/4 din HP-ul curent
     */
    private void lowHP(Hero hero) {
        hero.angelModifier -= 0.2f;
        hero.subHP(-hero.getHp() / 4);
    }
}
