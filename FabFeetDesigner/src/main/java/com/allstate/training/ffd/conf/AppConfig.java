package com.allstate.training.ffd.conf;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.allstate.training.ffd.entities.Customer;



@Configuration
@ComponentScan(basePackages="com.allstate.training.ffd")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
       // registry.addResourceHandler("/img/**").addResourceLocations("/resources/imgages/").setCachePeriod(31556926);
       // registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
    }
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=
				new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/VMS");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties props=new Properties();
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		props.put(Environment.HBM2DDL_AUTO, "create");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.FORMAT_SQL, "true");
	/*	props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		props.put(Environment.CACHE_REGION_FACTORY, 
				"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		*/
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setPackagesToScan(new String[] {"com.allstate.training.ffd.entites"});
		sessionFactory.setAnnotatedClasses(Customer.class);
		/*sessionFactory.setAnnotatedClasses(Passenger.class);
		sessionFactory.setAnnotatedClasses(Route.class);
		sessionFactory.setAnnotatedClasses(Schedule.class);
		sessionFactory.setAnnotatedClasses(Ship.class);
		sessionFactory.setAnnotatedClasses(Ticket.class);
		sessionFactory.setAnnotatedClasses(User.class);
		sessionFactory.setAnnotatedClasses(Admin.class);
*/
		return sessionFactory;
	}

}
