package lesson1.HomeWork;

public class Team {
    private String name;
    private boolean LastResultTeam = true; // default value
    private Sportsman[] membersTeam;

    public Team(String name, Sportsman[] membersTeam) {
        this.name = name;
        this.membersTeam = membersTeam;
    }


    public boolean getLastResultTeam() {
        return LastResultTeam;
    }

    public void setLastResultTeam(boolean lastResultTeam) {
        LastResultTeam = lastResultTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sportsman[] getMembersTeam() {
        return membersTeam;
    }

    public void setMembersTeam(Sportsman[] membersTeam) {
        this.membersTeam = membersTeam;
    }

    public void showResultWinners(){
        for (Sportsman a:this.getMembersTeam()) {
          if (a.getLastResultCourse()) {
              System.out.println(a.getName() + " прошел дистанцию и не сломался");
          }
        }
    }

    public void showMembersTeam(){
        for (Sportsman a:this.getMembersTeam()) {
            System.out.println(a.getName() + (a.getLastResultCourse() ? " справилcz и прошел всю дистанцию " : " не хватило сил и выносливости :( "));
        }
    }

    public void showResults() {
        System.out.println("Результаты прохождения последней полосы препятствий: ");
        System.out.println("Команда " + this.name + (this.getLastResultTeam() ? " справилась и прошла " : " не прошла") + " полосу препятствий");
        System.out.println();
        if ((this.getLastResultTeam())) {
            this.showResultWinners();
        } else {
            this.showMembersTeam();
        }
    }
}
