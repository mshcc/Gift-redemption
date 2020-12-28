package com.siro.consumer.controller.reception;

import com.siro.consumer.service.FrontExchangeService;
import com.siro.http.HttpResult;
import com.siro.vo.GiftCardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class FrontExchangeController {
    @Autowired
    private FrontExchangeService frontExchangeService;
    @PostMapping("exchange/{id}")
    public HttpResult addExchange(@PathVariable int id, @RequestBody GiftCardBean giftCardBean){
        return frontExchangeService.addExchange(id,giftCardBean);
    }
}
