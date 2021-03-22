package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * 网关路由实现类
 * @author zhangjl
 * @date 2021-01-04
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
