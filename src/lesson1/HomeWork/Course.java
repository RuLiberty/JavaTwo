package lesson1.HomeWork;

public class Course {

    private double[] heightBarrier;
    private double distance;

    public Course(double[] heightBarrier, double distance) {
        this.heightBarrier = heightBarrier;
        this.distance = distance;
    }

    public void doIt(Team team) {

        for (Sportsman b : team.getMembersTeam()) {
            for (double a : this.heightBarrier) {
                if (b.getHeightJump() < a)
                {
                    b.setLastResultCourse(false);
                    break;
                }
            }
        }

        for (Sportsman a:team.getMembersTeam()) {
            if (!a.getLastResultCourse())
            {
                team.setLastResultTeam(false);
                break;
            }
        }
    }

    public double[] getHeightBarrier() {
        return heightBarrier;
    }

    public void setHeightBarrier(double[] heightBarrier) {
        this.heightBarrier = heightBarrier;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
