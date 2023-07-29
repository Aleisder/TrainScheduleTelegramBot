package ru.tsarenko.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class NetworkConfig {

    @Value("${yandex.token}")
    private String yandexToken;

    @Bean
    public List<MediaType> getMediaTypes() {
        return List.of(MediaType.ALL);
    }

    @Bean
    public GsonHttpMessageConverter getGsonMessageConverter(List<MediaType> mediaTypes) {
        var converter = new GsonHttpMessageConverter();
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

    @Bean
    public RestTemplate getRestTemplate(GsonHttpMessageConverter converter) {
        return new RestTemplateBuilder()
                .defaultHeader("Authorization", yandexToken)
                .rootUri("https://api.rasp.yandex.net/v3.0")
                .messageConverters(converter)
                .build();
    }
}