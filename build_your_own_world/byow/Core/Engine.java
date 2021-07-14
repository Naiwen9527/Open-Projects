package byow.Core;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.*;

public class Engine {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private HashSet<Room> rooms = new HashSet<>();
    private ArrayList<HallWay> halls = new ArrayList<>();


    /**
     * Method used for exploring a fresh world. This method should handle all inputs,
     * including inputs from the main menu.
     */
    public void interactWithKeyboard() {
    }

    /**
     * Method used for autograding and testing your code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The engine should
     * behave exactly as if the user typed these characters into the engine using
     * interactWithKeyboard.
     *
     * Recall that strings ending in ":q" should cause the game to quite save. For example,
     * if we do interactWithInputString("n123sss:q"), we expect the game to run the first
     * 7 commands (n123sss) and then quit and save. If we then do
     * interactWithInputString("l"), we should be back in the exact same state.
     *
     * In other words, both of these calls:
     *   - interactWithInputString("n123sss:q")
     *   - interactWithInputString("lww")
     *
     * should yield the exact same world state as:
     *   - interactWithInputString("n123sssww")
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] interactWithInputString(String input) {
        // TODO: Fill out this method so that it run the engine using the input
        // passed in as an argument, and return a 2D tile representation of the
        // world that would have been drawn if the same inputs had been given
        // to interactWithKeyboard().
        //
        // See proj3.
        // byow.InputDemo for a demo of how you can make a nice clean interface
        // that works for many different input types.

        TETile[][] finalWorldFrame = null;
        int seed = Integer.valueOf(input);
        Random r = new Random(seed);
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        finalWorldFrame = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                finalWorldFrame[x][y] = Tileset.NOTHING;
            }
        }


        generateRooms(r, finalWorldFrame);
        connect(finalWorldFrame, r);

        ter.renderFrame(finalWorldFrame);

        return finalWorldFrame;
    }

    private void generateRooms(Random r, TETile[][] world) {
        int numTiles = 0;
        double rate = 0;
        while (rate < 0.4) {
            int w = RandomUtils.uniform(r, 3, 8);
            int h = RandomUtils.uniform(r, 3, 8);
            int x = RandomUtils.uniform(r, 5, WIDTH - 5);
            int y = RandomUtils.uniform(r, 5, HEIGHT - 5);
            if (inRange(x, y, w, h)) {
                if (!overlap(world, x, y, w, h)) {
                    Room newRoom = new Room(x, y, w, h);
                    rooms.add(newRoom);
                    newRoom.drawRoom(world);
                    numTiles += (w * 2) * (h * 2);
                    rate = (double) numTiles / (double) (WIDTH * HEIGHT);
                }
            }
        }
    }

    private boolean inRange(int x, int y, int w, int h) {
        if ((x + w < WIDTH) && (x - w > 0)) {
            if ((y + h < HEIGHT) && (y - h > 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean overlap(TETile[][] world, int x, int y, int w, int h) {
        for (int i = x - w; i <= x + w; i++) {
            for (int k = y - h; k <= y + h; k++) {
                if (world[i][k] != Tileset.NOTHING) {
                    return true;
                }
            }
        }
        return false;
    }

    private void connect(TETile[][] world, Random r) {
        int top = HEIGHT / 2;
        int bottom = HEIGHT / 2;
        int left = WIDTH / 2;
        int right = WIDTH / 2;
        int hope = 0;
        // get top and bottom
        for (Room room : rooms) {
            if (room.upperBound() > top) {
                top = room.upperBound();
            }
            if (room.lowerBound() < bottom) {
                bottom = room.lowerBound();
            }
        }
        // get left and right
        for (Room room : rooms) {
            if (room.leftBound() < left) {
                left = room.leftBound();
            }
            if (room.rightBound() > right) {
                right = room.rightBound();
            }
        }
        // get my last hope
        for (Room room : rooms) {
            if (room.lowerBound() > hope) {
                hope = room.lowerBound();
            }
        }
        // deploy vertical hallways
        for (Room room : rooms) {
            HallWay hall = new HallWay(room.getX(), top, true);
            halls.add(hall);
            hall.drawVertical(world, hall.getXY(), top, room.lowerBound());
        }
        // conclude the map with a horizontal hallway
        int height = RandomUtils.uniform(r, hope + 1, top - 1);
        HallWay avenue = new HallWay(0, height, false);
        avenue.drawHorizontal(world, avenue.getXY(), left, right);
        int disguise = RandomUtils.uniform(r, bottom + 1, top - 1);
        int dis1 = disguise / 2;
        avenue.drawHorizontal(world, top - 1, left + dis1, right - dis1);
        //trimHallWays(r, world, height);
    }

    private void trimHallWays(Random r, TETile[][] world, int bottomLine) {
        int index = 0;
        for (Room room : rooms) {
            HallWay fitted = halls.get(index);
            if (room.upperBound() < bottomLine) {
                int max = fitted.getTop() - bottomLine - 1;
                int trimLength = RandomUtils.uniform(r, 0, max);
                trimHelper(world, room.getX(), fitted.getTop(), trimLength);
            }
            index += 1;
        }
    }

    private void trimHelper(TETile[][] world, int x, int y, int trimLength) {
        int curr = y;
        int countDown = trimLength;
        while (countDown > 0) {
            world[x - 1][curr] = Tileset.NOTHING;
            world[x][curr] = Tileset.NOTHING;
            world[x + 1][curr] = Tileset.NOTHING;
            curr -= 1;
        }
        world[x - 1][curr] = Tileset.WALL;
        world[x][curr] = Tileset.WALL;
        world[x + 1][curr] = Tileset.WALL;
    }

    public static void main(String[] args) {
        Engine test = new Engine();
        test.interactWithInputString("2038724");
    }
}
