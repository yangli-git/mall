package cn.edu.whpu.dao.impl;

import cn.edu.whpu.dao.CategoryDao;
import cn.edu.whpu.pojo.Category;
import cn.edu.whpu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {

        String sql ="select * from category";

        try {
            List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
