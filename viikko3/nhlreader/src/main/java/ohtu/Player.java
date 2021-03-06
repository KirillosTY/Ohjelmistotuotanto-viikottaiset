
package ohtu;

public class Player {

    public Player(String name, String nationality, int assists, int goals, int penalties, String team, int games) {
        this.name = name;
        this.nationality = nationality;
        this.assists = assists;
        this.goals = goals;
        this.penalties = penalties;
        this.team = team;
        this.games = games;
    }

    private String name;

    private String nationality;

    private int assists;

    private int goals;

    private int penalties;

    private String team;

    private int games;



    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+" "+nationality+" "+goals+" + "+assists+" = "+(goals+assists);
    }


}
// {"name":"Travis
// Zajac","nationality":"CAN","assists":12,"goals":8,"penalties":6,"team":"NYI","games":46}