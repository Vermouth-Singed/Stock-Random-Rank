package stock.random.rank.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.random.rank.dto.StockCompanyInfoDTO;
import stock.random.rank.entity.StockCompanyInfo;
import stock.random.rank.model.ErrorMsg;
import stock.random.rank.repository.StockCompanyInfoJpa;
import stock.random.rank.repository.StockCompanyInfoQuerydsl;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StockInfoService {
    @Autowired
    private StockCompanyInfoQuerydsl stockCompanyInfoQuerydsl;

    @Autowired
    private StockCompanyInfoJpa stockCompanyInfoJpa;

    public Map<String, Object> readList(int pageNo, int limit, String orderBy) throws Exception {
        Map<String, Object> result = new HashMap<>();

        int maxLimit = 100;

        if (pageNo < 1 || limit <= 0 || limit > maxLimit) {
            result.put("msg", ErrorMsg.PARAM_ERROR.msg());

            return result;
        }

        int maxOffset = (pageNo - 1) * limit;

        int offset = maxOffset > maxLimit ? (maxLimit - limit > maxLimit ? maxLimit : limit) : maxOffset;

        List<StockCompanyInfo> list = stockCompanyInfoQuerydsl.listSampleData(offset, limit, orderBy);

        if (list != null) {
            result.put("list",
                list.stream().map(stockCompanyInfo -> {
                    StockCompanyInfoDTO dto = new StockCompanyInfoDTO();

                    BeanUtils.copyProperties(stockCompanyInfo, dto);

                    dto.setIncreaseRate(stockCompanyInfo.getIncreaseRate() / 100.);

                    return dto;
                }).
                collect(Collectors.toList())
            );
        }

        return result;
    }

    public void updateSampleData(int id, int increaseRate, int buyCnt, int viewCnt) {
        Optional
        .ofNullable(stockCompanyInfoJpa.findById(id))
        .ifPresent(optionalStockCompanyInfo -> {
            stockCompanyInfoJpa.save(
                optionalStockCompanyInfo.get()
                .setIncreaseRate(increaseRate)
                .setBuyCnt(buyCnt)
                .setViewCnt(viewCnt)
            );
        });
    }

    @Transactional
    public void stockCompanyInfoScheduler() {
        Map<Integer, StockCompanyInfo> updateIdMap = new HashMap<>();

        int cntUpdateId = (int)(Math.random() * 120) + 1;

        for (int i = 0; i < cntUpdateId; i++) {
            int randomId = (int)(Math.random() * 120) + 1;

            if (updateIdMap.containsKey(randomId)) {
                i--;

                continue;
            }

            updateIdMap.put(randomId, null);
        }

//        Optional
//        .ofNullable(stockCompanyInfoQuerydsl.leftSampleData(updateIdMap.keySet()))
//        .ifPresent(listStockCompanyInfo -> {
//            listStockCompanyInfo.stream().forEach(stockCompanyInfo -> {
//                updateSampleData(stockCompanyInfo.getId().intValue(), 0, 0, 0);
//            });
//        });

        stockCompanyInfoQuerydsl.updateDefaultData(updateIdMap.keySet());

        for (Integer id : updateIdMap.keySet()) {
            updateSampleData(
                id.intValue(),
                (int)Math.round(Math.random() * 10000 - 5000),
                (int)Math.round(Math.random() * 1000),
                (int)Math.round(Math.random() * 100)
            );
        }
    }
}
