package com.common.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author JiaZM
 * @version V1.0
 * @date 2020/4/8
 */

@Entity(name = "t_user_info")
@ApiModel
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 5144907044985865840L;

    @ApiModelProperty(value = "主键ID")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Column(name="username")
    private String username;

    @ApiModelProperty(value = "手机号")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "密码")
    @Column(name="pwd")
    private String pwd;

    @ApiModelProperty(value = "性别，0：男 1：女")
    @Column(name = "sex")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @ApiModelProperty(value = "头像")
    @Column(name = "header_pic")
    private String headerPic;

    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "register_time")
    private Date registerTime;

    @ApiModelProperty(value = "阅读时长（分钟）")
    @Column(name = "read_time")
    private Long readTime;

    @ApiModelProperty(value = "自我介绍")
    @Column(name = "self_introduction")
    private String selfIntroduction;
}
