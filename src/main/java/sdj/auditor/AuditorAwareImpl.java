package sdj.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Arrays.asList("Abhinav", "John", "Jane").get(new Random().nextInt(3)));
    }
}
