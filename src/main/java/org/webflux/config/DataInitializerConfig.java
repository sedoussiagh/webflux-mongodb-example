package org.webflux.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.webflux.entity.Item;
import org.webflux.repository.ItemRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class DataInitializerConfig {

  @Autowired
  private ItemRepo itemRepository;

  @Bean
  public CommandLineRunner dataInitializer() {
    return args -> {
      ObjectMapper objectMapper = new ObjectMapper();
      TypeReference<List<Item>> typeReference = new TypeReference<>() {
      };

      try {
        Resource resource = new ClassPathResource("data/data.json");
        InputStream inputStream = resource.getInputStream();

        List<Item> items = objectMapper.readValue(inputStream, typeReference);
        itemRepository.saveAll(items);
      } catch (IOException e) {
        System.out.println("Unable to load data: " + e.getMessage());
      }
    };
  }
}
