package com.circle.web.postinvitation.service;

import com.circle.web.postinvitation.domain.po.AGroupChat;

import java.util.List;

/**
 * 【群聊】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-08
 */
public interface IAGroupChatService 
{
    /**
     * 查询【群聊】
     * 
     * @param id 【群聊】主键
     * @return 【群聊】
     */
    public AGroupChat selectAGroupChatById(String id);

    /**
     * 查询【群聊】列表
     * 
     * @param aGroupChat 【群聊】
     * @return 【群聊】集合
     */
    public List<AGroupChat> selectAGroupChatList(AGroupChat aGroupChat);

    /**
     * 新增【群聊】
     * 
     * @param aGroupChat 【群聊】
     * @return 结果
     */
    public int insertAGroupChat(AGroupChat aGroupChat);

    /**
     * 修改【群聊】
     * 
     * @param aGroupChat 【群聊】
     * @return 结果
     */
    public int updateAGroupChat(AGroupChat aGroupChat);

    /**
     * 批量删除【群聊】
     * 
     * @param ids 需要删除的【群聊】主键集合
     * @return 结果
     */
    public int deleteAGroupChatByIds(String[] ids);

    /**
     * 删除【群聊】信息
     * 
     * @param id 【群聊】主键
     * @return 结果
     */
    public int deleteAGroupChatById(String id);
}
