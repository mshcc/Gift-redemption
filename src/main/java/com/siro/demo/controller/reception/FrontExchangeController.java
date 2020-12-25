package com.siro.demo.controller.reception;

import com.siro.demo.model.Exchange;
import com.siro.demo.model.Gift;
import com.siro.demo.model.Giftcard;
import com.siro.demo.service.ExchangeService;
import com.siro.demo.service.GiftService;
import com.siro.demo.service.GiftcardService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.vo.GiftCardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("front")
public class FrontExchangeController {

    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private GiftService giftService;
    @Autowired
    private GiftcardService giftcardService;

    @PostMapping("exchange/{id}")
    public HttpResult addExchange(@PathVariable int id, @RequestBody GiftCardBean giftCardBean) {
        String cardnumber = giftCardBean.getCardnumber();
        String cardsecret = giftCardBean.getCardsecret();
        Giftcard giftcard = giftcardService.findByName(cardnumber);
        if (giftcard == null) {
            return HttpResult.error("礼品卡不存在");
        }
        if (giftcard.getStatus() == 1) {
            return HttpResult.error("礼品卡已兑换");
        }
        if (giftcard.getStatus() == 2 || giftcard.getExpiration().getTime() < System.currentTimeMillis()) {
            return HttpResult.error("礼品卡已过期");
        }

        if (!cardsecret.equals(giftcard.getCardsecret())) {
            return HttpResult.error("卡密输入错误");
        }

        Gift gift = giftService.selectByPrimaryKey(id);
        if (gift == null || gift.getStock() <= 0) {
            return HttpResult.error("商品库存不足");
        }
        if (gift.getGiftstatus() == 2) {
            return HttpResult.error("商品已下架");
        }
        gift.setStock(gift.getStock() - 1);
        giftcard.setStatus(1);
        giftcardService.updateByPrimaryKeySelective(giftcard);
        giftService.updateByPrimaryKeySelective(gift);
        Exchange record = new Exchange();
        record.setGiftid(id);
        record.setCardid(giftcard.getId());
        record.setRedemption(new Date());
        exchangeService.insertSelective(record);
        return HttpResult.ok("兑换成功,兑换记录id:=" + record.getId());
    }
}
