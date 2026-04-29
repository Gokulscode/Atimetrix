package citi_problem;

/**
 * Problem: Write Singleton for multithreaded environment (double-checked locking).
 * Also: How many ways can break Singleton? How to restrict cloning?
 * Asked in: Ritwika/Mihir, Sunen rounds
 */
public class SingletonPattern {

    // Double-checked locking Singleton
    private static volatile SingletonPattern instance;

    private SingletonPattern() {
        // Prevent reflection attack
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for Singleton");
    }

    // Prevent deserialization breaking singleton
    protected Object readResolve() {
        return getInstance();
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }

    public static void main(String[] args) {
        // Test from multiple threads
        Runnable task = () -> {
            SingletonPattern s = SingletonPattern.getInstance();
            s.showMessage();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}

