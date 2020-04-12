package com.app.config;

import com.common.util.result.ResCode;
import com.common.util.result.ResultDto;
import com.common.util.result.SystemParams;

/**
 * @author JiaZM
 * @date 2020/4/10 15:24
 */
public class BaseController {

    private ResultDto resultDto;

    public ResultDto getResultDto() {
        if(resultDto == null) {
            resultDto = new ResultDto();
        }
        return resultDto;
    }

    public ResultDto result(ResCode resCode, Object data, SystemParams sys) {
        ResultDto rdo = getResultDto();
        rdo.setCode(resCode.getCode());
        rdo.setMessage(resCode.getMessage());
        rdo.setData(data);
        rdo.setSystemParams(sys);
        return rdo;
    }

    public ResultDto result(ResCode resCode, Object data) {
        return result(resCode, data, null);
    }

    public ResultDto result(ResCode resCode) {
        return result(resCode, null, null);
    }


}
