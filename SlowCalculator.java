public class SlowCalculator implements Runnable {

    private final long N;
    private int M;//Calculation result

    public SlowCalculator(final long N) {
        this.N = N;
    }

    public void run() {
        final int result = calculate(N);
        this.M = result;
    }

    private static int calculate(final long N) {
        // This (very inefficiently) calculates the Nth Fibonacci number
        // The Fibonacci sequence is inherently slow when calculated recursively for large N
        if(Thread.currentThread().isInterrupted()) {
            break; // break if interrupted
        }
        return (int) fibonacci(N);
    }

    private static long fibonacci(final long n) {
        // This (very inefficiently) calculates the nth Fibonacci number using recursion
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    //getter N
    public long getN() {
    	return N;
    }
    
    //getter M
    public int getM() {
    	return M;
    }
}
