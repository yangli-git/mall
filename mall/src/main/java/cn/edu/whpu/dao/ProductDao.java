package cn.edu.whpu.dao;

import cn.edu.whpu.pojo.Product;

import java.util.List;

public interface ProductDao {

    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);

    //查询当前分类商品的总记录数
    public long findTotalCount(int cateid);

    //查询当前的集合信息
    public List<Product> findByPage(int cateid,int start,int pageSize);

    //根据id查询
    public Product findById(int id);

    void add(Product product);
}
