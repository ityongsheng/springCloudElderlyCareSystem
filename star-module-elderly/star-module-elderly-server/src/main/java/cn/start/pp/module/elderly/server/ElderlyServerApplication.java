package cn.start.pp.module.elderly.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.start.pp.module.elderly", "cn.start.pp.framework"})
public class ElderlyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElderlyServerApplication.class, args);
    }
}