package heroes.strategies;

import heroes.Hero;

public class RogueHighHP implements HeroStrategy {

    @Override
    public final void chooseStrategy(final Hero hero) {
        int maxHp = hero.getHpMax() + hero.getLvl() * hero.getHPlvl();
        final int maxLimit = 5;
        final int minLimit = 7;
        if (maxHp / minLimit < hero.getHp() && hero.getHp() < maxHp / maxLimit) {
            highHP(hero);
        } else if (hero.getHp() < maxHp / minLimit) {
            lowHP(hero);
        }
    }

    /**
     * if his current hp is between 1/7 and 1/5 of his max hp,
     * he gives up on 1/7 of his current hp and adds 40% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void highHP(final Hero hero) {
        final int hp = 7;
        final float modifier = 0.4f;
        hero.subHP(hero.getHp() / hp);
        hero.angelModifier += modifier;
    }

    /**
     * if his current hp is smaller than 1/7 of his max hp,
     * he gets an extra of 1/2 of his current hp and decreases 10% to his modifiers.
     * @param hero - who applies this strategy.
     */
    private void lowHP(final Hero hero) {
        final int hp = 2;
        final float modifier = 0.1f;
        hero.angelModifier -= modifier;
        hero.subHP(-hero.getHp() / hp);
    }
}
