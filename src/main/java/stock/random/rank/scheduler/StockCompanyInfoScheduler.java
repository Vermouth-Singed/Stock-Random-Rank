package stock.random.rank.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import stock.random.rank.service.StockInfoService;

@EnableScheduling
@Component
@Slf4j
public class StockCompanyInfoScheduler {
    @Autowired
    StockInfoService stockInfoService;

    @Scheduled(fixedDelay = 10000, initialDelay = 2000)
    public void stockCompanyInfoScheduler() {
        stockInfoService.stockCompanyInfoScheduler();
    }
}
