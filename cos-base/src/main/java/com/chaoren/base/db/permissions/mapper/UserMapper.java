package com.chaoren.base.db.permissions.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.chaoren.base.db.permissions.model.User;
import com.chaoren.base.db.permissions.model.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends BaseMapper<User> {

    UserVo selectUserVoById(@Param("id") Long id);

    List<Map<String, Object>> selectUserPage(Pagination page, Map<String, Object> params);

}