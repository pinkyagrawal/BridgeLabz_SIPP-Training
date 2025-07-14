public class StringConcatenationPerformance {

    public static void runConcatenationComparison(int count, String value) {
        long start, end;

        if (count <= 10000) {
            start = System.nanoTime();
            String s = "";
            for (int i = 0; i < count; i++) {
                s += value;
            }
            end = System.nanoTime();
            System.out.println("String Time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("String Time: Unusable");
        }

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value);
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append(value);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println();
    }

    public static void main(String[] args) {
        runConcatenationComparison(1000, "a");
        runConcatenationComparison(10000, "a");
        runConcatenationComparison(1_000_000, "a");
    }
}
