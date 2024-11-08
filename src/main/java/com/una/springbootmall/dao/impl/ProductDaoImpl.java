package com.una.springbootmall.dao.impl;

import com.una.springbootmall.dao.ProductDao;
import com.una.springbootmall.model.Product;
import com.una.springbootmall.rollmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    // 注入  namedParameterJdbcTemplate 這個bean
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {  // 第五章
        String sql = "select product_id , product_name, category, image_url, price, stock, description, created_date, last_modified_date from product where product_id= :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
//      將sql中的參數productId傳進去

//      使用 namedParameterJdbcTemplate 的query方法去執行select的sql語法，去查詢這筆商品
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }
}
