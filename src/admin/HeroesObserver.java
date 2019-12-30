package admin;

import common.Observer;
import heroes.Hero;

import java.io.BufferedWriter;
import java.io.IOException;

public class HeroesObserver implements Observer {
    private BufferedWriter bw;

    public HeroesObserver(final BufferedWriter bw) {
        this.bw = bw;
    }

    /**
     * When a hero reaches another level.
     * @param hero - the player.
     */
    @Override
    public void update(final Object hero) throws IOException {
        bw.write(((Hero) hero).getType() + " " + ((Hero) hero).getID()
                + " reached level " + ((Hero) hero).getLvl());
        bw.newLine();
    }

    /**
     * When a hero is defeated in a fight.
     * @param hero1 - one fighter.
     * @param hero2 - the other fighter.
     */
    @Override
    public void update(final Object hero1, final Object hero2) throws IOException {
        updateIfDead((Hero) hero1, (Hero) hero2);
        updateIfDead((Hero) hero2, (Hero) hero1);
    }

    /**
     * Checks if a hero is defeated in a fight.
     * @param defeated - the hero that died.
     * @param attacker - the hero that killed the other one.
     */
    private void updateIfDead(final Hero defeated, final Hero attacker) throws IOException {
        if (defeated.isDead()) {
            bw.write("Player " + defeated.getType() + " " + defeated.getID()
                    + " was killed by " + attacker.getType() + " " + attacker.getID());
            bw.newLine();
        }
    }
}
