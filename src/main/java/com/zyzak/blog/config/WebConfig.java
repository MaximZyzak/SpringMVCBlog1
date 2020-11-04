package com.zyzak.blog.config;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.datasource.DriverManagerDataSource;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
        import org.springframework.web.servlet.view.InternalResourceViewResolver;
        import org.springframework.web.servlet.view.JstlView;

        import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.zyzak.blog")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/pages/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){

        return  new JdbcTemplate(getDataSource());

    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("BlogUser");
        dataSource.setPassword("m1234");
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        return dataSource;
    }
}