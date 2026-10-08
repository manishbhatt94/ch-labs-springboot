package dev.moneysh.portfolio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyConfig {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
