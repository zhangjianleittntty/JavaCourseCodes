package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 网关消息响应过滤器
 * @author zhangjl
 * @date 2021-01-03
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
