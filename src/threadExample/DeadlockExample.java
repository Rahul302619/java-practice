package threadExample;

public class DeadlockExample {
    private static final Object resource1 = new Object(); // Resource 1
    private static final Object resource2 = new Object(); // Resource 2

    public static void main(String[] args) {
        /*
         * A deadlock is a situation where two or more threads are blocked forever,
         * waiting for each other. It can be avoided by careful design, avoiding nested locks,
         * using a timeout for lock attempts(ReentrantLock and tryLock(it is the method of ReentrantLock)),
         * and employing a consistent lock ordering.
         * */
        testDeadLock();
    }

    private static void testDeadLock() {
        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");

                // Adding some delay so that Thread 2 can lock resource 2
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: waiting for  resource 2 Lock....");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                // Adding some delay so that Thread 1 can lock resource 1
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: waiting for resource 1 Lock....");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        // Starting both threads
        t1.start();
        t2.start();
    }
}
