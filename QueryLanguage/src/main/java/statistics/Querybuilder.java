
package statistics;

import statistics.matcher.*;

public class Querybuilder {
    
    private Matcher matcher;

    public Querybuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher m = matcher;
        matcher = new All();
        return m;
    }
    
    public Querybuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }
    
    public Querybuilder hasAtLeast(int amount, String condition) {
        this.matcher = new And(this.matcher, new HasAtLeast(amount, condition));
        return this;
    }
    
    public Querybuilder hasFewerThan(int amount, String condition) {
        this.matcher = new And(this.matcher, new HasFewerThan(amount, condition));
        return this;
    }
    
    public Querybuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public Querybuilder or(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public Querybuilder not(Matcher matcher) {
        this.matcher = new And(this.matcher, new Not(matcher));
        return this;
    }
    
}
