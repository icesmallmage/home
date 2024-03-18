package com.circle.web.postinvitation.service.impl;

import java.util.List;

import com.circle.common.utils.DateUtils;
import com.circle.web.postinvitation.domain.po.AGroupChat;
import com.circle.web.postinvitation.mapper.AGroupChatMapper;
import com.circle.web.postinvitation.service.IAGroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 新增【群聊】
     * 
     * @param aGroupChat 【群聊】
     * @return 结果
     */
    @Override
    public int insertAGroupChat(AGroupChat aGroupChat)
    {
        aGroupChat.setCreateTime(DateUtils.getNowDate());
        return aGroupChatMapper.insertAGroupChat(aGroupChat);
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
}
