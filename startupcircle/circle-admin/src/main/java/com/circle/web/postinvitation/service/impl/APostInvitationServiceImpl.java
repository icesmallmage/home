package com.circle.web.postinvitation.service.impl;

import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.circle.common.core.domain.model.LoginUser;
import com.circle.common.utils.DateUtils;
import com.circle.common.utils.SecurityUtils;
import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.circle.web.postinvitation.mapper.APostInvitationMapper;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【帖子信息表】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Service
public class APostInvitationServiceImpl implements IAPostInvitationService
{
    @Autowired
    private APostInvitationMapper aPostInvitationMapper;

    /**
     * 查询【帖子信息表】列表
     *
     * @param dto 【帖子信息表】
     * @return 【帖子信息表】
     */
    @Override
    public List<APostInvitationVo> selectAPostInvitationList(APostInvitationDto dto)
    {
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        List<APostInvitation> list = aPostInvitationMapper.selectAPostInvitationList(po);
        return BeanUtil.copyToList(list, APostInvitationVo.class);
    }

    /**
     * 新增【帖子信息表】
     * 
     * @param dto 【帖子信息表】
     * @return 结果
     */
    @Override
    public int insertAPostInvitation(APostInvitationAddDto dto)
    {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        po.setId(String.valueOf(IdUtil.getSnowflake().nextId()));
        po.setCreateTime(DateUtils.getNowDate());
        po.setCreateBy(loginUser.getUsername());
        return aPostInvitationMapper.insertAPostInvitation(po);
    }

    /**
     * 批量删除【帖子信息表】
     * 
     * @param ids 需要删除的【帖子信息表】主键
     * @return 结果
     */
    @Override
    public int deleteAPostInvitationByIds(String[] ids)
    {
        return aPostInvitationMapper.deleteAPostInvitationByIds(ids);
    }

    /**
     * 删除【帖子信息表】信息
     * 
     * @param id 【帖子信息表】主键
     * @return 结果
     */
    @Override
    public int deleteAPostInvitationById(String id)
    {
        return aPostInvitationMapper.deleteAPostInvitationById(id);
    }
}
