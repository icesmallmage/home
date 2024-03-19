package com.circle.web.postinvitation.service;

import com.circle.web.postinvitation.domain.po.AGroupChat;
import com.circle.web.postinvitation.domain.to.AGroupChatDto;
import com.circle.web.postinvitation.domain.to.AGroupUserRelateDto;
import com.circle.web.postinvitation.domain.vo.AGroupChatVo;
import com.github.pagehelper.PageInfo;

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


    public PageInfo<AGroupChatVo> groupChatPageList(Integer pageNum, Integer pageSize);


    /**
     * 新增【群聊】
     *
     * @param dto 【群聊】
     * @return 结果
     */
    public void insertAGroupChat(AGroupChatDto dto);

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

    public void userJoinGroup(AGroupUserRelateDto dto);
}
