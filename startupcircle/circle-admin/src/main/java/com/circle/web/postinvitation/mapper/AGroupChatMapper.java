package com.circle.web.postinvitation.mapper;

import com.circle.web.postinvitation.domain.po.AGroupChat;

import java.util.List;

/**
 * 【群聊】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-08
 */
public interface AGroupChatMapper 
{
    /**
     * 查询【群聊】
     * 
     * @param id 【群聊】主键
     * @return 【群聊】
     */
    public AGroupChat selectAGroupChatById(String id);

    public List<AGroupChat> selectAGroupChatByIds(List<String> ids);

    /**
     * 查询【群聊】列表
     * 
     * @param aGroupChat 【群聊】
     * @return 【群聊】集合
     */
    public List<AGroupChat> selectAGroupChatList(AGroupChat aGroupChat);

    /**
     * 查询所有群聊id
     */
    public List<String> selectIds();

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
     * 删除【群聊】
     * 
     * @param id 【群聊】主键
     * @return 结果
     */
    public int deleteAGroupChatById(String id);

    /**
     * 批量删除【群聊】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAGroupChatByIds(String[] ids);
}
