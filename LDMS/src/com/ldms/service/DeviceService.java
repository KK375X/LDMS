package com.ldms.service;

import com.ldms.pojo.Device;
import com.ldms.pojo.DeviceUse;
import com.ldms.pojo.LaboratoryUse;

public interface DeviceService {

    // 添加设备和设备使用信息
    public int addDevice(Device device);
    public int addDeviceUse(DeviceUse deviceUse);


    // 设备使用申请
    public int askDeviceUse(DeviceUse deviceUse);
}
