package stock.random.rank.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stock.random.rank.entity.StockCompanyInfo;

public interface StockCompanyInfoRepository extends JpaRepository<StockCompanyInfo, Integer> {
    @Repository
    public class BlogSearchCntQuerydsl {
        @Autowired
        private JPAQueryFactory jpaQueryFactory;
    }
}
