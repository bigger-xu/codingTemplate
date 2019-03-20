package com.coding.temp.service.impl;

import com.coding.temp.dao.CodeLogMapper;
import com.coding.temp.entity.CodeLog;
import com.coding.temp.service.CodeLogService;
import com.coding.temp.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
@Service
public class CodeLogServiceImpl extends BaseServiceImpl<CodeLog> implements CodeLogService {

    @Autowired
    private CodeLogMapper codeLogMapper;
    @Override
    public CodeLogMapper getNameSpace() {
        return codeLogMapper;
    }
}
