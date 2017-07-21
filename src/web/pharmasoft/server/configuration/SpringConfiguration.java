package web.pharmasoft.server.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@PropertySource("classpath:ApplicationResources.properties")
public class SpringConfiguration {

	@Autowired
	Environment env;
	
	@Bean(name="dataSource")
	@Profile("local")
	public DataSource localDataSource(){
		ComboPooledDataSource datasource = new ComboPooledDataSource();			
		try{		
			datasource.setDriverClass("com.mysql.jdbc.Driver");
			datasource.setJdbcUrl(env.getProperty("localdatabase.url"));
			datasource.setUser(env.getProperty("localdatabase.username"));
			datasource.setPassword(env.getProperty("localdatabase.password"));
			
			//CPNVP 11/06/2015 PR 8414 - START
			//Added to test Stale DB issue			
			datasource.setPreferredTestQuery("SELECT 1");
			datasource.setIdleConnectionTestPeriod(300);
			//CPNVP 11/06/2015 PR 8414 - END
			datasource.setTestConnectionOnCheckin(true);//CPNVP 12/22/2015 PR 8487 
			
			//DriverManagerDataSource datasource = new DriverManagerDataSource(env.getProperty("localdatabase.url"), env.getProperty("localdatabase.username"), env.getProperty("localdatabase.password"));		
			//datasource.setDriverClassName("com.mysql.jdbc.Driver");		
		}catch(Exception e){
			e.printStackTrace();
		}
		return datasource;
	}
	
	@Bean(name="dataSource")
	@Profile("test")
	public DataSource testDataSource(){
		ComboPooledDataSource datasource = new ComboPooledDataSource();			
		try{		
			datasource.setDriverClass("com.mysql.jdbc.Driver");
			datasource.setJdbcUrl(env.getProperty("testdatabase.url"));
			datasource.setUser(env.getProperty("testdatabase.username"));
			datasource.setPassword(env.getProperty("testdatabase.password"));
			//CPNVP 12/22/2015 PR 8487 - START
			//Added to test Stale DB issue			
			datasource.setPreferredTestQuery("SELECT 1");
			datasource.setIdleConnectionTestPeriod(300);
			datasource.setTestConnectionOnCheckin(true); 
			//CPNVP 12/22/2015 PR 8487 - END
		}catch(Exception e){
			e.printStackTrace();
		}
		/*DriverManagerDataSource datasource = new DriverManagerDataSource(env.getProperty("testdatabase.url"), env.getProperty("testdatabase.username"), env.getProperty("testdatabase.password"));		
		datasource.setDriverClassName("com.mysql.jdbc.Driver");		*/
		return datasource;
	}
	
	
	@Bean(name="dataSource")
	@Profile("prod")
	public DataSource prodDataSource(){
		ComboPooledDataSource datasource = new ComboPooledDataSource();			
		try{		
			datasource.setDriverClass("com.mysql.jdbc.Driver");
			datasource.setJdbcUrl(env.getProperty("proddatabase.url"));
			datasource.setUser(env.getProperty("proddatabase.username"));
			datasource.setPassword(env.getProperty("proddatabase.password"));
			//CPNVP 12/22/2015 PR 8487 - START
			//Added to test Stale DB issue			
			datasource.setPreferredTestQuery("SELECT 1");
			datasource.setIdleConnectionTestPeriod(300);
			datasource.setTestConnectionOnCheckin(true); 
			//CPNVP 12/22/2015 PR 8487 - END
		}catch(Exception e){
			e.printStackTrace();
		}
		/*DriverManagerDataSource datasource = new DriverManagerDataSource(env.getProperty("proddatabase.url"), env.getProperty("proddatabase.username"), env.getProperty("proddatabase.password"));		
		datasource.setDriverClassName("com.mysql.jdbc.Driver");	*/	
		return datasource;
	}
	
}
