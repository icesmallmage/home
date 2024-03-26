package com.circle.web.postinvitation.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.circle.common.constant.Constants;
import com.circle.common.core.domain.model.LoginUser;
import com.circle.common.exception.ServiceException;
import com.circle.common.utils.DateUtils;
import com.circle.common.utils.SecurityUtils;
import com.circle.common.utils.StringUtils;
import com.circle.web.postinvitation.domain.po.AGroupChat;
import com.circle.web.postinvitation.domain.po.AGroupUserRelate;
import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.AGroupChatDto;
import com.circle.web.postinvitation.domain.to.AGroupUserRelateDto;
import com.circle.web.postinvitation.domain.vo.AGroupChatVo;
import com.circle.web.postinvitation.mapper.AGroupChatMapper;
import com.circle.web.postinvitation.mapper.AGroupUserRelateMapper;
import com.circle.web.postinvitation.mapper.APostInvitationMapper;
import com.circle.web.postinvitation.service.IAGroupChatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 【群聊】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-08
 */
@Service
public class AGroupChatServiceImpl implements IAGroupChatService
{
    @Resource
    private AGroupChatMapper aGroupChatMapper;

    @Resource
    private APostInvitationMapper aPostInvitationMapper;

    @Resource
    private AGroupUserRelateMapper aGroupUserRelateMapper;

    /**
     * 查询【群聊】
     * 
     * @param id 【群聊】主键
     * @return 【群聊】
     */
    @Override
    public AGroupChat selectAGroupChatById(String id)
    {
        return aGroupChatMapper.selectAGroupChatById(id);
    }

    /**
     * 查询【群聊】列表
     * 
     * @param aGroupChat 【群聊】
     * @return 【群聊】
     */
    @Override
    public List<AGroupChat> selectAGroupChatList(AGroupChat aGroupChat)
    {
        return aGroupChatMapper.selectAGroupChatList(aGroupChat);
    }

    @Override
    public PageInfo<AGroupChatVo> groupChatPageList(Integer pageNum, Integer pageSize) {
        // 获取当前登录人
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String userId = String.valueOf(loginUser.getUserId());
        AGroupUserRelate aGroupUserRelate = new AGroupUserRelate();
        aGroupUserRelate.setUserId(userId);
        aGroupUserRelate.setDelFlag(Constants.DEL_FLAG_FALSE);
        List<AGroupUserRelate> relateList = aGroupUserRelateMapper.selectAGroupUserRelateList(aGroupUserRelate);
        List<String> gIds = relateList.stream().map(AGroupUserRelate::getGId).collect(Collectors.toList());
        // 通过群聊id集合，返回所有的群聊信息
        if(StringUtils.isListNull(gIds)){
            return new PageInfo<AGroupChatVo>();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<AGroupChat> poList = aGroupChatMapper.selectAGroupChatByIds(gIds);
        PageInfo pageInfo = new PageInfo(poList);
        List<AGroupChatVo> voList = BeanUtil.copyToList(poList, AGroupChatVo.class);
        pageInfo.setList(voList);
        return pageInfo;
    }

    /**
     * 新增【群聊】
     * @param dto 【群聊】
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAGroupChat(AGroupChatDto dto)
    {
        String tId = dto.getTId();
        String name = "";           // 群聊名称
        // 获取当前登录人
        LoginUser loginUser = SecurityUtils.getLoginUser();
        APostInvitation aPostInvitation = aPostInvitationMapper.selectAPostInvitationById(tId);
        if(StringUtils.isNull(aPostInvitation)){
            throw new ServiceException("没有找到对应的发帖信息");
        }
        if(StringUtils.isNotEmpty(dto.getName())){
            name = dto.getName();
        } else {
            name = aPostInvitation.getTitle();
        }
        AGroupChat aGroupChat = new AGroupChat();
        aGroupChat.setId(IdUtil.getSnowflakeNextIdStr());
        aGroupChat.setName(name);
        aGroupChat.settId(tId);
        aGroupChat.settName(aPostInvitation.getTitle());
        aGroupChat.setGroOwnId(dto.getGroOwnId());
        aGroupChat.setGroOwnName(dto.getGroOwnName());
        aGroupChat.setDelFlag(Constants.DEL_FLAG_FALSE);
        aGroupChat.setCreateBy(loginUser.getUsername());
        aGroupChat.setCreateTime(new Date());
        aGroupChatMapper.insertAGroupChat(aGroupChat);
        // 关联群主和群聊关系
        AGroupUserRelateDto relateDto = new AGroupUserRelateDto();
        relateDto.setGId(dto.getTId());
        relateDto.setUserId(dto.getGroOwnId());
        this.userJoinGroup(relateDto);
    }

    /**
     * 修改【群聊】
     * 
     * @param aGroupChat 【群聊】
     * @return 结果
     */
    @Override
    public int updateAGroupChat(AGroupChat aGroupChat)
    {
        aGroupChat.setUpdateTime(DateUtils.getNowDate());
        return aGroupChatMapper.updateAGroupChat(aGroupChat);
    }

    /**
     * 批量删除【群聊】
     * 
     * @param ids 需要删除的【群聊】主键
     * @return 结果
     */
    @Override
    public int deleteAGroupChatByIds(String[] ids)
    {
        return aGroupChatMapper.deleteAGroupChatByIds(ids);
    }

    /**
     * 删除【群聊】信息
     * 
     * @param id 【群聊】主键
     * @return 结果
     */
    @Override
    public int deleteAGroupChatById(String id)
    {
        return aGroupChatMapper.deleteAGroupChatById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userJoinGroup(AGroupUserRelateDto dto) {
        // 获取当前登录人
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String userId = dto.getUserId();
        String gId = dto.getGId();
        AGroupUserRelate aGroupUserRelate = new AGroupUserRelate();
        if(StringUtils.isNotEmpty(dto.getId())){
            // 删除操作
            aGroupUserRelate.setId(dto.getId());
            aGroupUserRelate.setDelFlag(Constants.DEL_FLAG_TRUE);
            aGroupUserRelate.setUpdateBy(loginUser.getUsername());
            aGroupUserRelate.setUpdateTime(new Date());
            aGroupUserRelateMapper.updateAGroupUserRelate(aGroupUserRelate);
        } else {
            // 新增
            aGroupUserRelate.setId(IdUtil.getSnowflakeNextIdStr());
            aGroupUserRelate.setUserId(userId);
            aGroupUserRelate.setGId(gId);
            aGroupUserRelate.setDelFlag(Constants.DEL_FLAG_FALSE);
            aGroupUserRelate.setCreateBy(loginUser.getUsername());
            aGroupUserRelate.setCreateTime(new Date());
            aGroupUserRelateMapper.insertAGroupUserRelate(aGroupUserRelate);
        }
        // 更新群聊人数
        aGroupUserRelate = new AGroupUserRelate();
        aGroupUserRelate.setGId(gId);
        aGroupUserRelate.setDelFlag(Constants.DEL_FLAG_FALSE);
        List<AGroupUserRelate> countList = aGroupUserRelateMapper.selectAGroupUserRelateList(aGroupUserRelate);
        AGroupChat aGroupChat = new AGroupChat();
        aGroupChat.settId(gId);
        aGroupChat.setPeoNum(countList.size());
        aGroupChatMapper.updateAGroupChat(aGroupChat);
    }

}
