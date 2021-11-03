package ohtuesimerkki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void nameFound() {

        assertTrue(stats.search("Semenko").getName().equals ("Semenko"));
    }

    @Test
    public void nameFoundDifferentPlaye() {

        assertFalse(stats.search("Semenko").equals(new Player("Semenko","ADD",4,0)));
    }

    @Test
    public void nameNotFound(){

        assertTrue(stats.search("Sodomia") == null);
    }

    @Test
    public void teamFound() {

        for( Player p :stats.team("EDM")){

            if(p.getTeam() != "EDM"){
                Assert.fail();
            }
        }

    }

    @Test
    public void teamNotFound() {

        assertTrue(stats.team("EDTTT").isEmpty());

    }

    @Test
    public void topScorersRightNumber() {

        assertTrue(stats.topScorers(3).size() == 4);
    }


    @Test
    public void rightPlayersAtTop() {
        List<Player> ps= stats.topScorers(2);

        for(Player p: ps){
            if(p.getPoints()< 98){
                Assert.fail();
            }
        }

    }


}
