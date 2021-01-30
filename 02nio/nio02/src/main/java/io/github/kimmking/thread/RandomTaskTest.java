package io.github.kimmking.thread;

import java.util.concurrent.*;

/**
 * @Program: netty-gateway
 * @ClassName: RandomTaskTest
 * @Author: zhangjl
 * @Date: 2021-01-30 20:53
 * @Description:
 * CustomThreadFactory: 创建线程是要使用守护线程，主线程获取result结束，守护线程结束，否则会不断创建线程
 */
public class RandomTaskTest {
    public static void main(String[] args)  {
        try {
            Callable<Integer> task = new RandomSleepTask();
            ExecutorService executorService = initThreadPoolExecutor();

            Future<Integer> future1 = executorService.submit(task);
            Future<Integer> future2 = executorService.submit(task);

            Integer result1 = future1.get(1, TimeUnit.SECONDS);
            Integer result2 = future2.get(1, TimeUnit.SECONDS);

            System.out.println("result1=" + result1);
            System.out.println("result2=" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ThreadPoolExecutor initThreadPoolExecutor() {
        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(500);
        CustomThreadFactory threadFactory = new CustomThreadFactory();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maxSize,
                1, TimeUnit.SECONDS, workQueue, threadFactory);
        return executor;
    }
}
