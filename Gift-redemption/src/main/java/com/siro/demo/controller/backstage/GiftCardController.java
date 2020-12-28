package com.siro.demo.controller.backstage;

import com.siro.demo.model.Giftcard;
import com.siro.demo.service.GiftcardService;
import com.siro.demo.utils.RandomStringUtils;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class GiftCardController {
    @Autowired
    private GiftcardService giftcardService;

    @PostMapping("addGiftCard")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult addGiftCard(@RequestParam("num") int num) {
        Date date = new Date();
        Date start = date;
        System.out.println(start);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +30);
        Date end = calendar.getTime();
        List<Giftcard> giftCards=new ArrayList<>();
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

    @PostMapping("listGiftCard")
    @PreAuthorize("hasAuthority('user')")
    public HttpResult listGiftCard(@RequestBody PageRequest pageRequest) {
        PageResult page = giftcardService.findPage(pageRequest);
        return HttpResult.ok(page);
    }

    @PostMapping("deleteGiftCard/{id}")
    @PreAuthorize("hasAuthority('user')")
    public HttpResult delete(@PathVariable int id) {
        giftcardService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }



    @PostMapping("updateGiftCardDate/{id}")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult updateDate(@PathVariable int id) {
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
