package com.circle.web.postinvitation.service.impl;

import cn.hutool.core.util.IdUtil;
import com.circle.common.constant.Constants;
import com.circle.common.utils.StringUtils;
import com.circle.common.utils.uuid.IdUtils;
import com.circle.web.postinvitation.domain.po.AOperateCount;
import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.AOperateCountDto;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import com.circle.web.postinvitation.mapper.AOperateCountMapper;
import com.circle.web.postinvitation.mapper.APostCriticMapper;
import com.circle.web.postinvitation.mapper.APostInvitationMapper;
import com.circle.web.postinvitation.service.IOperateCountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IOperateCountServiceImpl implements IOperateCountService {

    @Resource
    private APostInvitationMapper aPostInvitationMapper;

    @Resource
    private APostCriticMapper aPostCriticMapper;

    @Resource
    private AOperateCountMapper aOperateCountMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void operateCount(AOperateCountDto dto) {
        String tId = dto.getTId();
        String userId = dto.getUserId();
        String operateType = dto.getOperateType();
        String isOperate = dto.getIsOperate();
        // 查找是否有数据
        AOperateCount aOperateCount = new AOperateCount();
        aOperateCount.settId(tId);
        aOperateCount.setUserId(userId);
        aOperateCount.setOperateType(operateType);
        List<AOperateCount> list = aOperateCountMapper.selectAOperateCountList(aOperateCount);
        if(StringUtils.isListNull(list)){
            // 没有记录做新增操作
            aOperateCount.setId(String.valueOf(IdUtil.getSnowflake().nextId()));
            aOperateCount.setIsOperate(isOperate);
            aOperateCount.setDelFlag(Constants.DEL_FLAG_FALSE);
            aOperateCountMapper.insertAOperateCount(aOperateCount);
        } else {
            // 有记录做修改操作
            aOperateCount = new AOperateCount();
            aOperateCount.setId(list.get(0).getId());
            aOperateCount.setIsOperate(isOperate);
            aOperateCountMapper.updateAOperateCount(aOperateCount);
        }
        // 更新帖子表
        aOperateCount = new AOperateCount();
        aOperateCount.settId(tId);
        aOperateCount.setOperateType(operateType);
        aOperateCount.setIsOperate("1");
        List<AOperateCount> tList = aOperateCountMapper.selectAOperateCountList(aOperateCount);
        int count = 0;
        if(StringUtils.isListNotNull(tList)){
            count = tList.size();
        }
        if("0".equals(operateType)){
            // 更新帖子收藏数量
            APostInvitationUpdateDto invitationDto = new APostInvitationUpdateDto();
            invitationDto.setId(tId);
            invitationDto.setViewCount(String.valueOf(count));
            aPostInvitationMapper.updateAPostInvitation(invitationDto);
        } else if("1".equals(operateType)){
            // 更新帖子点赞数量
            APostInvitationUpdateDto invitationDto = new APostInvitationUpdateDto();
            invitationDto.setId(tId);
            invitationDto.setUpvoteCount(String.valueOf(count));
            aPostInvitationMapper.updateAPostInvitation(invitationDto);
        }
    }

}
