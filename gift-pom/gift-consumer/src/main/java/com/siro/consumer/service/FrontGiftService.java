package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@FeignClient(name = "gift-producer")
public interface FrontGiftService {
    @PostMapping("front/showGifts")
    public HttpResult listGifts(@RequestBody PageRequest pageRequest);

    @GetMapping("front/showGiftDetails/{id}")
    public HttpResult showGiftDetails(@PathVariable int id);
}
