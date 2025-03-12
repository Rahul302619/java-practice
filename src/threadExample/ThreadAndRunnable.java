package threadExample;

public class ThreadAndRunnable {

    public static void main(String[] args) {
        /*
        * While extending Thread class we will not get compile time error
        * if we are not overriding run method but if we implement Runnable
        * we will get compile time error for not overriding run method.
        *
        * Thread : Can't execute same instance of thread multiple time
        * Runnable : Can execute same instance of runnable multiple time by passing it to diff thread
        *
        * Also by implementing Runnable we can extend other class as well if we required,
        * it separates the task from the mechanism of running it,
        * it is used by ExecutorService for creating the thread pool.
        * that's why always choose Runnable over Thread
        * */
        runExampleThreadMultipleTime();
        runExampleRunnableMultipleTime();
    }

    private static void runExampleThreadMultipleTime() {
        System.out.println("----------Thread class----------");
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.start();
        try {
            exampleThread.start();
        } catch (Exception exception) {
            System.out.println("Exception : " + exception.getMessage());
        }
    }

    private static void runExampleRunnableMultipleTime() {
        System.out.println("----------Runnable class----------");
        ExampleRunnable exampleRunnable = new ExampleRunnable();

        Thread thread = new Thread(exampleRunnable);
        Thread thread1 = new Thread(exampleRunnable);

        thread.start();
        thread1.start();
    }
}

class ExampleThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread class Run Method");
    }
}

class ExampleRunnable implements Runnable {
    /*
    * In multi-threaded environment if we want to share the latest state change
    *  across different threads than in that case we can use volatile.
    * */
    volatile int count = 0;

    @Override
    public void run() {
        count += 1;
        System.out.println("Runnable class Run Method : " + Thread.currentThread().getName() + " ----- " + count);
        test();
    }

    /*
    * Synchronization is a technique to control the access of multiple threads to shared resources.
    * It is important to prevent data inconsistency and race conditions.
    * */
    private synchronized void test() {
        System.out.println("synchronized method : " + count);
    }
}
