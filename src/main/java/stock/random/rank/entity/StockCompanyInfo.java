package stock.random.rank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Entity(name="stock_company_info")
public class StockCompanyInfo {
    @Id
    private Integer id;
    private Integer code;
    private String name;
    private Integer price;
    private Integer increaseRate;
    private Integer viewCnt;
    private Integer buyCnt;
}
