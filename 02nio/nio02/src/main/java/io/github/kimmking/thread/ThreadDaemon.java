package io.github.kimmking.thread;

/**
 * @Program: netty-gateway
 * @ClassName: ThreadDaemon
 * @Author: zhangjl
 * @Date: 2021-01-30 20:07
 * @Description: 守护线程
 *      守护主线程的执行情况，当主线程未结束，守护线程随之执行完毕。当主线程结束，守护线程随着结束
 *      守护线程起作用可以将主线程休眠时长多余守护线程，需要主线程后于守护线程结束
 */
public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread t = Thread.currentThread();
                System.out.println("当前线程:" + t.getName());
            }
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1000);
    }
}
