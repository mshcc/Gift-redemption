package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.vo.GiftCardBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gift-front-producer")
public interface FrontExchangeService {

    @PostMapping("front/exchange/{id}")
    public HttpResult addExchange(@PathVariable int id, @RequestBody GiftCardBean giftCardBean);
}
