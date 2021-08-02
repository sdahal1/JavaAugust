import java.util.Date;


public class SportAnnouncer {

    public String announceGameDay(String team1, String team2){
        // return f"Today we have a matchup betweent {team1} and {team2}"
        Date gameday = new Date();
        return String.format("Today, which is %s we have a matchup between %s and %s", gameday, team1, team2);
    }




}



