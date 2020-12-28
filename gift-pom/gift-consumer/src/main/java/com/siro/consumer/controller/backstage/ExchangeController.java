package com.siro.consumer.controller.backstage;

import com.siro.consumer.service.ExchangeService;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;


    @PostMapping("listExchanges")
    public HttpResult listExchanges(@RequestBody PageRequest pageRequest){
        return exchangeService.listExchanges(pageRequest);
    }
}
