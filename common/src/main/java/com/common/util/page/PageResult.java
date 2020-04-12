package com.common.util.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author JiaZM
 * @version V1.0
 * @date 2020/3/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PageResult", description = "分页")
public class PageResult<T> {

    /**
     * 页码
     * */
    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    /**
     * 每页长度
     * */
    @ApiModelProperty(value = "每页长度")
    private Integer pageSize;

    /**
     * 是否为第一页
     * */
    @ApiModelProperty(value = "是否为第一页")
    private Boolean first;

    /**
     * 是否为最后一页
     * */
    @ApiModelProperty(value = "是否为最后一页")
    private Boolean last;

    /**
     * 当前页长度
     * */
    @ApiModelProperty(value = "当前页长度")
    private Integer numbers;

    /**
     * 总页数
     * */
    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    /**
     * 总记录数
     * */
    @ApiModelProperty(value = "总记录数")
    private Integer totalNums;

    /**
     * 数据列表
     * */
    @ApiModelProperty(value = "数据列表")
    private List<T> pageList;

}