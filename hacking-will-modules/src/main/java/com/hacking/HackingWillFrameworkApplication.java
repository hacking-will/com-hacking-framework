package com.hacking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableSwagger2
@SpringBootApplication
/**
 * @SpringBootApplicatoin是用的@ComponentScan扫描，扫描的是Component，包括@Component,
 * @Controller, @Service, @Repository等，而@EnableFeignClients扫描的是@FeignClient，
 * 所以在指定扫描路径时要分别指定，否则会报异常：
 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.gxfw.bbs.feign.ArticleFeignClient' available: expected at least 1 bean which qualifies as autowire candidate.
 */
@Slf4j
public class HackingWillFrameworkApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(HackingWillFrameworkApplication.class, args);

		Environment env = application.getEnvironment();
//		String ip = InetAddress.getLocalHost().getHostAddress();
		String ip = "127.0.0.1";
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		log.info("\n----------------------------------------------------------\n\t" +
				"Framework Application is running! Access URLs:\n\t" +
				"Local: \t\thttp://localhost:" + port + path + "/\n\t" +
				"External: \thttp://" + ip + ":" + port + path + "/\n\t" +
				"swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
//				"Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n\t" +
				"Druid: \t\thttp://" + ip + ":" + port + path + "/druid\n" +
				"----------------------------------------------------------");

	}

}
