package stock.random.rank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.random.rank.entity.StockCompanyInfo;

public interface StockCompanyInfoJpa extends JpaRepository<StockCompanyInfo, Integer> {
}
