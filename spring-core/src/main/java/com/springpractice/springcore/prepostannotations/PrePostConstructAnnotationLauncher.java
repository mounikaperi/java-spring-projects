package com.springpractice.springcore.prepostannotations;

import com.springpractice.springcore.scopes.BeanScopesLauncherApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!!");
    }
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }
    @PreDestroy
    public void cleanUp() {
        System.out.println("Resources are released. CleanUp Completed!!");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic SomeDependency");
    }
}
@Configuration
@ComponentScan
public class PrePostConstructAnnotationLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
            System.out.println(context.getBean(SomeClass.class));
        }
    }
}
