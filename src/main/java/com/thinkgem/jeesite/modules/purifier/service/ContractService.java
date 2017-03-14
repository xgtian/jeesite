package com.thinkgem.jeesite.modules.purifier.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.purifier.dao.ContractDao;
import com.thinkgem.jeesite.modules.purifier.entity.Contract;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 合同单业务逻辑
 *
 * @author addison
 * @since 2017年03月14日
 */
@Service
@Transactional(readOnly = true)
public class ContractService extends CrudService<ContractDao,Contract>{
}
