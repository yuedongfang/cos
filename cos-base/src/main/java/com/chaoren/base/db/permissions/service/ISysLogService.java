package com.chaoren.base.db.permissions.service;

import com.baomidou.mybatisplus.service.IService;
import com.chaoren.base.db.permissions.model.SysLog;
import com.chaoren.base.result.PageInfo;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}