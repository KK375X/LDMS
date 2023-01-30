package com.ldms.dao;

import com.ldms.pojo.*;

public interface EditDao {

    // 修改管理员信息
    public int EditAdmin(Admin admin);

    // 修改教师信息
    public int EditTeacher(Teacher teacher);

    // 修改学生信息
    public int EditStudent(Student student);

    // 修改设备信息
    public int EditDevice(Device device);

    // 修改设备使用信息
    public int EditDeviceUse(DeviceUse deviceUse);

    // 修改实验室信息
    public int EditLaboratory(Laboratory laboratory);

    // 修改实验室使用信息
    public int EditLaboratoryUse(LaboratoryUse laboratoryUse);

    // 修改管理员密码
    public int EditAdminPassword(Admin admin);

    // 修改教师密码
    public int EditTeacherPassword(Teacher teacher);

    // 修改学生密码
    public int EditStudentPassword(Student student);

    // 管理员对实验室使用申请做修改
    public int AskLaboratoryUse(LaboratoryUse laboratoryUse);

    // 管理员对设备使用申请做修改
    public int AskDeviceUse(DeviceUse deviceUse);
}
