package com.common.util.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author JiaZM
 * @date 2020/4/10 14:31
 */
@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> implements Serializable {

    private static final long serialVersionUID = 7843353897757455719L;

    @ApiModelProperty(value = "状态码", required = true)
    private Integer code;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "数据对象")
    private T data;

    @ApiModelProperty(value = "系统级参数")
    private SystemParams systemParams;

}
