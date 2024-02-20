package com.TravelPlanningSystem.TravelPlanningSystem.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Config implements WebMvcConfigurer
{
	@Bean
	public OpenAPI swaggerDocOpenApi() 
	{
		Server devserver = new Server();
		devserver.setUrl("localhost:8080");
		devserver.setDescription("Development server");
		
		Server testserver = new Server();
		testserver.setUrl("localhost:8081");
		testserver.setDescription("Test server");
		
		Contact co = new Contact();
		co.setEmail("jeyap3814@gmail.com");
		co.setName("Jp");
		co.setUrl("../https:github.com");
		
		License li = new License();
		li.setName("Lisence");
		li.setUrl("www.youtube.com");
		
		Info in = new Info();
		in.setContact(co);
		in.setLicense(li);
		in.setDescription("travel planning System : Good Project");
		in.setTermsOfService("www.google.com");
		in.setTitle("Travel Planning System");
		in.setVersion("2.0");
		
		OpenAPI op = new OpenAPI();
		op.info(in);
		op.setServers(Arrays.asList(devserver , testserver));
		return op;
	}
}
