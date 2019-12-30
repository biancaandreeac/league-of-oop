package common;
import java.io.IOException;

public interface Observer {
    // For angels when they are placed
    // For heroes when the reach another level
    void update(Object obj) throws IOException;

    // For angels when they help/hit a hero
    // For heroes when they fight each other
    void update(Object obj1, Object obj2) throws IOException;
}
