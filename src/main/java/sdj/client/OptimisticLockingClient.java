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
public class OptimisticLockingClient implements ApplicationRunner{
    @Autowired
    User1Client user1Client;
    @Autowired
    User2Client user2Client;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Implementation for optimistic locking client
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(user1Client);
        executorService.execute(user2Client);

        executorService.shutdown();
    }
}
