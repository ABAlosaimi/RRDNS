package com.dnslb.dnsloadblancer.RRDNS;

import java.util.concurrent.TimeUnit;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {
        /**
         * Configures a Caffeine cache manager with a specific expiration time and maximum size.
         * 
         * @return CacheManager instance configured with Caffeine.
         */
        @Bean
        public CacheManager cacheManager(){
                CaffeineCacheManager cacheManager = new CaffeineCacheManager();
            cacheManager.setCaffeine(Caffeine.newBuilder()
                             .expireAfterWrite(30, TimeUnit.SECONDS) // Adjust based on expected TTL
                             .maximumSize(100));
            
              return cacheManager;
        }
}
