package com.wh.workSubmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:work.properties",encoding = "utf-8")
@ComponentScan(basePackages = "com.wh.workSubmission")
public class WorkSubmissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkSubmissionApplication.class, args);
    }
}

/*
public class WorkSubmissionApplication extends SpringBootServletInitializer {
    eeew
    public static void main(String[] args) {
        SpringApplication.run(WorkSubmissionApplication.class, args);
    }
}
*/
