package com.ldms.service;

import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;
import com.ldms.pojo.Device;
import com.ldms.pojo.DeviceUse;

public class DeviceServiceImplement implements DeviceService{

    private DeviceDao deviceDao = new DeviceDaoImplement();

    // 添加设备和设备使用信息
    /**
     * @param device
     * @return
     */
    @Override
    public int addDevice(Device device) {
        return deviceDao.addDevice(device);
    }

    /**
     * @param deviceUse
     * @return
     */
    @Override
    public int addDeviceUse(DeviceUse deviceUse) {
        return deviceDao.addDeviceUse(deviceUse);
    }


    // 设备使用申请
    /**
     * @param deviceUse
     * @return
     */
    @Override
    public int askDeviceUse(DeviceUse deviceUse) {
        return deviceDao.askDeviceUse(deviceUse);
    }
}
