package com.ldms.service;

import com.ldms.pojo.Laboratory;
import com.ldms.pojo.LaboratoryUse;

public interface LaboratoryService {

    // 添加实验室信息，实现添加功能
    public int addLaboratory(Laboratory laboratory);


    // 添加实验室使用信息，实现添加功能
    public int addLaboratoryUse(LaboratoryUse laboratoryUse);

}
