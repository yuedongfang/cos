package com.chaoren.base.db.permissions.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chaoren.base.db.permissions.mapper.RoleResourceMapper;
import com.chaoren.base.db.permissions.model.RoleResource;
import com.chaoren.base.db.permissions.service.IRoleResourceService;
import org.springframework.stereotype.Service;

/**
 *
 * RoleResource 表数据服务层接口实现类
 *
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {
}