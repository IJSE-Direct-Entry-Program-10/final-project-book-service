package lk.ijse.dep10.library.book;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}

/* What does @SpringBootApplication do? */
// The annotated class itself becomes a Configuration class (SpringBootConfiguration)
// It enables the Component Scan
// It enables Auto Configurations