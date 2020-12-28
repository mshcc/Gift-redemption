package com.siro.back.controller.backstage;

import com.siro.http.HttpResult;
import com.siro.model.Giftcard;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.back.service.GiftcardService;
import com.siro.back.utils.RandomStringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@RestController
@RequestMapping("giftCard")
@Api(tags = "礼品卡操作")
public class GiftCardController {
    @Autowired
    private GiftcardService giftcardService;

    @PostMapping("addGiftCard")
    @ApiOperation(value = "该接口用于添加礼品卡")
    public HttpResult addGiftCard(@ApiParam(value = "添加数量", required = true, example = "10") @RequestParam("num") int num) {
        Date date = new Date();
        Date start = date;
        System.out.println(start);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +30);
        Date end = calendar.getTime();
        List<Giftcard> giftCards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String key = RandomStringUtils.getString(10);
            String value = RandomStringUtils.getString(8);
            Giftcard giftcard = new Giftcard();
            giftcard.setCardnumber(key);
            giftcard.setCardsecret(value);
            giftcard.setCreationtime(start);
            giftcard.setExpiration(end);
            giftCards.add(giftcard);
        }
        giftcardService.insertList(giftCards);
        return HttpResult.ok("礼品卡生成成功！");
    }

    @ApiOperation(value = "该接口用于分页查询礼品卡")
    @PostMapping("listGiftCard")
    public HttpResult listGiftCard(@ApiParam(value = "分页参数") @RequestBody PageRequest pageRequest) {
        PageResult page = giftcardService.findPage(pageRequest);
        return HttpResult.ok(page);
    }

    @ApiOperation(value = "该接口用于删除礼品卡")
    @PostMapping("deleteGiftCard/{id}")
    public HttpResult delete(@ApiParam(value = "id", required = true, example = "1") @PathVariable int id) {
        giftcardService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }


    @PostMapping("updateGiftCardDate/{id}")
    @ApiOperation(value = "该接口用于更新礼品卡过期时间")
    public HttpResult updateDate(@ApiParam(value = "id", required = true, example = "1") @PathVariable int id) {
        Giftcard giftcard = giftcardService.selectByPrimaryKey(id);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +30);
        date = calendar.getTime();
        giftcard.setExpiration(date);
        giftcardService.updateByPrimaryKeySelective(giftcard);
        return HttpResult.ok("礼品卡有效期更新成功");
    }

}
