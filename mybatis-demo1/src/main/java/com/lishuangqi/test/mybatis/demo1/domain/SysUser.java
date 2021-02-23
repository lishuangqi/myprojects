package com.lishuangqi.test.mybatis.demo1.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * sys_user
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUser implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userId;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}