package cn.start.pp.module.elderly.controller.admin.health.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康监测新增请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyHealthRecordCreateReqVO extends ElderlyHealthRecordBaseVO {
}

