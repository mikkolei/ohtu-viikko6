
package statistics.matcher;

import java.util.Arrays;
import statistics.Player;

public class Or implements Matcher {
    
    private Matcher[] matchers;
    private int amount;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
        amount = matchers.length-1;
    }

    @Override
    public boolean matches(Player p) {
        for(int i = amount; i > -1; i--) {
            if(matchers[i].matches(p)) {
                return true;
            }
        }
        return false;
    }
    
}
