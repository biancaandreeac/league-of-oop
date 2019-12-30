package common;

import java.io.IOException;

public interface Visitable {
    void accept(Visitor visitor) throws IOException;
}
