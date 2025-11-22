package cn.start.pp.module.elderly.controller.admin.item.vo;

import cn.start.pp.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 服务项目分页请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceItemPageReqVO extends PageParam {

    @Schema(description = "服务名称")
    private String name;

    @Schema(description = "状态")
    private Integer status;
}
