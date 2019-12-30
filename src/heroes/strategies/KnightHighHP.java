package heroes.strategies;

import heroes.Hero;

public class KnightHighHP implements HeroStrategy{

    /**
     * if his current hp is between 1/3 and 1/2 of his max hp,
     * he gives up on 1/5 of his current hp and adds 50% to his modifiers.
     * @param hero - who applies this strategy.
     */
    @Override
    public void applyStrategy(Hero hero) {
        hero.subHP(hero.getHp() / 5);
        hero.angelModifier += 0.5f;
    }
}
