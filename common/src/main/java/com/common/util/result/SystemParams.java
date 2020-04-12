package com.common.util.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 系统级参数
 * @author JiaZM
 * @date 2020/4/10 14:34
 */
@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemParams {

    @ApiModelProperty(value = "服务器时间")
    private Date currentTime;

    @ApiModelProperty(value = "token令牌")
    private String token;

}
