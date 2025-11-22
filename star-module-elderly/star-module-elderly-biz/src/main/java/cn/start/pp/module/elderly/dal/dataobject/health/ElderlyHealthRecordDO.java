package cn.start.pp.module.elderly.dal.dataobject.health;

import cn.start.pp.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("elderly_health_record")
@KeySequence("elderly_health_record_seq")
public class ElderlyHealthRecordDO extends BaseDO {

    @TableId
    private Long id;
    private Long elderlyId;
    private String type;
    private BigDecimal value;
    private String unit;
    private Integer abnormalFlag;
    private String remark;
}
