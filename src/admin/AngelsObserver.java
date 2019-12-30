package admin;

import angels.Angel;
import angels.AngelType;
import common.Observer;
import heroes.Hero;

import java.io.BufferedWriter;

public class AngelsObserver implements Observer {
    private BufferedWriter bw;

    public AngelsObserver(final BufferedWriter bw) {
        this.bw = bw;
    }

    /**
     * Notified when an angel is placed on the map.
     * @param angel - the angel that was placed on the map.
     */
    @Override
    public void update(final Object angel) {
        try {
            bw.write("Angel " + ((Angel) angel).getType() + " was spawned at "
                    + ((Angel) angel).getX() + ' ' + ((Angel) angel).getY());
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Notified when there is an angel and a hero on the same spot of the map.
     * @param angel - the angel.
     * @param hero - the hero.
     */
    @Override
    public void update(final Object angel, final Object hero) {
        try {
            if (((Angel) angel).isGood()) {
                bw.write(((Angel) angel).getType() + " helped " + ((Hero) hero).getType()
                        + ' ' + ((Hero) hero).getID());
                bw.newLine();
                if (!((Hero) hero).isDead() && ((Angel) angel).getType() == AngelType.Spawner) {
                    bw.write("Player " + ((Hero) hero).getType() + ' ' + ((Hero) hero).getID()
                            + " was brought to life by an angel");
                    bw.newLine();
                }

            } else {
                bw.write(((Angel) angel).getType() + " hit " + ((Hero) hero).getType() + ' '
                        + ((Hero) hero).getID());
                bw.newLine();
                if (((Hero) hero).isDead()) {
                    bw.write("Player " + ((Hero) hero).getType() + ' ' + ((Hero) hero).getID()
                            + " was killed by an angel");
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
