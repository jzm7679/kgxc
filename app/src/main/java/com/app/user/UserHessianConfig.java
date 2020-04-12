package com.app.user;

import com.common.hessian.user.UserHessian;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * @author JiaZM
 * @date 2020/4/10 14:27
 */
@Configuration
public class UserHessianConfig {

    @Bean
    public HessianProxyFactoryBean userClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost:10086/server/userHessian");
        factory.setServiceInterface(UserHessian.class);
        return factory;
    }
}
