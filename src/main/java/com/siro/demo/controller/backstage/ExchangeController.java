package com.siro.demo.controller.backstage;

import com.siro.demo.service.ExchangeService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.utils.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("exchange")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("listExchanges")
    public HttpResult listExchanges(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(exchangeService.findPage(pageRequest));
    }

}
