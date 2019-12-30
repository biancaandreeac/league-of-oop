package game;

import angels.Angel;
import angels.AngelFactory;

import java.util.ArrayList;

class AngelsInput {
    private int noOfAngels;
    private ArrayList<Angel> angels;
    private ArrayList<Integer> coordinates;

    AngelsInput() {
        noOfAngels = 0;
        angels = new ArrayList<>();
        coordinates = new ArrayList<>();
    }

    // Create an angel based on the characteristics.
    void addAngel(final String name, final int x, final int y) {
        noOfAngels++;
        angels.add(AngelFactory.getAngelByType(name));
        coordinates.add(x);
        coordinates.add(y);
    }

    int getNoOfAngels() {
        return noOfAngels;
    }

    Angel getAngel(final int index) {
        return angels.get(index);
    }

    int getX(final int index) {
        return coordinates.get(index * 2);
    }

    int getY(final int index) {
        return coordinates.get(index * 2 + 1);
    }

}
