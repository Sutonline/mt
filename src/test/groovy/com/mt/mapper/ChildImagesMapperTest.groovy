package com.mt.mapper

import com.mt.ManApplication
import com.mt.pojo.ChildImages
import com.mt.repository.ChildImagesMapper
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise

import javax.annotation.Resource


@Slf4j
//@Stepwise
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = [ManApplication.class])
class ChildImagesMapperTest extends Specification{

    @Resource
    private ChildImagesMapper childImagesMapper;

    def mockChildImages() {
        ChildImages childImages = new ChildImages();
        childImages.setImageId(2);
        childImages.setImagePath("哈哈");
        childImages.setRemark("这里是中文啊");
        return childImages;
    }

    def "插入"() {
        def childImages = mockChildImages()

        when: "insert record"
            def i = childImagesMapper.insert(childImages)

        then: "should insert success"
            i == 1
    }

    def "selectAll" () {
        when:
            def List<ChildImages> list = childImagesMapper.selectAll()
        then:
            list?.size() >= 1
    }

    def "delete" () {
        when:
            def i = childImagesMapper.deleteByPrimaryKey(1);
        then:
            i == 1
    }

}

