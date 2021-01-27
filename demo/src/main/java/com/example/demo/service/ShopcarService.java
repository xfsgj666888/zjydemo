package com.example.demo.service;

import com.example.demo.entity.Shopcar;
import com.example.demo.dao.ShopcarDAO;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ShopcarService {
    @Autowired
    ShopcarDAO shopcarDAO;

    public List<Shopcar> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return shopcarDAO.findAll(sort);
    }

    public void addOrUpdate(Shopcar shopcar) {
        shopcarDAO.save(shopcar);
    }

    public void deleteById(int id) {
        shopcarDAO.deleteById(id);
    }
}
