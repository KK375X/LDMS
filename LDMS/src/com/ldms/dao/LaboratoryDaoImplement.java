package com.ldms.dao;

import com.ldms.pojo.Laboratory;
import com.ldms.pojo.LaboratoryUse;
import com.ldms.utils.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryDaoImplement implements LaboratoryDao {

    DBUtil dbUtil = new DBUtil();//获取工具类对象

    // 查询数据库，显示数据列表（已淘汰）

    /**
     * 显示实验室数据列表
     *
     * @return
     */
    @Override
    public List<Object> selectLaboratoryList() {
        try {
            String sql = "select * from laboratoryinfo";
            Statement st = dbUtil.getStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                Laboratory laboratory = new Laboratory();
                laboratory.setLaboratoryId(rs.getString("laboratoryId"));
                laboratory.setLaboratoryName(rs.getString("laboratoryName"));
                laboratory.setTeacherId(rs.getString("teacherId"));
                laboratory.setState(rs.getString("state"));
                laboratory.setAddress(rs.getString("address"));
                laboratory.setCreateDate(rs.getString("createDate"));
                list.add(laboratory);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 暂时还没有创建相关的数据表，先空着
    @Override
    public List<Object> selectLaboratoryUseList() {
        return null;
    }


    // 查询数据库，实现信息表显示和分页功能

    /**
     * 实现实验室信息表显示和分页的列表
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectLaboratoryList(String page, String limit) {
        try {
            String sql = "select * from laboratoryinfo limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                Laboratory laboratory = new Laboratory();
                laboratory.setLaboratoryId(rs.getString("laboratoryId"));
                laboratory.setLaboratoryName(rs.getString("laboratoryName"));
                laboratory.setTeacherId(rs.getString("teacherId"));
                laboratory.setState(rs.getString("state"));
                laboratory.setAddress(rs.getString("address"));
                laboratory.setCreateDate(rs.getString("createDate"));
                list.add(laboratory);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算实验室信息数据的总和
     *
     * @return
     */
    @Override
    public int countLaboratoryInfo() {
        try {
            String sql = "select count(*) as countLaboratory from laboratoryinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countLaboratory");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectLaboratoryUseList(String page, String limit) {
        try {
            String sql = "select * from laboratoryuseinfo limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                LaboratoryUse laboratoryUse = new LaboratoryUse();
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                laboratoryUse.setTeacherId(rs.getString("teacherId"));
                laboratoryUse.setUseDate(rs.getString("useDate"));
                laboratoryUse.setBeginTime(rs.getString("beginTime"));
                laboratoryUse.setEndTime(rs.getString("endTime"));
                laboratoryUse.setState(rs.getString("state"));
                list.add(laboratoryUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public int countLaboratoryUseInfo() {
        try {
            String sql = "select count(*) as countLaboratoryUse from laboratoryuseinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countLaboratoryUse");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // 添加实验室信息，实现添加功能

    /**
     * @param laboratory
     * @return
     */
    @Override
    public int addLaboratory(Laboratory laboratory) {
        try {
            String sql = "insert into laboratoryinfo(laboratoryId,laboratoryName,teacherId,state,address,createDate) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratory.getLaboratoryId());
            ps.setString(2, laboratory.getLaboratoryName());
            ps.setString(3, laboratory.getTeacherId());
            ps.setString(4, laboratory.getState());
            ps.setString(5, laboratory.getAddress());
            ps.setString(6, laboratory.getCreateDate());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                dbUtil.commit();
                return 1;
            } else {
                dbUtil.connectionRollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param laboratoryUse
     * @return
     */
    @Override
    public int addLaboratoryUse(LaboratoryUse laboratoryUse) {
        try {
            String sql = "insert into laboratoryuseinfo(laboratoryId,teacherId,useDate,beginTime,endTime,state) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratoryUse.getLaboratoryId());
            ps.setString(2, laboratoryUse.getTeacherId());
            ps.setString(3, laboratoryUse.getUseDate());
            ps.setString(4, laboratoryUse.getBeginTime());
            ps.setString(5, laboratoryUse.getEndTime());
            ps.setString(6, laboratoryUse.getState());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                dbUtil.commit();
                return 1;
            } else {
                dbUtil.connectionRollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param laboratoryId
     * @return
     */
    @Override
    public Laboratory selectLaboratory(String laboratoryId) {
        try {
            String sql = "select * from laboratoryinfo where laboratoryId=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, laboratoryId);//定义 ？ 的属性
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Laboratory laboratory = new Laboratory();
            while (rs.next()) {//循环找到符合的用户ID和密码
                laboratory.setLaboratoryId(rs.getString("laboratoryId"));
                return laboratory;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }

    /**
     * @param laboratoryId
     * @return
     */
    @Override
    public LaboratoryUse selectLaboratoryUse(String laboratoryId) {
        try {
            String sql = "select * from laboratoryuseinfo where laboratoryId=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, laboratoryId);//定义 ？ 的属性
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            LaboratoryUse laboratoryUse = new LaboratoryUse();
            while (rs.next()) {//循环找到符合的用户ID和密码
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                return laboratoryUse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }


    // 搜索功能

    /**
     * @param laboratoryId
     * @param laboratoryName
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchLaboratoryList(String laboratoryId, String laboratoryName, String state, String page, String limit) {
        try {
            String sql = "select * from laboratoryinfo where laboratoryId like '%" + laboratoryId + "%' and laboratoryName like '%" + laboratoryName + "%' and state like '%" + state + "%' limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                Laboratory laboratory = new Laboratory();
                laboratory.setLaboratoryId(rs.getString("laboratoryId"));
                laboratory.setLaboratoryName(rs.getString("laboratoryName"));
                laboratory.setTeacherId(rs.getString("teacherId"));
                laboratory.setState(rs.getString("state"));
                laboratory.setAddress(rs.getString("address"));
                laboratory.setCreateDate(rs.getString("createDate"));
                list.add(laboratory);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param laboratoryId
     * @param teacherId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchLaboratoryUseList(String laboratoryId, String teacherId, String page, String limit) {
        try {
            String sql = "select * from laboratoryuseinfo where laboratoryId like '%" + laboratoryId + "%' and teacherId like '%" + teacherId + "%' limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                LaboratoryUse laboratoryUse = new LaboratoryUse();
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                laboratoryUse.setTeacherId(rs.getString("teacherId"));
                laboratoryUse.setUseDate(rs.getString("useDate"));
                laboratoryUse.setBeginTime(rs.getString("beginTime"));
                laboratoryUse.setEndTime(rs.getString("endTime"));
                laboratoryUse.setState(rs.getString("state"));
                list.add(laboratoryUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 删除功能

    /**
     * @param laboratoryId
     */
    @Override
    public void deleteLaboratory(String laboratoryId) {
        try {
            String sql = "delete from laboratoryinfo where laboratoryId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratoryId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param laboratoryId
     */
    @Override
    public void deleteLaboratoryUse(String laboratoryId) {
        try {
            String sql = "delete from laboratoryuseinfo where laboratoryId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratoryId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 实验室使用申请列表

    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectAskLaboratoryUseList(String page, String limit) {
        try {
            String sql = "select * from laboratoryuseinfo where state=? limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, "待审核");
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                LaboratoryUse laboratoryUse = new LaboratoryUse();
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                laboratoryUse.setTeacherId(rs.getString("teacherId"));
                laboratoryUse.setUseDate(rs.getString("useDate"));
                laboratoryUse.setBeginTime(rs.getString("beginTime"));
                laboratoryUse.setEndTime(rs.getString("endTime"));
                laboratoryUse.setState(rs.getString("state"));
                list.add(laboratoryUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public int countAskLaboratoryUseInfo() {
        try {
            String sql = "select count(*) as countAskLaboratoryUse from laboratoryuseinfo where state='待审核'";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countAskLaboratoryUse");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // 教师个人使用实验室记录

    /**
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectTeacherLaboratoryUseList(String page, String limit, String id) {
        try {
            String sql = "select * from laboratoryuseinfo where teacherId=? limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, id);
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                LaboratoryUse laboratoryUse = new LaboratoryUse();
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                laboratoryUse.setTeacherId(rs.getString("teacherId"));
                laboratoryUse.setUseDate(rs.getString("useDate"));
                laboratoryUse.setBeginTime(rs.getString("beginTime"));
                laboratoryUse.setEndTime(rs.getString("endTime"));
                laboratoryUse.setState(rs.getString("state"));
                list.add(laboratoryUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int countTeacherLaboratoryUseInfo(String id) {
        try {
            String sql = "select count(*) as countLaboratoryUse from laboratoryuseinfo where teacherId=" + id + "";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countLaboratoryUse");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * @param laboratoryId
     * @param useDate
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchUserLaboratoryUseList(String laboratoryId, String useDate, String id, String page, String limit) {
        try {
            String sql = "select * from laboratoryuseinfo where teacherId=? and laboratoryId like '%" + laboratoryId + "%' and useDate like '%" + useDate + "%' limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, id);
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                LaboratoryUse laboratoryUse = new LaboratoryUse();
                laboratoryUse.setLaboratoryId(rs.getString("laboratoryId"));
                laboratoryUse.setTeacherId(rs.getString("teacherId"));
                laboratoryUse.setUseDate(rs.getString("useDate"));
                laboratoryUse.setBeginTime(rs.getString("beginTime"));
                laboratoryUse.setEndTime(rs.getString("endTime"));
                laboratoryUse.setState(rs.getString("state"));
                list.add(laboratoryUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
