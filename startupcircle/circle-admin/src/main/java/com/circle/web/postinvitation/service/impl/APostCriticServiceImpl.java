package com.circle.web.postinvitation.service.impl;

import java.util.List;

import cn.hutool.core.util.IdUtil;
import com.circle.common.constant.Constants;
import com.circle.common.core.domain.model.LoginUser;
import com.circle.common.utils.DateUtils;
import com.circle.common.utils.SecurityUtils;
import com.circle.common.utils.StringUtils;
import com.circle.web.postinvitation.domain.po.APostCritic;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import com.circle.web.postinvitation.mapper.APostCriticMapper;
import com.circle.web.postinvitation.service.IAPostCriticService;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 【回复信息】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Service
public class APostCriticServiceImpl implements IAPostCriticService
{
    @Resource
    private APostCriticMapper aPostCriticMapper;

    @Autowired
    private IAPostInvitationService iaPostInvitationService;

    /**
     * 查询【回复信息】
     * 
     * @param id 【回复信息】主键
     * @return 【回复信息】
     */
    @Override
    public APostCritic selectAPostCriticById(Long id)
    {
        return aPostCriticMapper.selectAPostCriticById(id);
    }

    @Override
    public List<APostCritic> getInfoByid(Long id) {
        return aPostCriticMapper.getInfoByid(id);
    }

    /**
     * 查询【回复信息】列表
     * 
     * @param aPostCritic 【回复信息】
     * @return 【回复信息】
     */
    @Override
    public List<APostCritic> selectAPostCriticList(APostCritic aPostCritic)
    {
        return aPostCriticMapper.selectAPostCriticList(aPostCritic);
    }

    /**
     * 新增【回复信息】
     * 
     * @param aPostCritic 【回复信息】
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAPostCritic(APostCritic aPostCritic)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        aPostCritic.setId(IdUtil.getSnowflake().nextId());
        aPostCritic.setDelFlag(Constants.DEL_FLAG_FALSE);
        aPostCritic.setCreateBy(loginUser.getUsername());
        aPostCritic.setCreateTime(DateUtils.getNowDate());
        aPostCriticMapper.insertAPostCritic(aPostCritic);
        // 查询关联帖子id
        String postInvitationId = aPostCritic.getPostInvitationId();
        aPostCritic = new APostCritic();
        aPostCritic.setPostInvitationId(postInvitationId);
        // 查询评论量总数
        int criticCount = 0;
        List<APostCritic> aPostCriticList = aPostCriticMapper.selectAPostCriticList(aPostCritic);
        if(StringUtils.isListNotNull(aPostCriticList)){
            criticCount = aPostCriticList.size();
        }
        // 更新帖子表的评论数据
        APostInvitationUpdateDto dto = new APostInvitationUpdateDto();
        dto.setId(postInvitationId);
        dto.setCriticCount(String.valueOf(criticCount));
        iaPostInvitationService.updateAPostInvitation(dto);
        return 0;
    }

    /**
     * 修改【回复信息】
     * 
     * @param aPostCritic 【回复信息】
     * @return 结果
     */
    @Override
    public int updateAPostCritic(APostCritic aPostCritic)
    {
        aPostCritic.setUpdateTime(DateUtils.getNowDate());
        return aPostCriticMapper.updateAPostCritic(aPostCritic);
    }

    /**
     * 批量删除【回复信息】
     * 
     * @param ids 需要删除的【回复信息】主键
     * @return 结果
     */
    @Override
    public int deleteAPostCriticByIds(Long[] ids)
    {
        return aPostCriticMapper.deleteAPostCriticByIds(ids);
    }

    /**
     * 删除【回复信息】信息
     * 
     * @param id 【回复信息】主键
     * @return 结果
     */
    @Override
    public int deleteAPostCriticById(Long id)
    {
        return aPostCriticMapper.deleteAPostCriticById(id);
    }
}
