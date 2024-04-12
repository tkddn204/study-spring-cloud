package net.rightpair.cloud.services.limit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("limits")
public class LimitsConfig {
    private Integer minimum;
    private Integer maximum;
}
