package com.ldms.dao;

import com.ldms.pojo.Device;
import com.ldms.pojo.DeviceUse;
import com.ldms.utils.DBUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeviceDaoImplement implements DeviceDao {

    DBUtil dbUtil = new DBUtil();//获取工具类对象

    // 查询数据库，显示数据列表（已淘汰）

    /**
     * 显示设备数据列表
     *
     * @return
     */
    @Override
    public List<Object> selectDeviceList() {
        try {
            String sql = "select * from deviceinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Device device = new Device();
                device.setDeviceId(rs.getString("deviceId"));
                device.setType(rs.getString("type"));
                device.setDeviceName(rs.getString("deviceName"));
                device.setTeacherId(rs.getString("teacherId"));
                device.setState(rs.getString("state"));
                device.setLaboratoryId(rs.getString("laboratoryId"));
                device.setCreateDate(rs.getString("createDate"));
                list.add(device);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 显示设备使用数据列表
     *
     * @return
     */
    @Override
    public List<Object> selectDeviceUseList() {
        try {
            String sql = "select * from deviceuseinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 查询数据库，实现信息表显示和分页功能

    /**
     * 实现设备信息表显示和分页的列表
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectDeviceList(String page, String limit) {
        try {
            String sql = "select * from deviceinfo limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Device device = new Device();
                device.setDeviceId(rs.getString("deviceId"));
                device.setType(rs.getString("type"));
                device.setDeviceName(rs.getString("deviceName"));
                device.setTeacherId(rs.getString("teacherId"));
                device.setState(rs.getString("state"));
                device.setLaboratoryId(rs.getString("laboratoryId"));
                device.setCreateDate(rs.getString("createDate"));
                list.add(device);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算设备信息数据的总和
     *
     * @return
     */
    @Override
    public int countDeviceInfo() {
        try {
            String sql = "select count(*) as countDevice from deviceinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countDevice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 实现设备使用信息表显示和分页的列表
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectDeviceUseList(String page, String limit) {
        try {
            String sql = "select * from deviceuseinfo limit ?,?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算设备使用信息数据的总和
     *
     * @return
     */
    @Override
    public int countDeviceUseInfo() {
        try {
            String sql = "select count(*) as countDeviceUse from deviceuseinfo";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countDeviceUse");
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
    public List<Object> selectAskDeviceUseList(String page, String limit) {
        try {
            String sql = "select * from deviceuseinfo where state=? limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, "待审核");
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
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
    public int countAskDeviceUseInfo() {
        try {
            String sql = "select count(*) as countAskDeviceUse from deviceuseinfo where state='待审核'";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countAskDeviceUse");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param page
     * @param limit
     * @param id
     * @return
     */
    @Override
    public List<Object> selectUserDeviceUseList(String page, String limit, String id) {
        try {
            String sql = "select * from deviceuseinfo where userId=? limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, id);
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
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
    public int countUserDeviceUseInfo(String id) {
        try {
            String sql = "select count(*) as countDeviceUse from deviceuseinfo where userId=" + id + "";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countDeviceUse");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    // 添加设备和设备使用信息

    /**
     * @param device
     * @return
     */
    @Override
    public int addDevice(Device device) {
        try {
            String sql = "insert into deviceinfo(deviceId,type,deviceName,teacherId,state,laboratoryId,createDate) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, device.getDeviceId());
            ps.setString(2, device.getType());
            ps.setString(3, device.getDeviceName());
            ps.setString(4, device.getTeacherId());
            ps.setString(5, device.getState());
            ps.setString(6, device.getLaboratoryId());
            ps.setString(7, device.getCreateDate());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param deviceUse
     * @return
     */
    @Override
    public int addDeviceUse(DeviceUse deviceUse) {
        try {
            String sql = "insert into deviceuseinfo(deviceId,userId,useDate,beginTime,endTime,state) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceUse.getDeviceId());
            ps.setString(2, deviceUse.getUserId());
            ps.setString(3, deviceUse.getUseDate());
            ps.setString(4, deviceUse.getBeginTime());
            ps.setString(5, deviceUse.getEndTime());
            ps.setString(6, deviceUse.getState());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // 查询设备ID和使用ID，防止重复

    /**
     * @param deviceId
     * @return
     */
    @Override
    public Device selectDevice(String deviceId) {
        try {
            String sql = "select * from deviceinfo where deviceId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceId);
            ResultSet rs = ps.executeQuery();
            Device device = new Device();
            while (rs.next()) {
                device.setDeviceId(rs.getString("deviceId"));
                return device;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param deviceId
     * @param userId
     * @param useDate
     * @return
     */
    @Override
    public DeviceUse selectDeviceUse(String deviceId, String userId, Date useDate) {
        try {
            String sql = "select * from deviceinfo where deviceId=? and userId=? and useDate=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceId);
            ps.setString(2, userId);
            ps.setDate(3, (java.sql.Date) useDate);
            ResultSet rs = ps.executeQuery();
            DeviceUse deviceUse = new DeviceUse();
            while (rs.next()) {//循环找到符合的用户ID和密码
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUseDate(rs.getString("userId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                return deviceUse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }


    // 搜索功能

    /**
     * @param deviceName
     * @param type
     * @param state
     * @return
     */
    @Override
    public List<Object> searchDeviceList(String deviceName, String type, String state, String page, String limit) {
        try {
            String sql = "select * from deviceinfo where deviceName like '%" + deviceName + "%' and type like '%" + type + "%' and state like '%" + state + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Device device = new Device();
                device.setDeviceId(rs.getString("deviceId"));
                device.setType(rs.getString("type"));
                device.setDeviceName(rs.getString("deviceName"));
                device.setTeacherId(rs.getString("teacherId"));
                device.setState(rs.getString("state"));
                device.setLaboratoryId(rs.getString("laboratoryId"));
                device.setCreateDate(rs.getString("createDate"));
                list.add(device);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param deviceId
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchDeviceUseList(String deviceId, String userId, String page, String limit) {
        try {
            String sql = "select * from deviceuseinfo where deviceId like '%" + deviceId + "%' and userId like '%" + userId + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param deviceId
     * @param useDate
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchUserDeviceUseList(String deviceId, String useDate, String id, String page, String limit) {
        try {
            String sql = "select * from deviceuseinfo where userId=? and deviceId like '%" + deviceId + "%' and useDate like '%" + useDate + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setString(1, id);
            ps.setInt(2, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(3, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                DeviceUse deviceUse = new DeviceUse();
                deviceUse.setDeviceId(rs.getString("deviceId"));
                deviceUse.setUserId(rs.getString("userId"));
                deviceUse.setUseDate(rs.getString("useDate"));
                deviceUse.setBeginTime(rs.getString("beginTime"));
                deviceUse.setEndTime(rs.getString("endTime"));
                deviceUse.setState(rs.getString("state"));
                list.add(deviceUse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    // 删除功能

    /**
     * @param deviceId
     */
    @Override
    public void deleteDeviceUse(String deviceId) {
        try {
            String sql = "delete from deviceuseinfo where deviceId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param deviceId
     */
    @Override
    public void deleteDevice(String deviceId) {
        try {
            String sql = "delete from deviceinfo where deviceId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 设备使用申请

    /**
     * @param deviceUse
     * @return
     */
    @Override
    public int askDeviceUse(DeviceUse deviceUse) {
        try {
            String sql = "insert into askdevice(userId,deviceId,useDate,beginTime,endTime,state) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceUse.getUserId());
            ps.setString(2, deviceUse.getDeviceId());
            ps.setString(3, deviceUse.getUseDate());
            ps.setString(4, deviceUse.getBeginTime());
            ps.setString(5, deviceUse.getEndTime());
            ps.setString(6, deviceUse.getState());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
