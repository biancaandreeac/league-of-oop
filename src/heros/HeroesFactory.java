package heros;

import heros.abilities.AbilityType;

import java.util.*;

public final class HeroesFactory {
    private static HeroesFactory instance = null;

    private static class HitPoints {
        static final int HP_PYROMANCER = 500;
        static final int HP_KNIGHT = 900;
        static final int HP_WIZARD = 400;
        static final int HP_ROGUE = 600;
    }

    private static class HitPointsPerLevel {
        static final int HP_LVL_PYROMANCER = 50;
        static final int HP_LVL_KNIGHT = 80;
        static final int HP_LVL_WIZARD = 30;
        static final int HP_LVL_ROGUE = 40;
    }

    private static class Abilities {
        static final ArrayList<AbilityType> AB_PYROMANCER = new ArrayList<>
                (Arrays.asList(AbilityType.Fireblast, AbilityType.Ignite));
        static final ArrayList<AbilityType> AB_KNIGHT = new ArrayList<>
                (Arrays.asList(AbilityType.Execute, AbilityType.Slam));
        static final ArrayList<AbilityType> AB_WIZARD = new ArrayList<>
                (Arrays.asList(AbilityType.Drain, AbilityType.Deflect));
        static final ArrayList<AbilityType> AB_ROGUE = new ArrayList<>
                (Arrays.asList(AbilityType.Backstab, AbilityType.Paralysis));
    }

    private static Map<HeroType, Hero> heroByType;

    private HeroesFactory() {
        heroByType = new HashMap<>();
        initHeroes();
    }

    private void initHeroes() {
        Hero hero;
        hero = new Pyromancer(HitPoints.HP_PYROMANCER, HitPointsPerLevel.HP_LVL_PYROMANCER,
                    HeroType.Pyromancer, Abilities.AB_PYROMANCER);
        heroByType.put(HeroType.Pyromancer, hero);

        hero = new Knight(HitPoints.HP_KNIGHT, HitPointsPerLevel.HP_LVL_KNIGHT,
                HeroType.Knight, Abilities.AB_KNIGHT);
        heroByType.put(HeroType.Knight, hero);

        hero = new Wizard(HitPoints.HP_WIZARD, HitPointsPerLevel.HP_LVL_WIZARD,
                HeroType.Wizard, Abilities.AB_WIZARD);
        heroByType.put(HeroType.Wizard, hero);

        hero = new Rogue(HitPoints.HP_ROGUE, HitPointsPerLevel.HP_LVL_ROGUE,
                HeroType.Rogue, Abilities.AB_ROGUE);
        heroByType.put(HeroType.Rogue, hero);
    }

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    public static Hero getHeroByType(final HeroType type) {
        return heroByType.get(type);
    }

    public static Hero getHeroByType(final char type) {
        switch (type) {
            case 'P':
                return new Pyromancer(HitPoints.HP_PYROMANCER, HitPointsPerLevel.HP_LVL_PYROMANCER,
                        HeroType.Pyromancer, Abilities.AB_PYROMANCER);
            case 'K':
                return new Knight(HitPoints.HP_KNIGHT, HitPointsPerLevel.HP_LVL_KNIGHT,
                        HeroType.Knight, Abilities.AB_KNIGHT);
            case 'W':
                return new Wizard(HitPoints.HP_WIZARD, HitPointsPerLevel.HP_LVL_WIZARD,
                        HeroType.Wizard, Abilities.AB_WIZARD);
            case 'R':
                return new Rogue(HitPoints.HP_ROGUE, HitPointsPerLevel.HP_LVL_ROGUE,
                        HeroType.Rogue, Abilities.AB_ROGUE);
        }
        return null;
    }
}
