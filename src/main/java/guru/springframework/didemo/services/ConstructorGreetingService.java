package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService{
	
	@Override
	public String sayGreeting() {
		return "Hola - was injected via a constructor";
	}
}
