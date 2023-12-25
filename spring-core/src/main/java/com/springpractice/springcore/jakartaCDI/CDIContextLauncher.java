package com.springpractice.springcore.jakartaCDI;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Named
class BusinessService {
    private DataService dataService;
    private DataService getDataService() {
        return dataService;
    }
    @Inject
    private void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}

@Named
class DataService {
}

@Configuration
@ComponentScan
public class CDIContextLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncher.class)) {

        }
    }

}
