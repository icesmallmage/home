package com.circle.web.postinvitation.mapper;

import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public interface APostInvitationMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public APostInvitation selectAPostInvitationById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param aPostInvitation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<APostInvitation> selectAPostInvitationList(APostInvitation aPostInvitation);

    /**
     * 新增【请填写功能名称】
     * 
     * @param aPostInvitation 【请填写功能名称】
     * @return 结果
     */
    public int insertAPostInvitation(APostInvitation aPostInvitation);

    /**
     * 修改【请填写功能名称】
     * 
     * @param aPostInvitation 【请填写功能名称】
     * @return 结果
     */
    public int updateAPostInvitation(APostInvitationUpdateDto aPostInvitation);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAPostInvitationById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAPostInvitationByIds(String[] ids);

    public List<APostInvitation> selectOperateList(@Param("userId") String userId, @Param("operateType") String operateType);

}
