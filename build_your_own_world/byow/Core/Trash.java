package byow.Core;

import java.util.Random;

public class Trash {
    /*
    // add a point on each side of the given Vertical Node
    private void pointsGeneratorVer(Random r, Node given, KDTree tree) {
        if (given.depth < 2) {
            int limiterH = HEIGHT / 4;
            // right side
            int x1 = (WIDTH - given.x) / 2;
            int y1 = RandomUtils.uniform(r, HEIGHT - limiterH);
            tree.add(new Point(x1, y1));
            // left side
            int x2 = given.x / 2;
            int y2 = RandomUtils.uniform(r, HEIGHT - limiterH);
            tree.add(new Point(x2, y2));
        } else {
            if (given.y > given.parent.y) { // upper
                int limiterH = (HEIGHT - given.parent.y) / 4;
                // right side
                int x1 = (WIDTH - given.x) / 2;
                int boundL = (HEIGHT - given.parent.y) - limiterH;
                int boundR = given.parent.y + limiterH;
                int y1 = RandomUtils.uniform(r, boundL, boundR);
                tree.add(new Point(x1, y1));
                // left side
                int x2 = (given.x - given.parent.parent.x) / 2;
                int y2 = RandomUtils.uniform(r, boundL, boundR);
                tree.add(new Point(x2, y2));
            }
            if (given.y < given.parent.y) { // lower
                int limiterH = (given.parent.y) / 4;
                // right side
                int x1 = (WIDTH - given.x) / 2;
                int y1 = RandomUtils.uniform(r, given.parent.y - limiterH);
                tree.add(new Point(x1, y1));
                // left side
                int x2 = (given.x - given.parent.parent.x) / 2;
                int y2 = RandomUtils.uniform(r, given.parent.y - limiterH);
                tree.add(new Point(x2, y2));
            }

        }

    }

    private void pointsGeneratorHor(Random r, Node given, KDTree tree) {
        if (given.depth < 2) {
            int limiterH = HEIGHT / 4;
            // right side
            int x1 = (WIDTH - given.x) / 2;
            int y1 = RandomUtils.uniform(r, HEIGHT - limiterH);
            tree.add(new Point(x1, y1));
            // left side
            int x2 = given.x / 2;
            int y2 = RandomUtils.uniform(r, HEIGHT - limiterH);
            tree.add(new Point(x2, y2));
        } else {
            if (given.y > given.parent.y) { // upper
                int limiterH = (HEIGHT - given.parent.y) / 4;
                // right side
                int x1 = (WIDTH - given.x) / 2;
                int boundL = (HEIGHT - given.parent.y) - limiterH;
                int boundR = given.parent.y + limiterH;
                int y1 = RandomUtils.uniform(r, boundL, boundR);
                tree.add(new Point(x1, y1));
                // left side
                int x2 = (given.x - given.parent.parent.x) / 2;
                int y2 = RandomUtils.uniform(r, boundL, boundR);
                tree.add(new Point(x2, y2));
            }
            if (given.y < given.parent.y) { // lower
                int limiterH = (given.parent.y) / 4;
                // right side
                int x1 = (WIDTH - given.x) / 2;
                int y1 = RandomUtils.uniform(r, given.parent.y - limiterH);
                tree.add(new Point(x1, y1));
                // left side
                int x2 = (given.x - given.parent.parent.x) / 2;
                int y2 = RandomUtils.uniform(r, given.parent.y - limiterH);
                tree.add(new Point(x2, y2));
            }

        }
    }*/
}
