package com.circle.web.system.service.impl;

import com.circle.web.postinvitation.mapper.AGroupChatMapper;
import com.circle.web.system.service.SysCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 存放公共全局属性值
 */
@Component
@Service
public class SysCommonServiceImpl implements SysCommonService {

    private static final Logger logger = LoggerFactory.getLogger(SysCommonServiceImpl.class);

    @Resource
    private AGroupChatMapper aGroupChatMapper;

    public static List<String> groupIds;

    public List<String> groupIdsOld;

    @PostConstruct
    public void initGroupId(){
        // 查询群聊个数
        groupIds = aGroupChatMapper.selectIds();
        groupIdsOld = groupIds;
        logger.info("初始群聊个数为： " + groupIdsOld.size());
    }

    // @Scheduled(fixedRate = 3000)
    public void realRefreshGroupId(){
        // 查询群聊个数
        groupIds = aGroupChatMapper.selectIds();
    }

}
