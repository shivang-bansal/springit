package com.shiv.springit;

import com.shiv.springit.model.Comment;
import com.shiv.springit.model.Link;
import com.shiv.springit.repository.CommentRepository;
import com.shiv.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

	private static final Logger log= LoggerFactory.getLogger(SpringitApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
		return args -> {
			Link link=new Link("Hello from SpringBoot","https://spring.io/");
			linkRepository.save(link);

			Comment comment=new Comment("This link is awesome",link);
			commentRepository.save(comment);
			link.addComment(comment);


		};
	}
}
