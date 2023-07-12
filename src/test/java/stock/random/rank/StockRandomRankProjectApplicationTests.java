package stock.random.rank;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stock.random.rank.repository.StockCompanyInfoJpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static stock.random.rank.entity.QStockCompanyInfo.stockCompanyInfo;

@SpringBootTest
@Transactional
class StockRandomRankProjectApplicationTests {
	@Autowired
	private EntityManager em;

	private JPAQueryFactory jpaQueryFactory;

	@Autowired
	private StockCompanyInfoJpa stockCompanyInfoJpa;

	@BeforeEach
	void init() {
		jpaQueryFactory = new JPAQueryFactory(em);
	}

	@Test
	@DisplayName("querydsl 테스트")
	void querydsl_테스트() {
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

	@Test
	@DisplayName("querydsl not in 테스트")
	void querydsl_not_in_테스트() {
		assertTrue(
			Optional.ofNullable(
				jpaQueryFactory
					.select(stockCompanyInfo.id)
					.from(stockCompanyInfo)
					.where(stockCompanyInfo.id.notIn(List.of(1,2,3)))
					.fetch()
			).get().size() > 0
		);
	}

	@Test
	@DisplayName("jpa findById 테스트")
	void jpa_findById_테스트() {
		assertTrue(
			stockCompanyInfoJpa.findById(1).isPresent()
		);
	}
}
