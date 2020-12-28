package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.vo.RecipientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@FeignClient(name = "gift-producer")
public interface FrontRecipientService {
    @PostMapping("front/addRecipient")
    HttpResult addRecipient(@RequestBody RecipientBean recipientBean);
}
