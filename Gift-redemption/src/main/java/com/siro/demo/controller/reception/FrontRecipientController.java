package com.siro.demo.controller.reception;

import com.siro.demo.model.Recipient;
import com.siro.demo.service.RecipientService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.vo.RecipientBean;
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
public class FrontRecipientController {

    @Autowired
    private RecipientService recipientService;

    @PostMapping("addRecipient")
    public HttpResult addRecipient(@RequestBody RecipientBean recipientBean) {
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
