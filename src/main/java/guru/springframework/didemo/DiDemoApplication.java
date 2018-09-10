package guru.springframework.didemo;

import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.examplebeans.FakeDataSource;
import guru.springframework.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		
		MyController controller = (MyController) ctx.getBean("myController");
		
//		System.out.println(controller.hello());
//		System.out.println(ctx.getBean(PropertyInjectedController.class).greetingServiceImpl.sayGreeting());
//		System.out.println(ctx.getBean(SetterInjectedController.class).sayGreeting());
//		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayGreeting());
		
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUser());
		
		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUser());
		
	}
}
