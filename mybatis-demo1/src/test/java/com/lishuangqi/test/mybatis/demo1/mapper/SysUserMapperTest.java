package com.lishuangqi.test.mybatis.demo1.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lishuangqi.test.mybatis.demo1.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: lishuanqgi
 * @ClassName:
 * @Date: 2021/2/18 22:32
 * @Description:
 */
@SpringBootTest
class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
        SysUser sysUser = new SysUser(null,"lsq","123");
        sysUserMapper.insert(sysUser);
    }

    @Test
    void testInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("2321");
        sysUser.setPassword("d123123");
        System.out.println(sysUserMapper.insert(sysUser));
        System.out.println(sysUser.getUserId());
    }

    @Test
    void queryAll() {
        System.out.println(sysUserMapper.selectAll());
    }

    @Test
    void testPage() {
        PageHelper.startPage(2,2);
        List<SysUser> sysUsers = sysUserMapper.selectAll();

        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        System.out.println(pageInfo);
    }

    @Test
    void updateByPrimaryKey() {
    }
}