package heroes.strategies;

import heroes.Hero;

public class PyromancerStrategy implements HeroStrategy {
    private final int maxLimit = 3;
    private final int minLimit = 4;

    @Override
    public final void chooseStrategy(final Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        if (maxHp / minLimit < hero.getHp() && hero.getHp() < maxHp / maxLimit) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / minLimit) {
            lowHP(hero);
        }
    }

    /**
     * if his current hp is between 1/4 and 1/3 of his max hp,
     * he gives up on 1/4 of his current hp and adds 70% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void highHP(final Hero hero) {
        final float modifier = 0.7f;
        hero.subHP(hero.getHp() / minLimit);
        hero.angelModifier += modifier;
    }

    /**
     * if his current hp is smaller than 1/4 of his max hp,
     * he gets an extra of 1/3 of his current hp and decreases 30% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void lowHP(final Hero hero) {
        final float modifier = 0.3f;
        hero.angelModifier -= modifier;
        hero.subHP(-hero.getHp() / maxLimit);
    }
}
