package com.example.demo.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by T530 on 12.06.2017.
 */
public class MainRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        String INPUT = "file://c:/temp/in?noop=false&recursive=true";
        from(INPUT).routeId("KOPIER")
                .to("file://c:/temp/out")
                //.log("log:bilder?level=INFO&groupInterval=10000&groupDelay=60000&groupActiveOnly=false")
                .to("spring-batch:jobben")
                .end();
    }
}
