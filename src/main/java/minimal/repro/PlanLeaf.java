package minimal.repro;

import com.amazon.ion.IonSexp;

public class PlanLeaf implements Plan {
    String name;
    String arg;

    public PlanLeaf(String name, String arg) {
        this.name = name;
        this.arg = arg;
    }

    @Override
    public void serializeInto(IonSexp sexp) {
        sexp.add().newSymbol(name);
        sexp.add().newString(arg);
    }

    @Override
    public String toString() {
        return "Leaf{name=" + name + ", arg=" + arg + "}";
    }
}
