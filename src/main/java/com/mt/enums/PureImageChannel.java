package com.mt.enums;

import com.mt.common.KeyInterface;

public enum PureImageChannel implements KeyInterface<Integer> {

    LB_SHOUYE(1, "轮播图管理-首页"), LB_FUWU(2, "轮播图管理-服务"), LB_DONGTAI(3, "轮播图管理-动态"),
    LB_WOMEN(4, "轮播图管理-我们"), LB_LIANXI(5, "轮播图管理-联系"), PXGL_DONGTAI(6, "品宣管理-动态");

    private Integer key;
    private String desc;

    PureImageChannel(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Integer getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public Integer key() {
        return getKey();
    }
}
