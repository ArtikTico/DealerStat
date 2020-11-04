package by.stankevich.artemiy.finalproject.dealerstat.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Collections;
import java.util.List;

@Configuration
public class DozerConfiguration {

    @Bean
    public Mapper getMapper() {
        List<String> list = Collections.singletonList("dozer-config.xml");
        return new DozerBeanMapper(list);
    }
}
