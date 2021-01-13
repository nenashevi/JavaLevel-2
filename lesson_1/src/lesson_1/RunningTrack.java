package lesson_1;

public class RunningTrack implements Obstacle {
    private int distance;

    public RunningTrack() {

    }
    public RunningTrack(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void useObstacle(Competitor c) {
        c.run(distance);
    }

    @Override
    public void ObstacleInfo() {
        System.out.println("Running on " + distance + " meters");
    }
}
