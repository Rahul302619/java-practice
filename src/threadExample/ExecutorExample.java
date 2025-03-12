package threadExample;

import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) {
        testExecutor();
        callableExampleWithNormalThread();
        threadPoolExecutorExample();
    }


    private static void testExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Here, 5 is the number of threads in the pool
        var runnable = new RunnableExample();
        var callable = new CallableExample();
        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            // Submitting tasks using lambda expression
            executor.submit(runnable);
            Future<Integer> future = executor.submit(callable);
            Future<Integer> future1 = executor.submit(callable);
            try {
                System.out.println("Task method:" + future.get() + "---" + future1.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        // Shutdown the thread pool after all tasks are completed
        executor.shutdown();
    }

    private static void callableExampleWithNormalThread() {
        CallableExample callable = new CallableExample();
        // Create a FutureTask with the Callable
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println("Main method: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void threadPoolExecutorExample() {
        /* Core pool size: minimum number of threads to keep alive
            When a new task arrives, and the number of threads in the pool is less than the core pool size,
            a new thread will be created even if some threads are idle.
        */
        int corePoolSize = 5;
        int maximumPoolSize = 10; // Maximum pool size: maximum number of threads to create when demand is high
        long keepAliveTime = 60; // Keep-alive time for idle threads in seconds if the number of thread is more than core pool size


        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100); // Create a bounded blocking queue to hold tasks

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);

        threadPoolExecutor.submit(new RunnableExample());
        threadPoolExecutor.submit(new CallableExample());

        threadPoolExecutor.shutdown();
    }
}



class RunnableExample implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable Test, Thread Name: " + Thread.currentThread().getName());
    }
}

class CallableExample implements Callable<Integer> {

    volatile int count = 0;

    @Override
    public Integer call() throws Exception {
        count++;
        System.out.println("Callable Test, Thread Name: " + Thread.currentThread().getName());
        return count;
    }
}
