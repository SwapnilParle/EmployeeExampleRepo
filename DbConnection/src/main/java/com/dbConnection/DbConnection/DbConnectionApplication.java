package com.dbConnection.DbConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.dbConnection.DbConnection")
public class DbConnectionApplication {

public static void  main(String[]args){
SpringApplication.run(DbConnectionApplication.class, args);
        }
}