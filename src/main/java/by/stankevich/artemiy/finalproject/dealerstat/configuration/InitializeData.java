package by.stankevich.artemiy.finalproject.dealerstat.configuration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class InitializeData {
    private final DataSource dataSource;

    public InitializeData(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }
}
