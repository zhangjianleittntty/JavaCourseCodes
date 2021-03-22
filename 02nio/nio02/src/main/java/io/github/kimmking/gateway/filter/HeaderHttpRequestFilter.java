package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**f
 * 网关请求过滤器实现类
 * @author zhangjl
 * @date 2021-01-02
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("requestHeader", "request filter set");        // 设置request请求header头
    }
}
