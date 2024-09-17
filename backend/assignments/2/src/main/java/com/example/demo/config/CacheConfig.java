package com.example.demo.config;


import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableCaching
public class CacheConfig {
    /**
     * Creates and configures a Caffeine {@link CacheManager} bean.
     *
     * @return An instance of {@link CaffeineCacheManager}.
     */

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeineConfig());
        return caffeineCacheManager;
    }
    /**
     * Configures the Caffeine cache with specific properties.
     *
     * @return A {@link Caffeine} object with defined maximum size and expiration settings.
     */
    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder().maximumSize(3).
                expireAfterWrite(60, TimeUnit.MINUTES);
    }


}
