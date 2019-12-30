package common;

import java.io.IOException;

/**
 * Design pattern used by the great magician.
 */
public interface Observable {
    void register(Observer o);
    void notifyObserver() throws IOException;
    void notifyObserver(Object obj) throws IOException;
}
