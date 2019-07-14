package com.cheng.train.authentication;

import com.cheng.train.util.ResponseBean;
import com.cheng.train.util.properties.SecurityProperties;
import com.cheng.train.util.properties.LoginResponseType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("trainAuthenctiationFailureHandler")
public class TrainAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败！");
        if (LoginResponseType.JSON.equals(securityProperties.getLoginType())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new ResponseBean<String>(1003,exception.getMessage())));
        }else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
