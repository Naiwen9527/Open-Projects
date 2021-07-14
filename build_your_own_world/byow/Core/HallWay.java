package byow.Core;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

public class HallWay {
    private int x;
    private int y;
    private boolean vertical;

    public HallWay(int x, int y, boolean vertical) {
        if (vertical) {
            this.vertical = true;
            this.x = x;
            this.y = y;
        }
        if (!vertical) {
            this.vertical = false;
            this.y = y;
        }
    }

    public int getXY() {
        if (vertical) {
            return x;
        }
        return y;
    }

    public int getTop() {
        if (vertical) {
            return y;
        }
        return -1;
    }

    public void drawVertical(TETile[][] world, int x, int top, int bottom) {
        world[x - 1][top] = Tileset.WALL;
        world[x][top] = Tileset.WALL;
        world[x + 1][top] = Tileset.WALL;
        for (int y = top - 1; y > bottom; y--) {
            world[x][y] = Tileset.FLOOR;
            if (world[x - 1][y] == Tileset.NOTHING) {
                world[x - 1][y] = Tileset.WALL;
            }
            if (world[x + 1][y] == Tileset.NOTHING) {
                world[x + 1][y] = Tileset.WALL;
            }
        }
        /**
        world[x - 1][bottom] = Tileset.WALL;
        world[x][bottom] = Tileset.WALL;
        world[x + 1][bottom] = Tileset.WALL;

         */
    }

    public void drawHorizontal(TETile[][] world, int y, int left, int right) {
        world[left][y + 1] = Tileset.WALL;
        world[left][y] = Tileset.WALL;
        world[left][y - 1] = Tileset.WALL;
        for (int x = left + 1; x < right; x++) {
            world[x][y] = Tileset.FLOOR;
            if (world[x][y + 1] == Tileset.NOTHING) {
                world[x][y + 1] = Tileset.WALL;
            }
            if (world[x][y - 1] == Tileset.NOTHING) {
                world[x][y - 1] = Tileset.WALL;
            }
        }
        world[right][y + 1] = Tileset.WALL;
        world[right][y] = Tileset.WALL;
        world[right][y - 1] = Tileset.WALL;
    }
}
