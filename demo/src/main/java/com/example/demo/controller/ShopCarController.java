package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.entity.Shopcar;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.ShopcarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class ShopCarController {
    @Autowired
    ShopcarService shopcarService;

    @GetMapping("/api/shopcar")
    public Result getMethodName() {
        return ResultFactory.buildSuccessResult(shopcarService.list());
    }
    
    @PostMapping("/api/shopcar/add")
    public Result addOrDataShopcar(@RequestBody @Valid Shopcar shopcar) {
        shopcarService.addOrUpdate(shopcar);
        return ResultFactory.buildFailResult("操作成功");
    }

    @PostMapping("/api/shopcar/delete")
    public Result deleteShopcar(@RequestBody @Valid Shopcar shopcar) {
        shopcarService.deleteById(shopcar.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
