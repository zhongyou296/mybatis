package com.wqm.mybatis.model;

import lombok.Data;

/**
 * <p>文件名称：UserQueryDO </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：用户查询的实体类</p>
 * <p>其他说明：</p>
 * <p>完成日期：2017/3/7 </p>
 *
 * @author wangqiming
 */
@Data
public class UserQueryDO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 电话号码
     */
    private String phone;
}
