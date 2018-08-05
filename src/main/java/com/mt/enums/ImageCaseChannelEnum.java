package com.mt.enums;

import com.mt.common.KeyInterface;

public enum ImageCaseChannelEnum implements KeyInterface<Integer> {

    ZNYJ(1, "智能硬件"), YLJK(2, "医疗健康"), XFJD(3, "消费家电"),
    JXZDH(4, "机械自动化"), JJZB(5, "军警装备"), JQR(5, "机器人"),
    JHSJ(7, "交互设计"), BZSJ(8, "包装设计"), QT(9, "其他");

    private Integer value;
    private String desc;

    ImageCaseChannelEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public Integer key() {
        return getValue();
    }
}
