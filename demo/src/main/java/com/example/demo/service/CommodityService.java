package com.example.demo.service;

import com.example.demo.dao.CommodityDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Commodity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    CommodityDAO commodityDAO;
    @Autowired
    CategoryService categoryService;

    public List<Commodity> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return commodityDAO.findAll(sort);
    }

    public void addOrUpdate(Commodity commodity) {
        commodityDAO.save(commodity);
    }

    public void deleteById(int id) {
        commodityDAO.deleteById(id);
    }

    public List<Commodity> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return commodityDAO.findAllByCategory(category);
    }

    public List<Commodity> Search(String keywords) {
        return commodityDAO.findAllByNameLikeOrSellerLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
