package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.common.persistence.dao.MenuMapper;
import com.stylefeng.guns.common.persistence.model.Menu;
import com.stylefeng.guns.modular.system.service.IMenuService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单服务
 *
 * @author fengshuonan
 * @date 2017-05-05 22:20
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public void delMenu(Integer menuId) {
        //删除菜单
        this.menuMapper.deleteByPrimaryKey(menuId);
        //删除关联的relation
        this.menuMapper.deleteRelationByMenu(menuId);
    }

    @Override
    public void delMenuContainSubMenus(Integer menuId) {

        Menu menu = menuMapper.selectByPrimaryKey(menuId);

        //删除当前菜单
        delMenu(menuId);

        //删除所有子菜单
        Example example = new Example(Menu.class);
        example.createCriteria().andLike("pcodes", "%[" + menu.getCode() + "]%");
        List<Menu> menus = menuMapper.selectByExample(example);
        for (Menu temp : menus) {
            delMenu(temp.getId());
        }
    }
}
