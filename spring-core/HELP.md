1. AnnotationConfigApplicationContext
2. record - from JDK 16 - Access via recordName.class
ForEg: context.getBean(recordName.class)
3. Custom beans- @Bean(name="xyz")
4. Spring Container vs Spring Context vs IOC container vs ApplicationContext
5. Java Bean vs Spring Bean
6. List all beans managed by Spring - getBeanDefinitionNames, getBeanDefinitionCount
7. Multiple matching beans
8. Spring should create objects for us
9. Three types of Dependency Injections - Constructor based(no need of @Autowired annotation), setter based, field based
10. @Component vs @Bean
11. Eager and Lazy Initialization
12. Scopes= Singleton, Prototype - By Default-Singleton

Annotations:
-----------
Spring-core:
------------
1. @Configuration 
2. @Bean
3. @Primary
4. @Qualifier
5. @Component
6. @ComponentScan
7. @Autowired
8. @Lazy
9. @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
10. @PostConstruct
11. @PreDestroy
12. @Named - CDI - Similar to @Component
13. @Inject - CDI - Similar to @Autowired

Spring-MVC
------------