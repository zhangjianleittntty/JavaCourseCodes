package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 网关消息响应过滤器实现类
 * @author zhangjl
 * @date 2021-01-03
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("responseHeader", "response filter set");      // 设置响应头信息
    }
}
