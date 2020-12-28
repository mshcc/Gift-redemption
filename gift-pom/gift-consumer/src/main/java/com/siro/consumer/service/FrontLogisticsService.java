package com.siro.consumer.service;

import com.siro.http.HttpResult;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gift-producer")
public interface FrontLogisticsService {
    @PostMapping("front/addLogistic/{exchangeId}")
    public HttpResult addLogistic(@RequestParam int giftId,
                                  @RequestParam int recipientId,
                                  @PathVariable int exchangeId);

}
