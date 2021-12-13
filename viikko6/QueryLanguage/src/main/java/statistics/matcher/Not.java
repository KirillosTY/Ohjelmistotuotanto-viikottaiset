package statistics.matcher;

import statistics.Player;

import java.lang.reflect.Method;

public class Not implements Matcher{

    private int value;
    private HasAtLeast[] categories;


    public Not(HasAtLeast... categories) {
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
