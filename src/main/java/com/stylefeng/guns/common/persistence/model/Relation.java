package com.stylefeng.guns.common.persistence.model;

import javax.persistence.Table;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@Table(name = "sys_relation")
public class Relation extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    private Integer menuid;
    /**
     * 角色id
     */
    private Integer roleid;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", menuid=" + menuid +
                ", roleid=" + roleid +
                "}";
    }
}
