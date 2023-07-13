package stock.random.rank.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stock.random.rank.entity.StockCompanyInfo;

import java.util.List;
import java.util.Set;

import static stock.random.rank.entity.QStockCompanyInfo.stockCompanyInfo;

@Repository
public class StockCompanyInfoQuerydsl {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private JPAUpdateClause stockCompanyInfoUpdateClause;

    public List<StockCompanyInfo> listSampleData(int offset, int limit, String orderByParam) {
        return jpaQueryFactory
            .selectFrom(stockCompanyInfo)
            .orderBy((OrderSpecifier<?>)(
                    "viewCnt".equals(orderByParam) ? stockCompanyInfo.viewCnt.desc() :
                    "increase".equals(orderByParam) ? stockCompanyInfo.increaseRate.desc() :
                    "decrease".equals(orderByParam) ? stockCompanyInfo.increaseRate :
                    "buyCnt".equals(orderByParam) ? stockCompanyInfo.buyCnt.desc() :
                    stockCompanyInfo.id)
            )
            .offset(offset < 1 ? 0 : offset)
            .limit(limit < 1 ? 100 : limit)
            .fetch();
    }

    public List<StockCompanyInfo> leftSampleData(Set<Integer> idList) {
        return jpaQueryFactory
            .select(Projections.fields(StockCompanyInfo.class, stockCompanyInfo.id))
            .from(stockCompanyInfo)
            .where(stockCompanyInfo.id.notIn(idList))
            .fetch();
    }

    public long updateDefaultData(Set<Integer> idList) {
        return stockCompanyInfoUpdateClause
            .set(stockCompanyInfo.increaseRate, 0)
            .set(stockCompanyInfo.buyCnt, 0)
            .set(stockCompanyInfo.viewCnt, 0)
            .where(stockCompanyInfo.id.notIn(idList))
            .execute();
    }
}
