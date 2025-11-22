package cn.start.pp.module.elderly.dal.dataobject.order;

import cn.start.pp.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("elderly_service_order")
@KeySequence("elderly_service_order_seq")
public class ElderlyServiceOrderDO extends BaseDO {

    @TableId
    private Long id;
    private Long elderlyId;
    private Long serviceItemId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal amount;
    private Integer status;
    private String orderNo;
    private String cancelReason;
    private String remark;
}
