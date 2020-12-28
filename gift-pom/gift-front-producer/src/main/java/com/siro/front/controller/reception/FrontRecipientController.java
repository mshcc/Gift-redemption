package com.siro.front.controller.reception;

import com.siro.http.HttpResult;
import com.siro.model.Recipient;
import com.siro.front.service.RecipientService;
import com.siro.vo.RecipientBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/25
 */

@RestController
@RequestMapping("front")
@Api(tags = "添加收件人")
public class FrontRecipientController {

    @Autowired
    private RecipientService recipientService;


    @ApiOperation(value = "该接口用于添加收件人信息")
    @PostMapping("addRecipient")
    public HttpResult addRecipient(@ApiParam(value = "收件人") @RequestBody RecipientBean recipientBean) {
        String name = recipientBean.getName();
        String address = recipientBean.getAddress();
        String phone = recipientBean.getPhone();
        List<Recipient> list = recipientService.findListByName(name);
        for (Recipient recipient : list) {
            if (recipient.getName().equals(name) && recipient.getAddress().equals(address) && recipient.getPhone().equals(phone)) {
                return HttpResult.ok("该收件人信息已存在，id:=" + recipient.getId());
            }
        }
        Recipient recipient = new Recipient();
        recipient.setName(name);
        recipient.setAddress(address);
        recipient.setPhone(phone);
        recipientService.insertSelective(recipient);
        return HttpResult.ok("收件人信息存储成功,id:=" + recipient.getId());
    }
}
