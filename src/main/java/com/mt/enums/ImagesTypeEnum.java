package com.mt.enums;

import com.mt.common.KeyInterface;

public enum ImagesTypeEnum implements KeyInterface<Integer> {

    PURE_IMAGE(1, "图片"), IMAGE_CASE(2, "图片案例");

    private Integer value;
    private String desc;

    ImagesTypeEnum(Integer value, String desc) {
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
        return value;
    }
}
