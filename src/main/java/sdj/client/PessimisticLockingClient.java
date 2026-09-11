package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Order(2)
public class PessimisticLockingClient implements ApplicationRunner {
    @Autowired
    UserXClient userXClient;
    @Autowired
    UserYClient userYClient;
    @Override
    public void run(ApplicationArguments args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(userXClient);
        executor.execute(userYClient);

        executor.shutdown();
    }

}
