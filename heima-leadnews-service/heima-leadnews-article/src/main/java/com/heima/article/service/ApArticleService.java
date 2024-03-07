/**
 * z作者:无言
 * 版本:1.0
 * 2024-3-7 13:57
 */


package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

public interface ApArticleService extends IService<ApArticle> {
    /**
     * 加载文章列表
     * @param dto
     * @param type 1加载更多 2加载最新
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto,Short type);
}
