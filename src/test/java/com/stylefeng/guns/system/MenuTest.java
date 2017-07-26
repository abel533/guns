package com.stylefeng.guns.system;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.common.persistence.dao.MenuMapper;
import com.stylefeng.guns.common.persistence.model.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Stack;

/**
 * 菜单测试
 *
 * @author fengshuonan
 * @date 2017-06-13 21:23
 */
public class MenuTest extends BaseJunit {

    @Autowired
    MenuMapper menuMapper;

    /**
     * 初始化pcodes
     *
     * @author stylefeng
     * @Date 2017/6/13 21:24
     */
    @Test
    public void generatePcodes() {
        List<Menu> menus = menuMapper.selectAll();
        for (Menu menu : menus) {
            if ("0".equals(menu.getPcode()) || null == menu.getPcode()) {
                menu.setPcodes("[0],");
            } else {
                StringBuffer sb = new StringBuffer();
                Menu parentMenu = getParentMenu(menu.getCode());
                sb.append("[0],");
                Stack<String> pcodes = new Stack<>();
                while (null != parentMenu.getPcode()) {
                    pcodes.push(parentMenu.getCode());
                    parentMenu = getParentMenu(parentMenu.getPcode());
                }
                int pcodeSize = pcodes.size();
                for (int i = 0; i < pcodeSize; i++) {
                    String code = pcodes.pop();
                    if (code.equals(menu.getCode())) {
                        continue;
                    }
                    sb.append("[" + code + "],");
                }

                menu.setPcodes(sb.toString());
            }
            menuMapper.updateByPrimaryKey(menu);
        }
    }

    private Menu getParentMenu(String code) {
        Menu queryModel = new Menu();
        queryModel.setCode(code);
        List<Menu> menus = menuMapper.select(queryModel);
        if (menus == null || menus.size() == 0) {
            return new Menu();
        } else {
            return menus.get(0);
        }
    }
}
