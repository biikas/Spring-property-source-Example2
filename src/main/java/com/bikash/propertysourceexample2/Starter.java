package com.bikash.propertysourceexample2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@PropertySource(value = "config.yml",factory = YamlPropertyLoaderFactory.class)
public class Starter implements CommandLineRunner {

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;



    @Override
    public void run(String... args) throws Exception {
        this.readApplicationYMLFile();
        this.readConfigYamlFile();

    }
    public  void readApplicationYMLFile(){
        log.info("Reading Yaml files");
        log.info("App name: {}, App version: {}",appName,appVersion);
    }
    public void readConfigYamlFile(){
        log.info("Reading config files");
        log.info("Admin username: {} , Admin Password: {}",adminUsername,adminPassword);

    }
}
