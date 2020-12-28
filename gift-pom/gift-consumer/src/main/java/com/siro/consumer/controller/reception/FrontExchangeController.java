package com.siro.consumer.controller.reception;

import com.siro.consumer.service.FrontExchangeService;
import com.siro.http.HttpResult;
import com.siro.vo.GiftCardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
@RequestMapping("front")
public class FrontExchangeController {
    @Autowired
    private FrontExchangeService frontExchangeService;
    @PostMapping("exchange/{id}")
    public HttpResult addExchange(@PathVariable int id, @RequestBody GiftCardBean giftCardBean){
        return frontExchangeService.addExchange(id,giftCardBean);
    }
}
