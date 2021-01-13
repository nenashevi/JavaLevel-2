package lesson_1;

public class MainApp {
    public static void main(String[] args) {

        Competitor[] c = {new Human("Igor", 1000, 2), new Cat("Barsik", 200, 3),
                new Robot("C-3PO", 10000, 4)};
        Obstacle[] o = {new RunningTrack(200), new Wall(2), new RunningTrack(900), new Wall(2),
                new RunningTrack(1000), new Wall(3), new RunningTrack(5000), new Wall(4)};


        for(int i = 0; i < o.length; i++ ) {
            o[i].ObstacleInfo();
            for (int j = 0; j < c.length; j ++) {
                o[i].useObstacle(c[j]);
            }
            System.out.println();
        }






    }
}
