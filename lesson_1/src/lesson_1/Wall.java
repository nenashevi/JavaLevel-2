package lesson_1;

public class Wall implements Obstacle {
    int height;

    public  Wall () {

    }
    public  Wall (int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void useObstacle(Competitor c) {
        c.jump(height);
    }

    @Override
    public void ObstacleInfo() {
        System.out.println("Jumping over the wall of " + height + " meters");
    }
}
