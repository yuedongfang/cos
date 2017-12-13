package com.chaoren.base.db.permissions.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chaoren.base.db.permissions.mapper.UserRoleMapper;
import com.chaoren.base.db.permissions.model.UserRole;
import com.chaoren.base.db.permissions.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}