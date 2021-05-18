package minimal.repro;

import com.amazon.ion.IonSexp;
import com.amazon.ion.IonSystem;
import com.amazon.ion.IonWriter;
import com.amazon.ion.system.IonSystemBuilder;
import com.amazon.ion.system.IonTextWriterBuilder;

public class Main {
    public static void main(String[] args) {
        Plan plan = new CreateDeeplyNestedPlanTree(1000).create(0);
        System.out.println("Created plan");

        IonSystem ion = IonSystemBuilder.standard().build();
        IonSexp sexp = ion.newEmptySexp();
        System.out.println("Serializing");
        plan.serializeInto(sexp);
        System.out.println("Serialized");

        StringBuilder stringBuilder = new StringBuilder();
        IonWriter writer = IonTextWriterBuilder.pretty().build(stringBuilder);
        System.out.println("Prettifying");
        sexp.writeTo(writer);
        System.out.println(stringBuilder);
    }
}
