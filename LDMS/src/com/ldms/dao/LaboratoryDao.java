package com.ldms.dao;

import com.ldms.pojo.Laboratory;
import com.ldms.pojo.LaboratoryUse;

import java.util.List;

public interface LaboratoryDao {


    // 查询数据库，显示数据列表（已淘汰）
    public List<Object> selectLaboratoryList();
    public List<Object> selectLaboratoryUseList();


    // 查询数据库，实现信息表显示和分页功能
    // 获取信息数据的总和
    public List<Object> selectLaboratoryList(String page, String limit);
    public int countLaboratoryInfo();
    public List<Object> selectLaboratoryUseList(String page, String limit);
    public int countLaboratoryUseInfo();


    // 添加实验室信息，实现添加功能
    public int addLaboratory(Laboratory laboratory);
    public int addLaboratoryUse(LaboratoryUse laboratory);


    // 查询实验室ID，防止重复
    public Laboratory selectLaboratory(String laboratoryId);
    public LaboratoryUse selectLaboratoryUse(String laboratoryId);


    // 搜索功能
    public List<Object> searchLaboratoryList(String laboratoryId, String laboratoryName, String address, String page, String limit);
    public List<Object> searchLaboratoryUseList(String laboratoryId, String teacherId, String page, String limit);


    // 删除功能
    public void deleteLaboratory(String laboratoryId);
    public void deleteLaboratoryUse(String laboratoryId);


    // 实验室使用申请列表
    public List<Object> selectAskLaboratoryUseList(String pageStr, String limitStr);
    int countAskLaboratoryUseInfo();



    // 教师个人使用实验室记录
    public List<Object> selectTeacherLaboratoryUseList(String pageStr, String limitStr, String id);
    int countTeacherLaboratoryUseInfo(String id);


    // 搜索教师个人使用实验室记录
    public List<Object> searchUserLaboratoryUseList(String laboratoryId, String useDate, String id, String pageStr, String limitStr);
}
