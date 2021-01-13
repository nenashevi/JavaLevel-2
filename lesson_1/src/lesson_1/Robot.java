package lesson_1;

public class Robot implements Competitor {
    private String name;
    private int maxDistance;
    private int maxHeight;
    private  boolean fault = false;

    public Robot () {

    }
    public Robot (String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    public int getMaxDistance() {
        return maxDistance;
    }
    public int getMaxHeight() {
        return maxHeight;
    }

    public String getName() {
        return name;
    }
    public boolean isFault() {
        return fault;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setFault(boolean fault) {
        this.fault = fault;
    }

    @Override
    public boolean run(int distance) {
        if (fault == true) return false;
        if (distance <= maxDistance) {
            System.out.println("Robot " + name + " has run distance " + distance + " meters");
            return true;
        }
        if (distance > maxDistance) {
            System.out.println("Robot " + name + " hasn't run distance " + distance + " meters. It is too long distance");
            fault = true;
            return false;
        }
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (fault == true) return false;
        if (height <= maxHeight) {
            System.out.println("Robot " + name + " has jumped over the wall of " + height + " meters");
            return true;
        }
        if (height > maxHeight) {
            System.out.println("Robot " + name + " hasn't jumped over the wall of " + height + " meters. It is too high wall");
            fault = true;
            return true;
        }
        return false;
    }
}
