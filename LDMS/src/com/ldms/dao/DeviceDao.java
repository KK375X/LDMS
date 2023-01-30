package com.ldms.dao;

import com.ldms.pojo.Device;
import com.ldms.pojo.DeviceUse;

import java.sql.Date;
import java.util.List;

public interface DeviceDao {

    // 查询数据库，显示数据列表（已淘汰）
    public List<Object> selectDeviceList();
    public List<Object> selectDeviceUseList();


    // 查询数据库，实现信息表显示和分页功能
    // 获取设备信息数据的总和
    public List<Object> selectDeviceList(String page, String limit);
    int countDeviceInfo();
    public List<Object> selectDeviceUseList(String pageStr, String limitStr);
    int countDeviceUseInfo();


    // 添加设备和设备使用信息
    public int addDevice(Device device);
    public int addDeviceUse(DeviceUse deviceUse);


    // 查询设备ID和使用ID，防止重复
    public Device selectDevice(String deviceId);
    public DeviceUse selectDeviceUse(String deviceId, String userId, Date useDate);


    // 搜索功能
    public List<Object> searchDeviceList(String deviceName, String type, String state, String page, String limit);
    public List<Object> searchDeviceUseList(String deviceId, String userId, String page, String limit);


    // 删除功能
    public void deleteDeviceUse(String deviceId);
    public void deleteDevice(String deviceId);


    // 设备使用申请
    public int askDeviceUse(DeviceUse deviceUse);


    // 设备使用申请记录表
    public List<Object> selectAskDeviceUseList(String pageStr, String limitStr);
    public int countAskDeviceUseInfo();




    // 教师和学生独立的功能
    public List<Object> selectUserDeviceUseList(String pageStr, String limitStr, String id);
    int countUserDeviceUseInfo(String id);

    // 教师和学生搜索个人设备使用信息的功能
    public List<Object> searchUserDeviceUseList(String deviceId, String useDate, String id, String pageStr, String limitStr);
}
