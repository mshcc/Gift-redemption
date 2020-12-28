package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gift-back-producer")
public interface GiftCardService {
    @PostMapping("giftCard/addGiftCard")
    public HttpResult addGiftCard(@RequestParam("num") int num);

    @PostMapping("giftCard/listGiftCard")
    public HttpResult listGiftCard(@RequestBody PageRequest pageRequest);

    @PostMapping("giftCard/deleteGiftCard/{id}")
    public HttpResult delete(@PathVariable int id);

    @PostMapping("giftCard/updateGiftCardDate/{id}")
    public HttpResult updateDate( @PathVariable int id);
}
