package com.chaoren.base.db.permissions.service;

import com.baomidou.mybatisplus.service.IService;
import com.chaoren.base.db.permissions.model.Organization;
import com.chaoren.base.result.Tree;

import java.util.List;

/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService extends IService<Organization> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}