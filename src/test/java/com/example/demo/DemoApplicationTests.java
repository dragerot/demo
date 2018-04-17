package com.example.demo;

import com.example.demo.camel.MainRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.component.bean.ProxyHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CamelContext camelContext;

	//@Test
	public void contextLoads() throws Exception {
//		Assert.assertTrue(camelContext != null);
//		Endpoint endpoint = camelContext.getEndpoint("file://c:/temp/in?noop=true&recursive=true");
//		Assert.assertTrue(endpoint != null);
//		MainRoute sender = ProxyHelper.createProxy(endpoint,MainRoute.class);
//		Assert.assertTrue(sender != null);


	}
}
