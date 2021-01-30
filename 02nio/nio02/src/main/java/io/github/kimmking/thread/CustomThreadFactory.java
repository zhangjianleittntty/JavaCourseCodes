package io.github.kimmking.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Program: netty-gateway
 * @ClassName: CustomThreadFactory
 * @Author: zhangjl
 * @Date: 2021-01-30 20:34
 * @Description: 实现创建线程的工厂类
 */
public class CustomThreadFactory implements ThreadFactory {
    private AtomicInteger serial = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.setName("CustomeThread-" + serial.getAndIncrement());
        return thread;
    }
}
