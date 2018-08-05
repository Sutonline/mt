package com.mt.mapper

import com.mt.ManApplication
import com.mt.pojo.Images
import com.mt.repository.ImagesMapper
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@Slf4j
//@Stepwise
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = [ManApplication.class])
class ImageMapperTest extends Specification {

    @Resource
    private ImagesMapper imagesMapper

    def mockImages() {
        Images images = new Images()
        images.setRemark("lalal")
        images.setChannel(2)
        images.setPublishTime(new Date())
        images.setShortTitle("lalal")
        images.setThumbnail("haha")
        images.setTitle("(⊙_⊙)?")
        images.setType(2)
        return images;
    }

    def "save record"() {
        def images = mockImages();
        when:
            def i = imagesMapper.insert(images)
        then:
            i == 1
    }

    def "select records"() {
        when:
            def i = imagesMapper.selectAll()
        then:
            i?.size() > 0
    }

}
