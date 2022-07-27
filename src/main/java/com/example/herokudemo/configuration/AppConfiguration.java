package com.example.herokudemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("docker")
public class AppConfiguration {

    // ${DATABASE_URL}

//    @Value("${spring.datasource.url}")

    @Value("${DATABASE_URL}")
    private String databaseRawUrl;

    // todo REQUIRES UNIT TEST!!!

    // spring.datasource.url
    // spring.datasource.username
    // spring.datasource.password

    // -> @Bean DataSource
    @Bean
    public DataSource dataSource() {

        if (databaseRawUrl == null) {
            throw new IllegalArgumentException("DATABASE_URL cannot be null or empty");
        }
        //postgres://klcybemwxvcqrb:207f76bbc570a7bf0ad287d66a90bca6f8b7b3eb98a9795c5c7618901246b62c@ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/dd7sj27a71t3l3

        //jdbc:postgresql://

        String dataSourceFullUrl = databaseRawUrl.replaceFirst("postgres://", "");

        // klcybemwxvcqrb:207f76bbc570a7bf0ad287d66a90bca6f8b7b3eb98a9795c5c7618901246b62c@ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/dd7sj27a71t3l3
        String url =
                String.format("jdbc:postgresql://%s",
                        dataSourceFullUrl.substring(dataSourceFullUrl.indexOf("@") + 1)
                );

        // ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/dd7sj27a71t3l3

        String username = dataSourceFullUrl.substring(0, dataSourceFullUrl.indexOf(":"));
        //klcybemwxvcqrb

        String password = dataSourceFullUrl.substring(
                dataSourceFullUrl.indexOf(":") + 1,
                dataSourceFullUrl.indexOf("@")
        );
        // klcybemwxvcqrb:   207f76bbc570a7bf0ad287d66a90bca6f8b7b3eb98a9795c5c7618901246b62c   @ec2-52


        DataSource dataSource = DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(url)
                .build();

        return dataSource;
    }

}

//class A {
//    public static void main(String[] args) {
//        String databaseRawUrl = "postgres://klcybemwxvcqrb:207f76bbc570a7bf0ad287d66a90bca6f8b7b3eb98a9795c5c7618901246b62c@ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/dd7sj27a71t3l3";
//
//        String dataSourceFullUrl = databaseRawUrl.replaceFirst("postgres://", "");
//
//        String url = dataSourceFullUrl.substring(dataSourceFullUrl.indexOf("@") + 1);
//        url = String.format("jdbc:postgresql://%s", url);
//
//        // ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/dd7sj27a71t3l3
//
//        String username = dataSourceFullUrl.substring(0, dataSourceFullUrl.indexOf(":"));
//        //klcybemwxvcqrb
//
//        String password = dataSourceFullUrl.substring(
//                dataSourceFullUrl.indexOf(":") + 1,
//                dataSourceFullUrl.indexOf("@")
//        );
//
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(password);
//    }
//}
