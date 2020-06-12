package com.joseph.cloud.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义路由
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator baiduNewsGuoneiRouter(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_joseph1", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator baiduNewsGuojiRouter(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_joseph2", r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }


}
