package abilities;

import heros.HeroType;

import java.util.HashMap;
import java.util.Map;

public final class AbilityFactory {
    private static AbilityFactory instance = null;

    private static class DMG {
        static final int DMG_FIREBLAST = 350;
        static final int DMG_IGNITE = 150;
        static final int DMG_EXECUTE = 200;
        static final int DMG_SLAM = 100;
        static final int DMG_DRAIN = 20;
        static final int DMG_DEFLECT = 35;
        static final int DMG_BACKSTAB = 200;
        static final int DMG_PARALYSIS = 40;
    }
    private static class LvlDMG {
        static final int LvlDMG_FIREBLAST = 50;
        static final int LvlDMG_IGNITE = 20;
        static final int LvlDMG_EXECUTE = 100;
        static final int LvlDMG_SLAM = 40;
        static final int LvlDMG_DRAIN = 5;
        static final int LvlDMG_DEFLECT = 2;
        static final int LvlDMG_BACKSTAB = 20;
        static final int LvlDMG_PARALYSIS = 10;
    }

    private static class LangAmplifier {
        static final float land_FIREBLAST = 1.25f;
        static final float land_IGNITE = 1.25f;
        static final float land_EXECUTE = 1.15f;
        static final float land_SLAM = 1.15f;
        static final float land_DRAIN = 1.1f;
        static final float land_DEFLECT = 1.1f;
        static final float land_BACKSTAB = 1.15f;
        static final float land_PARALYSIS = 1.15f;
    }

    public static class RaceAmplifier {
        static final Map<HeroType, Float> raceAmplifierFireblast
                = create(0.8f, 1.2f,0.9f, 1.05f);

        static final Map<HeroType, Float> raceAmplifierIgnite
                = create(0.8f, 1.2f,0.9f, 1.05f);

        static final Map<HeroType, Float> raceAmplifierExecute
                = create(1.15f, 1f,1.1f, 0.8f);

        static final Map<HeroType, Float> raceAmplifierSlam
                = create(0.8f, 1.2f,0.9f, 1.05f);

        static final Map<HeroType, Float> raceAmplifierDrain
                = create(0.8f, 1.2f,0.9f, 1.05f);

        static final Map<HeroType, Float> raceAmplifierDeflect
                = create(1.2f, 1.4f,1.3f, 0f);

        static final Map<HeroType, Float> raceAmplifierBackstab
                = create(1.2f, 0.9f,1.25f, 1.25f);

        static final Map<HeroType, Float> raceAmplifierParalysis
                = create(0.9f, 0.8f,1.2f, 1.25f);

        static Map<HeroType, Float> create (float rogue, float knight, float pyromancer,
                                            float wizard) {
            Map<HeroType, Float>raceAmplifier = new HashMap<>();
            raceAmplifier.put(HeroType.Rogue, rogue);
            raceAmplifier.put(HeroType.Knight, knight);
            raceAmplifier.put(HeroType.Pyromancer, pyromancer);
            raceAmplifier.put(HeroType.Wizard, wizard);
            return  raceAmplifier;
        }
    }


    private static Map<AbilityType, Ability> abilityByType;

    private AbilityFactory() {
        abilityByType = new HashMap<>();
        initAbility();
    }

    void initAbility() {
        Ability ability;
        ability = new Fireblast(DMG.DMG_FIREBLAST, LangAmplifier.land_FIREBLAST,
                LvlDMG.LvlDMG_FIREBLAST, RaceAmplifier.raceAmplifierFireblast);
        abilityByType.put(AbilityType.Fireblast, ability);

        ability = new Fireblast(DMG.DMG_IGNITE, LangAmplifier.land_IGNITE,
                LvlDMG.LvlDMG_IGNITE, RaceAmplifier.raceAmplifierIgnite);
        abilityByType.put(AbilityType.Ignite, ability);

        ability = new Fireblast(DMG.DMG_EXECUTE, LangAmplifier.land_EXECUTE,
                LvlDMG.LvlDMG_EXECUTE, RaceAmplifier.raceAmplifierExecute);
        abilityByType.put(AbilityType.Execute, ability);

        ability = new Slam(DMG.DMG_SLAM, LangAmplifier.land_SLAM,
                LvlDMG.LvlDMG_SLAM, RaceAmplifier.raceAmplifierSlam);
        abilityByType.put(AbilityType.Slam, ability);

        ability = new Drain(DMG.DMG_DRAIN, LangAmplifier.land_DRAIN,
                LvlDMG.LvlDMG_DRAIN, RaceAmplifier.raceAmplifierDrain);
        abilityByType.put(AbilityType.Drain, ability);

        ability = new Deflect(DMG.DMG_DEFLECT, LangAmplifier.land_DEFLECT,
                LvlDMG.LvlDMG_DEFLECT, RaceAmplifier.raceAmplifierDeflect, 70);
        abilityByType.put(AbilityType.Deflect, ability);

        ability = new Backstab(DMG.DMG_BACKSTAB, LangAmplifier.land_BACKSTAB,
                LvlDMG.LvlDMG_BACKSTAB, RaceAmplifier.raceAmplifierBackstab);
        abilityByType.put(AbilityType.Backstab, ability);

        ability = new Paralysis(DMG.DMG_PARALYSIS, LangAmplifier.land_PARALYSIS,
                LvlDMG.LvlDMG_PARALYSIS, RaceAmplifier.raceAmplifierParalysis);
        abilityByType.put(AbilityType.Paralysis, ability);
    }

    public static AbilityFactory getInstance() {
        if (instance == null) {
            instance = new AbilityFactory();
        }
        return instance;
    }

    public static Ability getAbilityByType(AbilityType type) {
        return abilityByType.get(type);
    }
}
