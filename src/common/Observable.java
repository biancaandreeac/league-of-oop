package common;

import java.io.IOException;

public interface Observable {
    void register(Observer o);
    void notifyObserver() throws IOException;
    void notifyObserver(Object obj) throws IOException;
}
