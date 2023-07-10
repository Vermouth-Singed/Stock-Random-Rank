package stock.random.rank;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static stock.random.rank.entity.QStockCompanyInfo.stockCompanyInfo;

@SpringBootTest
@Transactional
class StockRandomRankProjectApplicationTests {
	@Autowired
	private EntityManager em;

	private JPAQueryFactory jpaQueryFactory;

	@BeforeEach
	void init() {
		jpaQueryFactory = new JPAQueryFactory(em);
	}

	@Test
	@DisplayName("querydsl 테스트")
	void querydsl() {
		assertTrue(
			Optional.ofNullable(
				jpaQueryFactory
					.select(stockCompanyInfo.id)
					.from(stockCompanyInfo)
					.limit(1)
					.fetchOne()
			).isPresent()
		);
	}
}
