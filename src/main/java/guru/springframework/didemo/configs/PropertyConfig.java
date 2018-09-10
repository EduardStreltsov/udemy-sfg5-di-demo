package guru.springframework.didemo.configs;

import guru.springframework.didemo.examplebeans.FakeDataSource;
import guru.springframework.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({
		@PropertySource("classpath:datasource.properties"),
		@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {
	
	@Autowired
	Environment environment;
	
	@Value("${guru.user}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.url}")
	String url;
	
	@Value("${guru.jms.user}")
	String jmsuser;
	
	@Value("${guru.jms.password}")
	String jmspassword;
	
	@Value("${guru.jms.url}")
	String jmsurl;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
//		fakeDataSource.setUser(environment.getProperty("USER"));
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(jmsuser);
		fakeJmsBroker.setPassword(jmspassword);
		fakeJmsBroker.setUrl(jmsurl);
		return fakeJmsBroker;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer property = new PropertySourcesPlaceholderConfigurer();
		return property;
	}
	
}
