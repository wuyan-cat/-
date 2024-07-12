/**
 * z作者:无言
 * 版本:1.0
 * 2024-3-7 13:39
 */


package com.heima.article.controller.v1;

import com.heima.article.service.ApArticleService;
import com.heima.common.contants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticleContent;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController {

    @Autowired
    private ApArticleService aparticleService;
    /**
     * 加载首页
     * @param dto
     * @return
     */
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
        return aparticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }
    /**
     * 加载更多
     * @param dto
     * @return
     */
    @PostMapping("/loadmore")
    public ResponseResult loadmore(@RequestBody ArticleHomeDto dto) {

        return aparticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }
    /**
     * 加载最新
     * @param dto
     * @return
     */
    @PostMapping("/loadnew")
    public ResponseResult loadnew(@RequestBody ArticleHomeDto dto) {

        return aparticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_NEW);
    }

}
