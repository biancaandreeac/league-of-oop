package common;

import java.io.IOException;

/**
 * Design pattern used by heroes.
 */
public interface Visitable {
    void accept(Visitor visitor) throws IOException;
}
