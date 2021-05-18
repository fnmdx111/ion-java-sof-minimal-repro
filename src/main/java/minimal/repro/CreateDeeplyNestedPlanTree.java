package minimal.repro;

public class CreateDeeplyNestedPlanTree {
    private final int depth;

    CreateDeeplyNestedPlanTree(int depth) {
        this.depth = depth;
    }

    Plan create(int currentDepth) {
        if (currentDepth >= depth) {
            return new PlanLeaf("leaf", currentDepth + "");
        } else {
            Plan child = create(currentDepth + 1);
            return new PlanBranch(child, child, "branch");
        }
    }
}
