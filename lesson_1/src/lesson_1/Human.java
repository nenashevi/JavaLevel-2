package lesson_1;

public class Human implements Competitor {
    private String name;
    private int maxDistance;
    private int maxHeight;
    private  boolean fault = false;

    public Human () {

    }
    public Human (String name, int maxDistance, int maxHeight) {
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
            System.out.println("Human " + name + " have run distance " + distance + " meters");
            return true;
        }
        if (distance > maxDistance) {
            System.out.println("Human " + name + " haven't run distance " + distance + " meters. It is too long distance");
            fault = true;
            return false;
        }
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (fault == true) return false;
        if (height <= maxHeight) {
            System.out.println("Human " + name + " have jumped over the wall of " + height + " meters");
            return true;
        }
        if (height > maxHeight) {
            System.out.println("Human " + name + " haven't jumped over the wall of " + height + " meters. It is too high wall");
            fault = true;
            return false;
        }
        return false;
    }
}
