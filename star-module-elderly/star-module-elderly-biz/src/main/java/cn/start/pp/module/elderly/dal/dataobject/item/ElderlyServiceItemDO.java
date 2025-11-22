package cn.start.pp.module.elderly.dal.dataobject.item;

import cn.start.pp.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("elderly_service_item")
@KeySequence("elderly_service_item_seq")
public class ElderlyServiceItemDO extends BaseDO {

    @TableId
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer status;
}
