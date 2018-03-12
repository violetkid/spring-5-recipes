package com.apress.springrecipes.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 코트 예약 애플리케이션의 구성 클래스로, 컴포넌트 스캐닝을 활성화하여 서비스 및 컨트롤러 빈을 모두 감지합니다.
 * (단, {@code com.apress.springrecipes.court} 이하 패키지에 있는 클래스만 해당됩니다)
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.apress.springrecipes.court")
public class CourtConfiguration {
}
