package cn;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEncryptableProperties
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Value("${spring.datasource.password")
	private String psw;
	@RequestMapping("/ma")
	public String get(){
		return psw;
	}
}