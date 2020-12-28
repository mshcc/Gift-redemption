package com.siro.producer.controller.reception;

import com.siro.http.HttpResult;
import com.siro.model.Logistics;
import com.siro.producer.service.LogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("front")
@Api(tags = "兑换商品")
public class FrontLogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @ApiOperation(value = "该接口用于敷衍用户，让用户觉得商品要发货了")
    @PostMapping("addLogistic/{exchangeId}")
    public HttpResult addLogistic(@ApiParam(value = "礼品id", required = true, example = "1") int giftId,
                                  @ApiParam(value = "收件人", required = true, example = "1") int recipientId,
                                  @ApiParam(value = "兑换记录id", required = true, example = "1") @PathVariable int exchangeId) {
        Logistics logistics = new Logistics();
        logistics.setGifId(giftId);
        logistics.setRecipientid(recipientId);
        logistics.setExchangeid(exchangeId);
        logisticsService.insertSelective(logistics);
        return HttpResult.ok("商品已打包，等待发货");
    }
}
