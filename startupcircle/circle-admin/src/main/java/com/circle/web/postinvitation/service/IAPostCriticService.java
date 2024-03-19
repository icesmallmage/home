package com.circle.web.postinvitation.service;

import com.circle.web.postinvitation.domain.po.APostCritic;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 【回复信息】Service接口
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public interface IAPostCriticService 
{
    /**
     * 查询【回复信息】
     * 
     * @param id 【回复信息】主键
     * @return 【回复信息】
     */
    public APostCritic selectAPostCriticById(Long id);

    /**
     * 获取【帖子回复信息】详细信息
     */
    public PageInfo<APostCritic> getInfoByid(Long id, Integer pageNum, Integer pageSize);

    /**
     * 查询【回复信息】列表
     * 
     * @param aPostCritic 【回复信息】
     * @return 【回复信息】集合
     */
    public List<APostCritic> selectAPostCriticList(APostCritic aPostCritic);

    /**
     * 新增【回复信息】
     * 
     * @param aPostCritic 【回复信息】
     * @return 结果
     */
    public int insertAPostCritic(APostCritic aPostCritic);

    /**
     * 修改【回复信息】
     * 
     * @param aPostCritic 【回复信息】
     * @return 结果
     */
    public int updateAPostCritic(APostCritic aPostCritic);

    /**
     * 批量删除【回复信息】
     * 
     * @param ids 需要删除的【回复信息】主键集合
     * @return 结果
     */
    public int deleteAPostCriticByIds(Long[] ids);

    /**
     * 删除【回复信息】信息
     * 
     * @param id 【回复信息】主键
     * @return 结果
     */
    public int deleteAPostCriticById(Long id);
}
