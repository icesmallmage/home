package com.circle.web.postinvitation.service;

import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 【帖子信息表】Service接口
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public interface IAPostInvitationService 
{

    PageInfo<APostInvitationVo> pageList(APostInvitationDto dto, Integer pageNum, Integer pageSize);


    /**
     * 查询【帖子信息表】列表
     * 
     * @param dto 【帖子信息表】
     * @return 【帖子信息表】集合
     */
    public List<APostInvitationVo> selectAPostInvitationList(APostInvitationDto dto);


    /**
     * 新增【帖子信息表】
     * 
     * @param dto 【帖子信息表】
     * @return 结果
     */
    public int insertAPostInvitation(APostInvitationAddDto dto);

    /**
     * 修改帖子信息
     */
    public int updateAPostInvitation(APostInvitationUpdateDto dto);


    /**
     * 批量删除【帖子信息表】
     *
     * @param ids 需要删除的【帖子信息表】主键集合
     * @return 结果
     */
    public int deleteAPostInvitationByIds(String[] ids);

    /**
     * 删除【帖子信息表】信息
     *
     * @param id 【帖子信息表】主键
     * @return 结果
     */
    public int deleteAPostInvitationById(String id);

    public PageInfo<APostInvitationVo> operateList(String operateType, Integer pageNum, Integer pageSize);

}
