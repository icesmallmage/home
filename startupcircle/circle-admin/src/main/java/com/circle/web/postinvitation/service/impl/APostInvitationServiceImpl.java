package com.circle.web.postinvitation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.circle.common.constant.Constants;
import com.circle.common.core.domain.model.LoginUser;
import com.circle.common.utils.DateUtils;
import com.circle.common.utils.SecurityUtils;
import com.circle.common.utils.StringUtils;
import com.circle.web.postinvitation.domain.po.AGroupChat;
import com.circle.web.postinvitation.domain.po.AOperateCount;
import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.AGroupChatDto;
import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.circle.web.postinvitation.mapper.AGroupChatMapper;
import com.circle.web.postinvitation.mapper.AOperateCountMapper;
import com.circle.web.postinvitation.mapper.APostInvitationMapper;
import com.circle.web.postinvitation.service.IAGroupChatService;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 【帖子信息表】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Service
public class APostInvitationServiceImpl implements IAPostInvitationService
{
    @Resource
    private APostInvitationMapper aPostInvitationMapper;

    @Resource
    private AOperateCountMapper aOperateCountMapper;

    @Resource
    private AGroupChatMapper aGroupChatMapper;

    @Autowired
    private IAGroupChatService iaGroupChatService;

    @Override
    public PageInfo<APostInvitationVo> pageList(APostInvitationDto dto, Integer pageNum, Integer pageSize) {
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        if(StringUtils.isNotEmpty(dto.getUserId())){
            po.setPostUserId(dto.getUserId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<APostInvitation> list = aPostInvitationMapper.selectAPostInvitationList(po);
        PageInfo pageInfo = new PageInfo(list);
        List<APostInvitationVo> voList = this.copyList(list);
        pageInfo.setList(voList);
        return pageInfo;
    }

    /**
     * 查询【帖子信息表】列表
     *
     * @param dto 【帖子信息表】
     * @return 【帖子信息表】
     */
    @Override
    public List<APostInvitationVo> selectAPostInvitationList(APostInvitationDto dto)
    {
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        List<APostInvitation> list = aPostInvitationMapper.selectAPostInvitationList(po);
        List<APostInvitationVo>  voList = this.copyList(list);
        return voList;
    }

    /**
     * 复制列表值
     */
    public List<APostInvitationVo> copyList(List<APostInvitation> list){
        if(StringUtils.isListNull(list)){
            return new ArrayList<>();
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<APostInvitationVo> voList = BeanUtil.copyToList(list, APostInvitationVo.class);
        voList.forEach(t -> {
            // 存放操作信息
            AOperateCount aOperateCount = new AOperateCount();
            aOperateCount.settId(t.getId());
            aOperateCount.setUserId(String.valueOf(loginUser.getUserId()));
            aOperateCount.setIsOperate("1");
            List<AOperateCount> operateList = aOperateCountMapper.selectAOperateCountList(aOperateCount);
            List<String> operates = operateList.stream().map(AOperateCount::getOperateType).collect(Collectors.toList());
            if(operates.contains("0")){
                t.setBooView(true);
            }
            if(operates.contains("1")){
                t.setBooUpvote(true);
            }
            // 存放群聊信息
            AGroupChat aGroupChat = new AGroupChat();
            aGroupChat.settId(t.getId());
            List<AGroupChat> aGroupChatList = aGroupChatMapper.selectAGroupChatList(aGroupChat);
            if(StringUtils.isListNotNull(aGroupChatList) && StringUtils.isNotNull(aGroupChatList.get(0))){
                aGroupChat = aGroupChatList.get(0);
                t.setGroupId(aGroupChat.getId());
                t.setGroupName(aGroupChat.getName());
            }
        });
        return voList;
    }

    /**
     * 新增【帖子信息表】
     * 
     * @param dto 【帖子信息表】
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAPostInvitation(APostInvitationAddDto dto) {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String id = String.valueOf(IdUtil.getSnowflake().nextId());
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        po.setId(id);
        po.setUpvoteCount("0");
        po.setViewCount("0");
        po.setCriticCount("0");
        po.setDelFlag(Constants.DEL_FLAG_FALSE);
        po.setCreateTime(DateUtils.getNowDate());
        po.setCreateBy(loginUser.getUsername());
        aPostInvitationMapper.insertAPostInvitation(po);
        if(StringUtils.isNotEmpty(dto.getGroupName())){
            // 如果传了群里名， 则一起创建群里
            AGroupChatDto chatDto = new AGroupChatDto();
            chatDto.setName(dto.getGroupName());
            chatDto.setTId(id);
            chatDto.setGroOwnId(dto.getPostUserId());
            chatDto.setGroOwnName(dto.getPostNickName());
            iaGroupChatService.insertAGroupChat(chatDto);
        }
        return 0;
    }

    @Override
    public int updateAPostInvitation(APostInvitationUpdateDto dto) {
        return aPostInvitationMapper.updateAPostInvitation(dto);
    }

    /**
     * 批量删除【帖子信息表】
     * 
     * @param ids 需要删除的【帖子信息表】主键
     * @return 结果
     */
    @Override
    public int deleteAPostInvitationByIds(String[] ids)
    {
        return aPostInvitationMapper.deleteAPostInvitationByIds(ids);
    }

    /**
     * 删除【帖子信息表】信息
     * 
     * @param id 【帖子信息表】主键
     * @return 结果
     */
    @Override
    public int deleteAPostInvitationById(String id)
    {
        return aPostInvitationMapper.deleteAPostInvitationById(id);
    }

    @Override
    public PageInfo<APostInvitationVo> operateList(String operateType, Integer pageNum, Integer pageSize) {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String userId = String.valueOf(loginUser.getUserId());
        PageHelper.startPage(pageNum, pageSize);
        List<APostInvitation> list = aPostInvitationMapper.selectOperateList(userId, operateType);
        PageInfo pageInfo = new PageInfo(list);
        List<APostInvitationVo> voList = BeanUtil.copyToList(list, APostInvitationVo.class);
        voList.stream().forEach(t -> {
            if("0".equals(operateType)){
                t.setBooView(true);
            }
            if("1".equals(operateType)){
                t.setBooUpvote(true);
            }
        });
        pageInfo.setList(voList);
        return pageInfo;
    }

}
