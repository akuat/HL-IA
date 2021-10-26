public class Stopwatch { 

    private final long BEGIN;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        BEGIN = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - BEGIN) / 1000.0;
    }

} 
