Annotations
-----------
1. @RestController
2. @RequestMapping
3. @ConfigurationProperties
4. @Autowired
5. @Component

Others
-------
1. Spring Boot DevTools - no need to manually restart the server except changes done in pom.xml
2. Profiles - Different configurations in different environments
3. Multiple loggings - trace, debug, info, warning, error, off
4. Spring boot actuator - expose endpoints health and metrics
5. 2 ways of finding what is autoconfigured in spring boot- via actuator/beans and via logging at trace level

What all are autoconfigured in spring-boot
------------------------------------------
1. Starting application using Java SDK
2. Check profileset
3. Loading source class - your spring boot main class
4. Creating Shared Singleton beans
   1. propertySourcesPlaceHolderConfigurer
   2. DatabaseInitializationDependencyConfigurer
   3. internalEventListenerProcessor
   4. preserveErrorControllerTargetClassPostProcessor
   5. forceAutoProxyCreatorToUseClassProxying
   6. internalEventListenerFactory
   7. internalAutowiredAnnotationProcessor
   8. internalCommonAnnotationProcessor
   9. ConfigurationPropertiesBindingPostProcessor
   10. internalConfigurationPropertiesBinder
   11. internalAutoProxyCreator
   12. webServerFactoryCustomizerBeanPostProcessor
   13. errorPageRegistrarBeanPostProcessor
   14. tomcatServletWebServerFactory
   15. tomcatWebServerFactoryCustomizer
   16. dispatcherServletRegistration
   17. dispatcherServlet
   18. DispatcherServletAutoConfiguration$DispatcherServletConfiguration
   19. beanNameViewResolver
   20. ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration
   21. basicErrorController
   22. welcomePageHandlerMapping
   23. mvcConversionService
   24. mvcResourceUrlProvider
   25. mvcValidator
   26. mappingJackson2HttpMessageConverter
   27. jacksonObjectMapper
   28. jsonMixinModuleEntries
   29. jacksonObjectMapperBuilder
   30. jacksonObjectMapper
   31. mappingJackson2HttpMessageConverter
5. Autowriting above beans
6. Tomcat initialized with port 8080
7. Initializing Spring embedded WebApplicationContext
8. Resources that are autoconfigured
   1. DispatcherServletAutoConfiguration
   2. EmbeddedWebServerFactoryCustomizerAutoConfiguration
   3. ErrorMvcAutoConfiguration
   4. GenericCacheConfiguration
   5. HttpEncodingAutoConfiguration
   6. HttpMessageConvertersAutoConfiguration
   7. JacksonAutoConfiguration
   8. JacksonHttpMessageConvertersConfiguration
   9. LifecycleAutoConfiguration
   10. MultipartAutoConfiguration
   11. RestClientAutoConfiguration
   12. ServletWebServerFactoryAutoConfiguration
   13. SqlInitializationAutoConfiguration
   14. sslBundleRegistry