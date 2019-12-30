package heroes.strategies;

import heroes.Hero;

public class KnightStrategy implements HeroStrategy {

    @Override
    public final void chooseStrategy(final Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        final int maxLimit = 2;
        final int minLimit = 3;
        if (maxHp / minLimit < hero.getHp() && hero.getHp() < maxHp / maxLimit) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / minLimit) {
            lowHP(hero);
        }
    }

    /**
     * if his current hp is between 1/3 and 1/2 of his max hp,
     * he gives up on 1/5 of his current hp and adds 50% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void highHP(final Hero hero) {
        final int percentHP = 5;
        final float modifier = 0.5f;
        hero.subHP(hero.getHp() / percentHP);
        hero.angelModifier += modifier;
    }

    /**
     * if his current hp is smaller than 1/3 of his max hp,
     * he gets an extra of 1/4 of his current hp and decreases 20% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void lowHP(final Hero hero) {
        final int percentHP = 4;
        final float modifier = 0.2f;
        hero.angelModifier -= modifier;
        hero.subHP(-hero.getHp() / percentHP);
    }
}
