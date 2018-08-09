package com.mt.web.controller.rest;

import com.mt.common.BizException;
import com.mt.common.PageRequest;
import com.mt.pojo.ChildImages;
import com.mt.pojo.CustomerRequirements;
import com.mt.pojo.Images;
import com.mt.pojo.News;
import com.mt.repository.ChildImagesMapper;
import com.mt.repository.CustomerRequirementsMapper;
import com.mt.repository.ImagesMapper;
import com.mt.repository.NewsMapper;
import com.mt.web.advice.WrapRestController;
import com.mt.web.view.Page;
import com.mt.web.view.dto.ImageSaveDto;
import com.mt.web.view.dto.ImagesDetailVO;
import com.mt.web.view.query.CRQuery;
import com.mt.web.view.query.ImagesQuery;
import com.mt.web.view.query.NewsQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
@RestController
@RequestMapping(value = "/mt")
@Api(value = "mt api")
@WrapRestController
public class MtApi {

    @Resource
    private CustomerRequirementsMapper customerRequirementsMapper;
    @Resource
    private ImagesMapper imagesMapper;
    @Resource
    private ChildImagesMapper childImagesMapper;
    @Resource
    private NewsMapper newsMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;


    @PutMapping(value = "/cr/save")
    @ApiOperation(value = "保存客户需求", notes = "有实体验证")
    @ApiImplicitParam(value = "客户需求", name = "customerRequirements")
    public Boolean saveCustomRequirements(@Valid @RequestBody CustomerRequirements customerRequirements) {
        if (customerRequirements == null) {
            throw new BizException("保存的客户需求不可为空");
        }

        return customerRequirementsMapper.insert(customerRequirements) == 1;
    }


    @GetMapping(value = "/cr/listPage")
    @ApiOperation(value = "客户需求分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象"),
            @ApiImplicitParam(name = "pageRequest", value = "分页请求")
    })
    public Page<CustomerRequirements> listPage(CRQuery query, PageRequest pageRequest) {
        long totalItems = customerRequirementsMapper.countByQuery(query);
        if (totalItems == 0) {
            return Page.emptyPage();
        }


        List<CustomerRequirements> customerRequirements = customerRequirementsMapper.listPage(query, pageRequest);

        return new Page<>(pageRequest, totalItems, customerRequirements);
    }

    @PutMapping(value = "/images/save")
    @ApiOperation(value = "保存案例")
    @ApiImplicitParam(name = "imageSaveDto", value = "保存对象")
    public Boolean saveCase(@Valid @RequestBody ImageSaveDto imageSaveDto) {
        Images images = imageSaveDto.getImages();
        images.setPublishTime(new Date());
        List<String> childImagePaths = imageSaveDto.getChildImagePaths();

        transactionTemplate.execute(status -> {
            imagesMapper.insert(images);
            Integer imageId = images.getImageId();
            List<ChildImages> childImages = constructChildImages(imageId, childImagePaths);
            childImagesMapper.bulkInsert(childImages);
            return true;
        });

        return true;
    }

    @GetMapping(value = "/images/query")
    @ApiOperation(value = "分页查询图片和案例")
    public Page<Images> listPageByQuery(ImagesQuery query, PageRequest request) {
        long totalItems = imagesMapper.countByQuery(query);
        if (totalItems == 0) {
            return Page.emptyPage();
        }

        List<Images> images = imagesMapper.listPageByQuery(query, request);

        return new Page<>(request, totalItems, images);
    }

    @GetMapping(value = "/images/detail/{imageId}")
    @ApiOperation(value = "根据imageId查询图片的详情")
    public ImagesDetailVO getImageDetail(@PathVariable Integer imageId) {
        ImagesDetailVO detailVO = new ImagesDetailVO();
        Images images = imagesMapper.selectByPrimaryKey(imageId);
        if (images == null) {
            return detailVO;
        }

        List<ChildImages> childImages = childImagesMapper.listByImageId(imageId);
        detailVO.setImages(images);
        detailVO.setChildImages(childImages);

        return detailVO;
    }

    @PutMapping(value = "/images/delete/{imageId}")
    @ApiOperation(value = "根据imageId删除图片")
    public void deleteByImageId(@PathVariable(value = "imageId") Integer imageId) {
        transactionTemplate.execute(status -> {
            imagesMapper.deleteByPrimaryKey(imageId);
            childImagesMapper.deleteByImageId(imageId);

            return true;
        });
    }

    @PutMapping(value = "/news/add")
    @ApiOperation(value = "动态")
    public void addNews(@Valid @RequestBody News news) {
        news.setCreateTime(new Date());
        newsMapper.insert(news);
    }

    @PutMapping(value = "/news/delete/{newsId}")
    @ApiOperation(value = "根据id删除动态")
    public void deleteNewsById(@PathVariable Integer newsId) {
        newsMapper.deleteByPrimaryKey(newsId);
    }

    @GetMapping(value = "/news/query")
    @ApiOperation(value = "根据query查询动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newsQuery", value = "动态查询对象"),
            @ApiImplicitParam(name = "pageRequest", value = "分页请求")
    })
    public List<News> listNewsByQuery(NewsQuery newsQuery, PageRequest pageRequest) {
        return newsMapper.listPageByQuery(newsQuery, pageRequest);
    }

    private List<ChildImages> constructChildImages(Integer imageId, List<String> childImagePath) {
        return childImagePath.stream()
                .map(i -> {
                    ChildImages childImages = new ChildImages();
                    childImages.setImageId(imageId);
                    childImages.setImagePath(i);
                    return childImages;
                }).collect(Collectors.toList());
    }

}
