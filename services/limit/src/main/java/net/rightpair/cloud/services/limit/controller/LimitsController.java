package net.rightpair.cloud.services.limit.controller;

import lombok.RequiredArgsConstructor;
import net.rightpair.cloud.services.limit.config.LimitsConfig;
import net.rightpair.cloud.services.limit.dto.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final LimitsConfig limitsConfig;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsConfig.getMinimum(), limitsConfig.getMaximum());
    }
}
