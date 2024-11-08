package com.una.springbootmall.service.impl;


import com.una.springbootmall.dao.ProductDao;
import com.una.springbootmall.model.Product;
import com.una.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
