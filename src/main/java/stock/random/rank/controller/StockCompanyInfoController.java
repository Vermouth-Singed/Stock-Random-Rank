package stock.random.rank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.random.rank.model.ApiResult;
import stock.random.rank.service.StockInfoService;

import static stock.random.rank.model.ApiResult.OK;

@RestController
@RequestMapping("/api/stock/random/rank")
public class StockCompanyInfoController {
    @Autowired
    StockInfoService stockInfoService;

    @GetMapping("/list/{pageNo}/{limit}/{orderBy}")
    public ApiResult readList(@PathVariable int pageNo, @PathVariable int limit, @PathVariable String orderBy) throws Exception {
        return OK(stockInfoService.readList(pageNo, limit, orderBy));
    }
}
