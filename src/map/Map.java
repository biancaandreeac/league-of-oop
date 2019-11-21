package map;

import java.util.ArrayList;

public class Map {
    private static Map instance = null;
    private int lines, cols;
    private static ArrayList<ArrayList<Cell>> map;

    private Map (int lines, int cols, ArrayList<ArrayList<Character>> map) {
        this.lines = lines;
        this.cols = cols;
        createMap(map);
    }

    private void createMap(ArrayList<ArrayList<Character>> mapT) {
        ArrayList<Cell> line = new ArrayList<>();
        map = new ArrayList<>();
        for (ArrayList<Character> lines : mapT) {
            for (Character c : lines) {
                switch (c) {
                    case 'W':
                        line.add(new Cell(CellType.Woods));
                        break;
                    case 'L':
                        line.add(new Cell(CellType.Land));
                        break;
                    case 'V':
                        line.add(new Cell(CellType.Volcanic));
                        break;
                    case 'D':
                        line.add(new Cell(CellType.Desert));
                        break;
                }
            }
            map.add(new ArrayList<>(line));
            line.clear();
        }
    }

    public static Map getInstance(int lines, int cols, ArrayList<ArrayList<Character>> map) {
        if (instance == null) {
            instance = new Map(lines, cols, map);
        }
        return instance;
    }

    public static Cell getCellAt(int x, int y) {
        return map.get(x).get(y);
    }
}

