package stock.random.rank.dto;

import lombok.Data;

@Data
public class StockCompanyInfoDTO {
    private Integer code;
    private String name;
    private Integer price;
    private Double increaseRate;
    private Integer viewCnt;
    private Integer buyCnt;
}
