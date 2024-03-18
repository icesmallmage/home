package com.circle.web.postinvitation.service;

import com.circle.web.postinvitation.domain.po.AGroupUserRelate;

import java.util.List;

/**
 * 【群聊与用户关系】Service接口
 *
 * @author ruoyi
 * @date 2024-03-08
 */
public interface IAGroupUserRelateService {

    /**
     * 查询【群聊与用户关系】
     *
     * @param id 【群聊与用户关系】主键
     * @return 【群聊与用户关系】
     */
    public AGroupUserRelate selectAGroupUserRelateById(String id);

    /**
     * 查询【群聊与用户关系】列表
     *
     * @param aGroupUserRelate 【群聊与用户关系】
     * @return 【群聊与用户关系】集合
     */
    public List<AGroupUserRelate> selectAGroupUserRelateList(AGroupUserRelate aGroupUserRelate);

    /**
     * 新增【群聊与用户关系】
     *
     * @param aGroupUserRelate 【群聊与用户关系】
     * @return 结果
     */
    public int insertAGroupUserRelate(AGroupUserRelate aGroupUserRelate);

    /**
     * 修改【群聊与用户关系】
     *
     * @param aGroupUserRelate 【群聊与用户关系】
     * @return 结果
     */
    public int updateAGroupUserRelate(AGroupUserRelate aGroupUserRelate);

    /**
     * 批量删除【群聊与用户关系】
     *
     * @param ids 需要删除的【群聊与用户关系】主键集合
     * @return 结果
     */
    public int deleteAGroupUserRelateByIds(String[] ids);

    /**
     * 删除【群聊与用户关系】信息
     *
     * @param id 【群聊与用户关系】主键
     * @return 结果
     */
    public int deleteAGroupUserRelateById(String id);
    
}
