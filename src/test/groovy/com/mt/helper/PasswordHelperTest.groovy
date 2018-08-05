package com.mt.helper

import lombok.extern.slf4j.Slf4j
import spock.lang.Specification

@Slf4j
class PasswordHelperTest extends Specification {

    def "加密"() {
        when:
        def s = PasswordHelper.encrypt("10admin")
        then:
        print("加密后的字符串是: " + s)
    }
}
