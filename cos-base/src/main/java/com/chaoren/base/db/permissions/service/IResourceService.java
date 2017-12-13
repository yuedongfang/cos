package com.chaoren.base.db.permissions.service;

import com.baomidou.mybatisplus.service.IService;
import com.chaoren.base.db.permissions.model.Resource;
import com.chaoren.base.db.permissions.model.ShiroUser;
import com.chaoren.base.result.Tree;

import java.util.List;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);

}