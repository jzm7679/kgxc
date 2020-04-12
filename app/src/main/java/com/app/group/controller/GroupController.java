package com.app.group.controller;

import com.app.config.BaseController;
import com.common.entity.group.Group;
import com.common.util.result.ResultDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JiaZM
 * @date 2020/4/10 21:53
 * @Description:
 */
@Api(tags = "圈子")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupController extends BaseController {

    @RequestMapping(value = "/myGroupList", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultDto<List<Group>> myGroupList() {

        return null;
    }

}
