package com.jin.common;

import com.jin.bean.SubMenu;
import com.jin.model.TSysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/20.
 */
public class ModelConverUtil {

    public static List<SubMenu> getSubMenu(List<TSysMenu> sysMenus) {

        List<SubMenu> menuList = new ArrayList<>();

        for (TSysMenu item : sysMenus) {
            if (item.getParentId() == -1) {
                //一级菜单
                menuList.add(itemConverMenu(item));
            }
        }
        for (TSysMenu item : sysMenus) {
            if (item.getParentId() == -1) {
                continue;
            }
            for (SubMenu menu1 : menuList) {
                if (menu1.getId().equalsIgnoreCase(item.getParentId().toString())) {
                    if (RuiUtils.collectionIsEmpty(menu1.getSubMenu())) {
                        List<SubMenu> subMenus = new ArrayList<>();
                        subMenus.add(itemConverMenu(item));
                        menu1.setSubMenu(subMenus);
                    } else {
                        menu1.getSubMenu().add(itemConverMenu(item));
                    }
                }
            }
        }
        return menuList;
    }


    private static SubMenu itemConverMenu(TSysMenu item) {
        SubMenu menu = new SubMenu();
        menu.setId(item.getId().toString());
        menu.setParentId(item.getParentId().toString());
        menu.setUrlCode(item.getUrlCode());
        menu.setName(item.getName());
        menu.setOpen("true");
        return menu;
    }
}
