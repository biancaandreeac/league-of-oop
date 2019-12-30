package angels;

public final class AngelFactory {
    public static Angel getAngelByType(String type) {
        if (type.equals("DamageAngel")) {
            return new DamageAngel(AngelType.DamageAngel);
        }
        if (type.equals("DarkAngel")) {
            return new DarkAngel(AngelType.DarkAngel);
        }
        if (type.equals("Dracula")) {
            return new Dracula(AngelType.Dracula);
        }
        if (type.equals("GoodBoy")) {
            return new GoodBoy(AngelType.GoodBoy);
        }
        if (type.equals("LevelUpAngel")) {
            return new LevelUpAngel(AngelType.LevelUpAngel);
        }
        if (type.equals("LifeGiver")) {
            return new LifeGiver(AngelType.LifeGiver);
        }
        if (type.equals("SmallAngel")) {
            return new SmallAngel(AngelType.SmallAngel);
        }
        if (type.equals("Spawner")) {
            return new Spawner(AngelType.Spawner);
        }
        if (type.equals("TheDoomer")) {
            return new TheDoomer(AngelType.TheDoomer);
        }
        if (type.equals("XPAngel")) {
            return new XPAngel(AngelType.XPAngel);
        }
        System.out.println("**********Type does not exist.**********");
        return null;
    }
}
