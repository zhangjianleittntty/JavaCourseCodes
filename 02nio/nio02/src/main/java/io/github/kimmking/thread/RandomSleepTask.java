package io.github.kimmking.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Program: netty-gateway
 * @ClassName: RandomSleepTask
 * @Author: zhangjl
 * @Date: 2021-01-30 20:31
 * @Description:
 */
public class RandomSleepTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer sleep = new Random().nextInt(10000);
        //TimeUnit.MILLISECONDS.sleep(sleep);
        return sleep;
    }

}
