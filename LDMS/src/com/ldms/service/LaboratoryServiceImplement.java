package com.ldms.service;

import com.ldms.dao.LaboratoryDao;
import com.ldms.dao.LaboratoryDaoImplement;
import com.ldms.pojo.Laboratory;
import com.ldms.pojo.LaboratoryUse;

public class LaboratoryServiceImplement implements LaboratoryService {

    //创建实例化对象
    private LaboratoryDao laboratoryDao = new LaboratoryDaoImplement();

    // 添加实验室信息，实现添加功能
    /**
     * @param laboratory
     * @return
     */
    @Override
    public int addLaboratory(Laboratory laboratory) {
        return laboratoryDao.addLaboratory(laboratory);
    }



    // 添加实验室使用信息，实现添加功能
    /**
     * @param laboratoryUse
     * @return
     */
    @Override
    public int addLaboratoryUse(LaboratoryUse laboratoryUse) {
        return laboratoryDao.addLaboratoryUse(laboratoryUse);
    }


}
