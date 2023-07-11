package stock.random.rank.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
@Slf4j
public class StockCompanyInfoScheduler {
    @Scheduled(fixedDelay = 10000, initialDelay = 2000)
    public void stockCompanyInfoScheduler() {
        log.info(System.currentTimeMillis() + "ms");
    }
}
