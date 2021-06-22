package com.liumq.smbms.dao.user;

import com.liumq.smbms.dao.BaseDao;
import com.liumq.smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDaoImpl implements UserDao {
    public User getLoginUser(Connection connection, String userCode) throws SQLException {


        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;


        if (connection != null) {
            String sql = "select * from smbms_user where userCode  =?";
            Object[] params = {userCode};


            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                //读取数据库
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getLong("createBy"));
                user.setCreationDate(rs.getDate("createDate"));
                user.setModifyBy(rs.getLong("modifyBy"));
                user.setModifyDate(rs.getDate("modifyDate"));
            }
            BaseDao.closeResources(null, pstm, rs);

        }

        return user;
    }
}
