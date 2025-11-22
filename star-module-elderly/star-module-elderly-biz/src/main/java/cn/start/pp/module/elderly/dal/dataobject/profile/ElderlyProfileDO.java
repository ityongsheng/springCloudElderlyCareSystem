package cn.start.pp.module.elderly.dal.dataobject.profile;

import cn.start.pp.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("elderly_profile")
@KeySequence("elderly_profile_seq")
public class ElderlyProfileDO extends BaseDO {

    @TableId
    private Long id;
    private String name;
    private String idCard;
    private Integer age;
    private Integer gender;
    private String contactPhone;
    private String address;
    private String emergencyContact;
    private String emergencyPhone;
    private String remark;
}
