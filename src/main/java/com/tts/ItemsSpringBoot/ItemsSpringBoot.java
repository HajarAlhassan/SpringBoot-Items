package com.tts.ItemsSpringBoot;

		import com.tts.ItemsSpringBoot.model.Item;
		import com.tts.ItemsSpringBoot.repository.ItemRepository;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.Bean;
		import org.springframework.http.CacheControl;
		import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

		import java.util.List;
		import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ItemsSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(ItemsSpringBoot.class, args);
	}


	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
@Bean
public CommandLineRunner demo2(ItemRepository repository) {
	return (args) -> {
		Item shoes= new Item("Nike", "Shoes");
		Item cloth= new Item("Shirt", "Top");

		repository.saveAll(List.of(shoes,cloth));
		repository.save(new Item("Trousers","Bottom"));

		System.out.println("Items found with getItems():");
			System.out.println("-------------------------------");
			for (Item item : repository.findAll()) {
				System.out.println(item.toString());
			}
			System.out.println("");

			// read an individual Item by ID
			repository.findById(1L)
					.ifPresent(item -> {
						System.out.println("Item found with findById(1L):");
						System.out.println("--------------------------------");
						System.out.println(item.toString());
						System.out.println("");
					});

			// read items by  type
			System.out.println("Customer found with findByLastName('Patterson'):");
			System.out.println("--------------------------------------------");
		repository.findByType("Top").forEach(item -> {
			System.out.println(item);
			});

			System.out.println("");


	};
}
}
