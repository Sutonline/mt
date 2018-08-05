package com.mt.helper;

import com.mt.common.KeyInterface;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author yongkang.zhang
 * created at 05/08/2018
 */
public class EnumFunction {

    public <T extends Enum<T> & KeyInterface> Optional<T> keyFor(Class<T> clazz, Object key) {
        return Arrays.stream(clazz.getEnumConstants()).filter(i -> Objects.equals(i.key(), key)).findFirst();
    }
}
