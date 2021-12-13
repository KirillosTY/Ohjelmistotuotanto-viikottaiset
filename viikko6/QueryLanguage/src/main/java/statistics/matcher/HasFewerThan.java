package statistics.matcher;

import statistics.Player;
import statistics.matcher.HasAtLeast;
import statistics.matcher.Matcher;

import javax.net.ssl.SSLEngineResult;
import java.lang.reflect.Method;

public class HasFewerThan implements Matcher {

    private int value;
    private HasAtLeast[] categories;


    public HasFewerThan(HasAtLeast... categories) {
        this.value = value;
        this.categories = categories;
    }


    @Override
    public boolean matches(Player p) {

        boolean foundAll = true;
        for(HasAtLeast has: categories){
            if(has.matches(p)){
                foundAll = false;
            }
        }

        return foundAll;



    }
}
