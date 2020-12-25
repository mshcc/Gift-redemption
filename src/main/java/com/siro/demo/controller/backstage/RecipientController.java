package com.siro.demo.controller.backstage;

import com.siro.demo.model.Recipient;
import com.siro.demo.service.RecipientService;
import com.siro.demo.utils.http.HttpResult;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.vo.IntegerBean;
import com.siro.demo.vo.RecipientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @author mshcc
 * @date 2020/12/25
 */
@RestController
@RequestMapping("recipient")
public class RecipientController {
    @Autowired
    private RecipientService recipientService;


    @PostMapping("listRecipients")
    public HttpResult listRecipients(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(recipientService.findPage(pageRequest));
    }


    @PostMapping("getRecipientById/{id}")
    public HttpResult getRecipientById(@PathVariable int id){
        return HttpResult.ok(recipientService.selectByPrimaryKey(id));
    }


    @PreAuthorize("hasAuthority('super')")
    @PostMapping("updateRecipirnt/{id}")
    public HttpResult updateRecipients(@RequestBody RecipientBean recipientBean,@PathVariable int id) {
        String name = recipientBean.getName();
        String address = recipientBean.getAddress();
        String phone = recipientBean.getPhone();
        Recipient recipient = recipientService.selectByPrimaryKey(id);
        recipient.setName(name);
        recipient.setAddress(address);
        recipient.setPhone(phone);
        recipientService.updateByPrimaryKeySelective(recipient);
        return HttpResult.ok("收件人信息更新成功");
    }


}
