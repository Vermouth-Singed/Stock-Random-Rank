package stock.random.rank.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static stock.random.rank.entity.QStockCompanyInfo.stockCompanyInfo;

@Configuration
public class QuerydslConfiguration {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public JPAUpdateClause stockCompanyInfoUpdateClause() {
        return new JPAUpdateClause(entityManager, stockCompanyInfo);
    }
}
