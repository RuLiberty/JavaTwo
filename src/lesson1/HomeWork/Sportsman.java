package lesson1.HomeWork;

public class Sportsman {
    private String name;
    private double maxDistance;
    private double heightJump;
    private boolean lastResultCourse = true; // default value


     Sportsman(String name, double maxDistance, double heightJump) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.heightJump = heightJump;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean getLastResultCourse() {
        return lastResultCourse;
    }

    public void setLastResultCourse(boolean lastResultCourse) {
        this.lastResultCourse = lastResultCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeightJump() {
        return heightJump;
    }

    public void setHeightJump(double heightJump) {
        this.heightJump = heightJump;
    }
}
