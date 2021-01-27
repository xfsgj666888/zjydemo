package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.CommodityService;
import com.example.demo.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

@RestController
public class ShopController {
    @Autowired
    CommodityService commodityService;

    @GetMapping("/api/commodities")
    public Result listCommodities() {
        return ResultFactory.buildSuccessResult(commodityService.list());
    }

    @PostMapping("/api/seller/commodities")
    public Result addOrdateCommodities(@RequestBody @Valid Commodity commodity) {
        commodityService.addOrUpdate(commodity);
        return ResultFactory.buildSuccessResult("操作成功");
    }

    @PostMapping("/api/seller/commodities/delete")
    public Result deleteCommodity(@RequestBody @Valid Commodity commodity) {
        commodityService.deleteById(commodity.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @GetMapping("/api/search")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(commodityService.list());
        } else {
            return ResultFactory.buildSuccessResult(commodityService.Search(keywords));
        }
    }

    @GetMapping("/api/categories/{cid}/commodities")
    public Result listByCategory(@PathVariable("cid") int cid) {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(commodityService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(commodityService.list());
        }
    }

    @PostMapping("/api/seller/commodities/picture")
    public String coversUpload(MultipartFile file) {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
