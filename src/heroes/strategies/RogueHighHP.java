package heroes.strategies;

import heroes.Hero;

public class RogueHighHP implements HeroStrategy {
    /**
     * dacă (1/7 * MAX_LEVEL_HP) < CURRENT_HP < (1/5 * MAX_LEVEL_HP)
     * el va renunța la 1/7 din HP-ul curent și va crește coeficienții cu 40%
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.subHP(hero.getHp() / 7);
//        hero.subHP(Math.round(hero.getHp() / 7f));

//        hero.getModifiers().incDamageModifiers(0.4f);
        hero.angelModifier += 0.4f;
    }
}
