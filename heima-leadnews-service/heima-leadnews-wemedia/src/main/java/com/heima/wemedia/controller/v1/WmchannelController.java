/**
 * z作者:无言
 * 版本:1.0
 * 2024-7-13 15:20
 */


package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {
    @Autowired
    private WmChannelService wmChannelService;
    @GetMapping("/channlers")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }

    
}
