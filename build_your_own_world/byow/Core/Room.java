package byow.Core;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

public class Room {
    private int x;
    private int y;
    private int halfWidth;
    private int halfHeight;

    public Room(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.halfWidth = w;
        this.halfHeight = h;
    }

    public int lowerBound() {
        return y - halfHeight;
    }

    public int upperBound() {
        return y + halfHeight;
    }

    public int leftBound() {
        return x - halfWidth;
    }

    public int rightBound() {
        return x + halfWidth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void drawRoom(TETile[][] world) {
        // wall
        for (int i = x - halfWidth; i <= x + halfWidth; i++) {
            for (int k = y - halfHeight; k <= y + halfHeight; k++) {
                world[i][k] = Tileset.WALL;
            }
        }

        for (int i = x - halfWidth + 1; i < x + halfWidth; i++) {
            for (int k = y - halfHeight + 1; k < y + halfHeight; k++) {
                world[i][k] = Tileset.FLOOR;
            }
        }
    }

}
