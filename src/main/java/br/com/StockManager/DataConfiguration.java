package br.com.StockManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/stock_db?useTimezone=true&serverTimezone=UTC&createDatabaseIfNotExist=true");
	        dataSource.setUsername("root");
	        dataSource.setPassword("Tecladofoda0!");
	        return dataSource;
	    }

	    @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	        adapter.setDatabase(Database.MYSQL);
	        adapter.setShowSql(true);
	        adapter.setGenerateDdl(true);
	        adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
	        adapter.setPrepareConnection(true);
	        return adapter;

	    }
	
}
