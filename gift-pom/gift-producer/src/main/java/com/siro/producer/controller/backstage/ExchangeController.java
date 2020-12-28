package com.siro.producer.controller.backstage;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.producer.service.ExchangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "兑换记录")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @ApiOperation(value = "该接口用分页查询兑换记录")
    @PostMapping("listExchanges")
    public HttpResult listExchanges(@ApiParam(value = "分页参数") @RequestBody PageRequest pageRequest) {
        return HttpResult.ok(exchangeService.findPage(pageRequest));
    }

}
