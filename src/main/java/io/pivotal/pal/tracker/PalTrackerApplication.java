package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class,args);
    }

@Bean
JdbcTimeEntryRepository getTimeEntryRepository(){
    MysqlDataSource dataSource = new MysqlDataSource();
    final String VAR_NAME = "cloud.services.p.mysql.jdbcUrl";
    if (System.getenv(VAR_NAME)!= null){
        dataSource.setUrl(System.getenv(VAR_NAME));
    }else {
        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
    }
    return new JdbcTimeEntryRepository(dataSource);
    }
}
