package map;

import java.util.ArrayList;

public final class Map {
    private static Map instance = null;
    private static ArrayList<ArrayList<Cell>> map;

    private Map(final ArrayList<ArrayList<Character>> map) {
        createMap(map);
    }

    private void createMap(final ArrayList<ArrayList<Character>> cells) {
        ArrayList<Cell> line = new ArrayList<>();
        map = new ArrayList<>();
        for (ArrayList<Character> lines : cells) {
            for (Character cols : lines) {
                switch (cols) {
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
                    default:
                        break;
                }
            }
            map.add(new ArrayList<>(line));
            line.clear();
        }
    }

    public static Map getInstance(final ArrayList<ArrayList<Character>> cells) {
        if (instance == null) {
            instance = new Map(cells);
        }
        return instance;
    }

    public static Cell getCellAt(final int x, final int y) {
        return map.get(x).get(y);
    }
}

