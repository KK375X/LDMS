package com.ldms.dao;

import com.ldms.pojo.*;
import com.ldms.utils.DBUtil;

import java.sql.PreparedStatement;

public class EditDaoImplement implements EditDao {

    DBUtil dbUtil = new DBUtil();//获取工具类对象

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    @Override
    public int EditAdmin(Admin admin) {
        try {
            // 管理员姓名、管理员密码、联系方式
            String sql = "update t_admin set name=?,password=?,phone=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getPhone());
            ps.setString(4, admin.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                System.out.println("管理员修改成功");
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    @Override
    public int EditTeacher(Teacher teacher) {
        try {
            // 教师姓名、教师密码、年龄、所属学院、职位、联系方式
            String sql = "update t_teacher set name=?,password=?,age=?,college=?,position=?,phone=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getPassword());
            ps.setString(3, teacher.getAge());
            ps.setString(4, teacher.getCollege());
            ps.setString(5, teacher.getPosition());
            ps.setString(6, teacher.getPhone());
            ps.setString(7, teacher.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public int EditStudent(Student student) {
        try {
            // 学生姓名、学生密码、年龄、联系方式、辅导员ID、班级、所属学院
            String sql = "update t_student set name=?,password=?,age=?,phone=?,teacherId=?,classes=?,college=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getPassword());
            ps.setString(3, student.getAge());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getTeacherId());
            ps.setString(6, student.getClasses());
            ps.setString(7, student.getCollege());
            ps.setString(8, student.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改设备信息
     * @param device
     * @return
     */
    @Override
    public int EditDevice(Device device) {
        try {
            // 设备名称、负责人ID、使用状态、所属实验室ID
            String sql = "update deviceinfo set deviceName=?,teacherId=?,state=?,laboratoryId=? where deviceId=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, device.getDeviceName());
            ps.setString(2, device.getTeacherId());
            ps.setString(3, device.getState());
            ps.setString(4, device.getLaboratoryId());
            ps.setString(5, device.getDeviceId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改设备使用信息
     * @param deviceUse
     * @return
     */
    @Override
    public int EditDeviceUse(DeviceUse deviceUse) {
        try {
            // 设备ID、使用者ID、使用日期、开始使用时间、结束使用时间
            String sql = "update deviceuseinfo set userId=?,useDate=?,beginTime=?,endTime=? where deviceId=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceUse.getUserId());
            ps.setString(2, deviceUse.getUseDate());
            ps.setString(3, deviceUse.getBeginTime());
            ps.setString(4, deviceUse.getEndTime());
            ps.setString(5, deviceUse.getDeviceId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改实验室信息
     * @param laboratory
     * @return
     */
    @Override
    public int EditLaboratory(Laboratory laboratory) {
        try {
            // 实验室名称、实验室负责人ID、实验室地址
            String sql = "update laboratoryinfo set laboratoryName=?,teacherId=?,state=?,address=? where laboratoryId=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratory.getLaboratoryName());
            ps.setString(2, laboratory.getTeacherId());
            ps.setString(3, laboratory.getState());
            ps.setString(4, laboratory.getAddress());
            ps.setString(5, laboratory.getLaboratoryId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改实验室使用信息
     * @param laboratoryUse
     * @return
     */
    @Override
    public int EditLaboratoryUse(LaboratoryUse laboratoryUse) {
        try {
            // 教师ID、使用日期、开始使用时间、结束使用时间
            String sql = "update laboratoryuseinfo set teacherId=?,useDate=?,beginTime=?,endTime=? where laboratoryId=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratoryUse.getTeacherId());
            ps.setString(2, laboratoryUse.getUseDate());
            ps.setString(3, laboratoryUse.getBeginTime());
            ps.setString(4, laboratoryUse.getEndTime());
            ps.setString(5, laboratoryUse.getLaboratoryId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    // 修改用户密码
    /**
     * @param admin
     * @return
     */
    @Override
    public int EditAdminPassword(Admin admin) {
        try {
            String sql = "update t_admin set password=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, admin.getPassword());
            ps.setString(2, admin.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public int EditTeacherPassword(Teacher teacher) {
        try {
            String sql = "update t_teacher set password=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, teacher.getPassword());
            ps.setString(2, teacher.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public int EditStudentPassword(Student student) {
        try {
            String sql = "update t_student set password=? where id=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, student.getPassword());
            ps.setString(2, student.getId());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    /**
     * 管理员对实验室使用申请做修改
     * @param laboratoryUse
     * @return
     */
    @Override
    public int AskLaboratoryUse(LaboratoryUse laboratoryUse) {
        try {
            String sql = "update laboratoryuseinfo set state=? where laboratoryId=? and teacherId=? and useDate=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, laboratoryUse.getState());
            ps.setString(2, laboratoryUse.getLaboratoryId());
            ps.setString(3, laboratoryUse.getTeacherId());
            ps.setString(4, laboratoryUse.getUseDate());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 管理员对设备使用申请做修改
     * @param deviceUse
     * @return
     */
    @Override
    public int AskDeviceUse(DeviceUse deviceUse) {
        try {
            String sql = "update deviceuseinfo set state=? where deviceId=? and userId=? and useDate=?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, deviceUse.getState());
            ps.setString(2, deviceUse.getDeviceId());
            ps.setString(3, deviceUse.getUserId());
            ps.setString(4, deviceUse.getUseDate());
            int rs = ps.executeUpdate();
            while (rs == 1) {// 修改成功返回 1
                return 1;
            }
            return 0;//修改失败返回 0
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



}
