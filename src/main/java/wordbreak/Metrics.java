package wordbreak;

public class Metrics {
    private static long startTime;
    private static long stopTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    public static void getExecutionTime() {
        long estimatedTime = stopTime - startTime;
        System.out.println("Execution time is " + estimatedTime + " ms");
    }

    public static void getUsedMemory() {
        Runtime.getRuntime().gc();
        long usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("Used memory is " + convertToMegabytes(usedBytes) + " mb");
    }

    private static double convertToMegabytes(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

    public static void getAllMetrics(){
        getExecutionTime();
        getUsedMemory();
    }
}

