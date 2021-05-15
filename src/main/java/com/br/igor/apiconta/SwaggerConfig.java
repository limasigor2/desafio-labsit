//package com.br.igor.apiconta;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.SingletonBeanRegistry;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.type.filter.AnnotationTypeFilter;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//
//import com.google.common.base.Predicates;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
////@Configuration
////public class SwaggerConfig {
////	@Bean
////	public Docket api() {
////		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
////				.paths(PathSelectors.any()).build();
////	}
////}
//
//@Configuration
//public class SwaggerConfig {
////	@Bean
////	public Docket api() {
////		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
////				.paths(PathSelectors.any()).build();
////	}
////	
//////	@Override
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////	    registry.addResourceHandler("swagger-ui.html")
////	      .addResourceLocations("classpath:/META-INF/resources/");
////
////	    registry.addResourceHandler("/webjars/**")
////	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
////	}
//
//	@Autowired
//	ConfigurableApplicationContext context;
//
//	// Default Docket to show all
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).forCodeGeneration(Boolean.TRUE).select()
//				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
//				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
//	}
//
//	// Creating Docket Dynamically per Rest Controller
//	@PostConstruct
//	public void postConstruct() throws ClassNotFoundException {
//		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
//		provider.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
//		for (BeanDefinition beanDef : provider.findCandidateComponents("com.br.igor.apiconta")) {
//			Class<?> cl = Class.forName(beanDef.getBeanClassName());
//			RequestMapping requestMapping = cl.getAnnotation(RequestMapping.class);
//			if (null != requestMapping && null != requestMapping.value() && requestMapping.value().length > 0) {
//				String resource_group = requestMapping.value()[0];
//				SingletonBeanRegistry beanRegistry = context.getBeanFactory();
//				Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName(resource_group).apiInfo(metaData())
//						.forCodeGeneration(Boolean.TRUE).select()
//						// .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//						.paths(PathSelectors.regex(resource_group + ".*"))
//						.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
//				beanRegistry.registerSingleton(cl.getSimpleName() + "_docket_api", docket);
//			}
//		}
//	}
//
//	private ApiInfo metaData() {
//		return new ApiInfoBuilder().title("some Title Here").description("Some Desciption").version("1.0")
//				.contact(new Contact("Asad Abdin", "", "asadabdin@gmail.com")).build();
//	}
//}