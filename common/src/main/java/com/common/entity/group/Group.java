package com.common.entity.group;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author JiaZM
 * @date 2020/4/10 21:54
 */
@Entity(name = "t_group_info")
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {

    private static final long serialVersionUID = -1910898444813635194L;

    @ApiModelProperty(value = "主键ID")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ApiModelProperty(value = "圈子名")
    @Column(name = "group_name")
    private String groupName;

    @ApiModelProperty(value = "状态，0：正常 1：冻结 2：解散")
    @Column(name = "status")
    private Integer status;

    @ApiModelProperty(value = "热度")
    @Column(name = "hot_number")
    private Long hotNumber;

    @ApiModelProperty(value = "人数")
    @Column(name = "people_number")
    private Integer peopleNumber;


}
