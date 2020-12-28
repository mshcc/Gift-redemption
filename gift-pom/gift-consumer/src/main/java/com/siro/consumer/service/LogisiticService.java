package com.siro.consumer.service;

import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@FeignClient(name = "gift-back-producer")
public interface LogisiticService {
    @PostMapping("logisitics/listLogistics")
    public HttpResult listLogistics(@RequestBody PageRequest pageRequest);

    @PostMapping("logisitics/deleteLogistics/{id}")
    public HttpResult deleteLogistics(@PathVariable int id);
}
