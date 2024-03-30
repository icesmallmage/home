package com.circle.web.postinvitation.mapper;

import com.circle.web.postinvitation.domain.po.APostCritic;
import com.circle.web.postinvitation.domain.vo.APostCriticVo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public interface APostCriticMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public APostCritic selectAPostCriticById(Long id);

    /**
     * 获取【帖子回复信息】详细信息
     * @param id
     * @return
     */
    void callInfoById(Long id);
    public List<APostCritic> getInfoById();

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param aPostCritic 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<APostCritic> selectAPostCriticList(APostCritic aPostCritic);

    /**
     * 新增【请填写功能名称】
     * 
     * @param aPostCritic 【请填写功能名称】
     * @return 结果
     */
    public int insertAPostCritic(APostCritic aPostCritic);

    /**
     * 修改【请填写功能名称】
     * 
     * @param aPostCritic 【请填写功能名称】
     * @return 结果
     */
    public int updateAPostCritic(APostCritic aPostCritic);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAPostCriticById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAPostCriticByIds(Long[] ids);

    public List<APostCriticVo> getCriticInfoByUserId(APostCritic aPostCritic);

    public List<APostCriticVo> getReplyInfoByUserId(APostCritic aPostCritic);
}
