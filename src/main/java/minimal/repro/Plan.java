package minimal.repro;

import com.amazon.ion.IonSexp;

public interface Plan {
    void serializeInto(IonSexp sexp);
}
