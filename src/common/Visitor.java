package common;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public interface Visitor {
    void visit(Knight knight) throws IOException;
    void visit(Pyromancer pyromancer) throws IOException;
    void visit(Rogue rogue) throws IOException;
    void visit(Wizard wizard) throws IOException;
}
