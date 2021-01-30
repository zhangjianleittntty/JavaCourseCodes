package io.github.kimmking.gateway;


import io.github.kimmking.gateway.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * (1) 启动网关: http://127.0.0.1:8804
 * (2) 指定网关分配访问服务: http://127.0.0.1:8805
 * (3) 启动Netty服务端:HttpInboundServer()
 * (4) 指定Channel的分配Handler
 * (5) HttpInboundHandler 拿到channel分配的request任务来执行
 * (6) HttpOutboundHandler 指定响应的handler
 * (7) HttpOutboundHandler 采用多线程执行httpClient方式请求子应用并获取子应用响应信息
 * (8) HttpOutboundHandler httpClient在调用前首先执行：指定子应用路由，和过滤器任务，httpClient再执行
 */
public class NettyServerApplication {
    
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";
    
    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort","8804");

        // 这是之前的单个后端url的例子
//        String proxyServer = System.getProperty("proxyServer","http://localhost:8088");
//          //  http://localhost:8888/api/hello  ==> gateway API
//          //  http://localhost:8088/api/hello  ==> backend service
        // java -Xmx512m gateway-server-0.0.1-SNAPSHOT.jar  #作为后端服务


        // 这是多个后端url走随机路由的例子
        //String proxyServers = System.getProperty("proxyServers","http://localhost:8805,http://localhost:8806");
        String proxyServers = System.getProperty("proxyServers","http://localhost:8805");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
