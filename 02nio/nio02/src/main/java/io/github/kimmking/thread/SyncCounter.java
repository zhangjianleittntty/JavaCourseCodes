package io.github.kimmking.thread;

import java.util.stream.IntStream;

/**
 * @Program: netty-gateway
 * @ClassName: SyncCounter
 * @Author: zhangjl
 * @Date: 2021-01-30 20:17
 * @Description:
 */
public class SyncCounter {

    private volatile  int sum = 0;

    public int getSum() {
        return sum;
    }

    /**
     * 代码块锁当前对象:this
     * @return
     */
    public int addAndGet() {
        synchronized (this) {
            return ++sum;
        }
    }

    /**
     * 没有加锁，不具备原子性,多个线程会同时访问共享资源，当共享资源加了volatile时，只能解决可见性，还是不能解决原子性
     * volatile 适合单线程写，多线程读。++i是多线程写、多线程读所以需要加原子锁
     * @return
     */
    public int addGet() {
        return ++sum;
    }

    /**
     * 方法锁当前对象:this
     * @return
     */
    public synchronized int incrAndGet() {
        return ++sum;
    }

    public static void main(String[] args) {
        int loopNum = 100_0000;
        SyncCounter syncCounter = new SyncCounter();
        IntStream.range(0,loopNum).parallel().forEach(i->syncCounter.addGet());
        System.out.println(syncCounter.getSum());
    }
}
