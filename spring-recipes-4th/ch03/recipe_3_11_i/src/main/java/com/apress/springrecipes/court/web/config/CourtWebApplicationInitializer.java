package com.apress.springrecipes.court.web.config;

import com.apress.springrecipes.court.config.CourtConfiguration;

import javax.servlet.ServletContainerInitializer;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * {@link DispatcherServlet}를 시동하기 위한 {@link ServletContainerInitializer} 구현체
 */
public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{CourtConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
