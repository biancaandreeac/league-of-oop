package heroes.abilities;

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
        static final int LVL_DMG_FIREBLAST = 50;
        static final int LVL_DMG_IGNITE = 20;
        static final int LVL_DMG_EXECUTE = 100;
        static final int LVL_DMG_SLAM = 40;
        static final int LVL_DMG_DRAIN = 5;
        static final int LVL_DMG_DEFLECT = 2;
        static final int LVL_DMG_BACKSTAB = 20;
        static final int LVL_DMG_PARALYSIS = 10;
    }

    private static class LangAmplifier {
        static final float LAND_FIREBLAST = 1.25f;
        static final float LAND_IGNITE = 1.25f;
        static final float LAND_EXECUTE = 1.15f;
        static final float LAND_SLAM = 1.15f;
        static final float LAND_DRAIN = 1.1f;
        static final float LAND_DEFLECT = 1.1f;
        static final float LAND_BACKSTAB = 1.15f;
        static final float LAND_PARALYSIS = 1.15f;
    }

    private static Map<AbilityType, Ability> abilityByType;

    private AbilityFactory() {
        abilityByType = new HashMap<>();
        initAbility();
    }

    private void initAbility() {
        Ability ability;
        ability = new Fireblast(DMG.DMG_FIREBLAST, LangAmplifier.LAND_FIREBLAST,
                LvlDMG.LVL_DMG_FIREBLAST);
        abilityByType.put(AbilityType.Fireblast, ability);

        ability = new Ignite(DMG.DMG_IGNITE, LangAmplifier.LAND_IGNITE,
                LvlDMG.LVL_DMG_IGNITE);
        abilityByType.put(AbilityType.Ignite, ability);

        ability = new Execute(DMG.DMG_EXECUTE, LangAmplifier.LAND_EXECUTE,
                LvlDMG.LVL_DMG_EXECUTE);
        abilityByType.put(AbilityType.Execute, ability);

        ability = new Slam(DMG.DMG_SLAM, LangAmplifier.LAND_SLAM,
                LvlDMG.LVL_DMG_SLAM);
        abilityByType.put(AbilityType.Slam, ability);

        ability = new Drain(DMG.DMG_DRAIN, LangAmplifier.LAND_DRAIN,
                LvlDMG.LVL_DMG_DRAIN);
        abilityByType.put(AbilityType.Drain, ability);

        ability = new Deflect(DMG.DMG_DEFLECT, LangAmplifier.LAND_DEFLECT,
                LvlDMG.LVL_DMG_DEFLECT);
        abilityByType.put(AbilityType.Deflect, ability);

        ability = new Backstab(DMG.DMG_BACKSTAB, LangAmplifier.LAND_BACKSTAB,
                LvlDMG.LVL_DMG_BACKSTAB);
        abilityByType.put(AbilityType.Backstab, ability);

        ability = new Paralysis(DMG.DMG_PARALYSIS, LangAmplifier.LAND_PARALYSIS,
                LvlDMG.LVL_DMG_PARALYSIS);
        abilityByType.put(AbilityType.Paralysis, ability);
    }

    public static Ability getAbilityByType(final AbilityType type) {
        if (instance == null) {
            instance = new AbilityFactory();
        }
        return abilityByType.get(type);
    }
}
