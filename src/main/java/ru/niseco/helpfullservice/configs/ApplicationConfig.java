package ru.niseco.helpfullservice.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//класс конфигурации приложения
// здесь будут разные конфиги для корректной работы
@Configuration
public class ApplicationConfig {
    @Bean//создаем бин
    public ModelMapper modelMapper() { // создали бин, по дефолту он всегда Singleton.
        return new ModelMapper();
        /*ModelMapper - это библиотека, которая упрощает преобразование (маппинг)
        объектов между различными Java классами.
         в нашем случае используем для преобразования DTO в сущности и наоборот
         */
    }
}
