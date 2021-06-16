package homeworks.LVL2.Lesson1.Runner;

import homeworks.LVL2.Lesson1.Barrier.Triathlon;

public class Team {

    Competitor[] competitors = new Competitor[4];
    String team_name;

    public Team( String team_name,Competitor competitor1, Competitor competitor2, Competitor competitor3, Competitor competitor4) {
        this.competitors[0] = competitor1;
        this.competitors[1] = competitor2;
        this.competitors[2] = competitor3;
        this.competitors[3] = competitor4;
        this.team_name = team_name;
    }

    public Team( String team_name,Competitor competitor1, Competitor competitor2, Competitor competitor3) {
        this.competitors[0] = competitor1;
        this.competitors[1] = competitor2;
        this.competitors[2] = competitor3;
        this.team_name = team_name;
    }

    public void start(Triathlon triathlon) {
        for (Competitor competitor : competitors) {
            if (competitor == null){
                continue;
            }
            triathlon.doIt(competitor);
        }
    }

    public void showResults(){
        for (Competitor competitor:competitors) {
            if (competitor == null){
                continue;
            }
            competitor.info();
        }
    }

}
