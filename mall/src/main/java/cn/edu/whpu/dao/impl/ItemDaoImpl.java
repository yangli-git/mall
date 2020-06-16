package cn.edu.whpu.dao.impl;

import cn.edu.whpu.pojo.Item;
import cn.edu.whpu.utils.JDBCUtils;
import cn.edu.whpu.dao.ItemDao;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {
QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());


    @Override
    public void add(Item item) {
        String sql = "insert into item values(null,?,?,?,?,?)";
        try {
            runner.update(sql,item.getOrder_id(),item.getProduct_id(),item.getAmount(),item.getTotal_price(),item.getPayment_price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
