package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        Matcher m = new And(
                new HasAtLeast(40, "points"),
                new Or(
                        new PlaysIn("NYR"),
                        new PlaysIn("NYI"),
                        new PlaysIn("BOS")
                )
        );
        Matcher e = new And( new All(new HasAtLeast(5, "goals"),
                new HasAtLeast(5, "assists"))
        , new PlaysIn("PHI"));

        Matcher s = new And(
                new Not( new HasAtLeast(1, "goals") ),
                new PlaysIn("NYR")
        );
        Matcher t = new Or( new HasAtLeast(30, "goals"),
                new HasAtLeast(50, "assists")
        );

        QueryBuilder query = new QueryBuilder();
        Matcher m = query.build();

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
