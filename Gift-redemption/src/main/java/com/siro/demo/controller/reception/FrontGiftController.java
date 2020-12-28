package com.siro.demo.controller.reception;

import com.siro.demo.model.Category;
import com.siro.demo.model.Gift;
import com.siro.demo.model.Picture;
import com.siro.demo.service.GiftService;
import com.siro.demo.service.PictureService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/24
 */
@RestController
@RequestMapping("front")
public class FrontGiftController {

    @Autowired
    private GiftService giftService;
    @Autowired
    private PictureService pictureService;

    @PostMapping("showGifts")
    public HttpResult listGifts(@RequestBody PageRequest pageRequest) {
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

    @PostMapping("showGiftDetails/{id}")
    public HttpResult showGiftDetails(@PathVariable int id) {
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
