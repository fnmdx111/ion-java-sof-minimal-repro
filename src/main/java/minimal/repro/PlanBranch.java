package minimal.repro;

import com.amazon.ion.IonSexp;

public class PlanBranch implements Plan {

    Plan left;
    Plan right;
    String name;

    public PlanBranch(Plan left, Plan right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void serializeInto(IonSexp sexp) {
        sexp.add().newSymbol(name);

        IonSexp sl = sexp.add().newEmptySexp();
        left.serializeInto(sl);

        IonSexp sr = sexp.add().newEmptySexp();
        right.serializeInto(sr);
    }

    @Override
    public String toString() {
        return "Branch{name=" + name + "\n"
                + "  left=" + left + ",\n"
                + "  right=" + right + "}";
    }
}
