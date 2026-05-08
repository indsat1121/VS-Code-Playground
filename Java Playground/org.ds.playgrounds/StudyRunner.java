public class StudyRunner {
    private static final String[] RUNNER_CLASSES = {
        "ArrayFunctions",
        "ArrayListFunctions",
        "LinkedListFunctions",
        "StringFunctions",
        "HashMapFunctions",
        "HashSetFunctions",
        "ReverseString",
        "StackDequeueFunctions",
        "TreeFunctions",
        "RecursionBasics",
        "GraphTraversalBasics",
        "QueueBasics",
        "BinarySearchBasics"
    };

    private static void runMain(String className) {
        System.out.println("=== " + className + " ===");
        try {
            Class<?> clazz = Class.forName(className);
            clazz.getMethod("main", String[].class).invoke(null, (Object) new String[0]);
        } catch (Exception e) {
            System.out.println("Skipping " + className + " due to error: " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (String className : RUNNER_CLASSES) {
            runMain(className);
        }
    }
}
