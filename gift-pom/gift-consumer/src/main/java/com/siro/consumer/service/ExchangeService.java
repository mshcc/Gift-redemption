package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mshcc
 * @date 2020/12/27
 */

@FeignClient(name = "gift-back-producer")
public interface ExchangeService {
    @PostMapping("exchange/listExchanges")
    public HttpResult listExchanges(@RequestBody PageRequest pageRequest);
}
