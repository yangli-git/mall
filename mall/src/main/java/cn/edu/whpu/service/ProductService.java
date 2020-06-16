package cn.edu.whpu.service;

import cn.edu.whpu.common.PageBean;
import cn.edu.whpu.pojo.Product;

import java.util.List;

public interface ProductService {

    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);

    //根据商品分类进行分页查询
    public PageBean<Product> findPage(int cateid, int currentPage, int pageSize);


    //根据id查询
    public Product findById(int id);

    void add(Product product);
}
