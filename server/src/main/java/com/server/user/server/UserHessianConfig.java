package com.server.user.server;

import com.common.hessian.user.UserHessian;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * @author JiaZM
 * @date 2020/4/10 13:56
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserHessianConfig {

    private final UserHessian userHessian;

    @Bean("/userHessian")
    public HessianServiceExporter userHessian() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(userHessian);
        exporter.setServiceInterface(UserHessian.class);
        return exporter;
    }

}
