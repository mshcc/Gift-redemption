package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.vo.RecipientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gift-producer")
public interface RecipientService {
    @PostMapping("recipient/listRecipients")
    public HttpResult listRecipients(@RequestBody PageRequest pageRequest);

    @PostMapping("recipient/getRecipientById/{id}")
    public HttpResult getRecipientById(@PathVariable int id);


    @PostMapping("recipient/updateRecipirnt/{id}")
    public HttpResult updateRecipients(@RequestBody RecipientBean recipientBean, @PathVariable int id);
}
