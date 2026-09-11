package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sdj.entity.Guide;
import sdj.repository.GuideRepository;

@Component
@Order(1)
public class PopulateDbClient implements ApplicationRunner {

    @Autowired
    GuideRepository guideRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Populate the database with initial data
        guideRepository.save(new Guide("2000MO","John Doe", 1000));
        guideRepository.save(new Guide("2000JS","Jane Smith", 2500));
        guideRepository.save(new Guide("2000AJ","Alice Johnson", 3000));
    }

}
