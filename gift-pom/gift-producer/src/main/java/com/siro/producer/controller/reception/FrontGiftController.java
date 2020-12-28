package com.siro.producer.controller.reception;

import com.siro.http.HttpResult;
import com.siro.model.Category;
import com.siro.model.Gift;
import com.siro.model.Picture;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.producer.service.GiftService;
import com.siro.producer.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@RestController
@RequestMapping("front")
@Api(tags = "查询礼品")
public class FrontGiftController {

    @Autowired
    private GiftService giftService;
    @Autowired
    private PictureService pictureService;

    @ApiOperation(value = "该接口用于分页查询礼品信息")
    @PostMapping("showGifts")
    public HttpResult listGifts(@ApiParam(value = "分页信息") @RequestBody PageRequest pageRequest) {
        PageResult page = giftService.findPage(pageRequest);
        List<Gift> content = (List<Gift>) page.getContent();
        for (Gift gift : content) {
            List<String> lists = new ArrayList<>();
            List<Picture> gift1 = pictureService.findPictureByCategoryAndCategoryId(new Category("gift", gift.getId()));
            for (Picture picture : gift1) {
                lists.add(picture.getPicpath());
            }
            gift.setPictures(lists);
        }
        return HttpResult.ok(page);
    }
    @ApiOperation(value = "该接口用于查询礼品详情")
    @GetMapping("showGiftDetails/{id}")
    public HttpResult showGiftDetails(@ApiParam(value = "礼品id", required = true,example = "1")
                                          @PathVariable int id) {
        Gift gift = giftService.selectByPrimaryKey(id);
        List<Picture> gift1 = pictureService.findPictureByCategoryAndCategoryId(new Category("gift", id));
        List<String> list = new ArrayList<>();
        for (Picture picture : gift1) {
            list.add(picture.getPicpath());
        }
        gift.setPictures(list);
        return HttpResult.ok(gift);
    }
}
