package com.circle.web.postinvitation.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.circle.common.constant.Constants;
import com.circle.common.core.domain.model.LoginUser;
import com.circle.common.utils.DateUtils;
import com.circle.common.utils.SecurityUtils;
import com.circle.web.postinvitation.domain.po.AOperateCount;
import com.circle.web.postinvitation.domain.po.APostInvitation;
import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.to.APostInvitationUpdateDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.circle.web.postinvitation.mapper.AOperateCountMapper;
import com.circle.web.postinvitation.mapper.APostInvitationMapper;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 【帖子信息表】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Service
public class APostInvitationServiceImpl implements IAPostInvitationService
{
    @Resource
    private APostInvitationMapper aPostInvitationMapper;

    @Resource
    private AOperateCountMapper aOperateCountMapper;

    @Override
    public PageInfo<APostInvitationVo> pageList(APostInvitationDto dto, int pageNum, int pageSize) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        PageHelper.startPage(pageNum, pageSize);
        List<APostInvitation> list = aPostInvitationMapper.selectAPostInvitationList(po);
        PageInfo pageInfo = new PageInfo(list);
        List<APostInvitationVo>  voList = BeanUtil.copyToList(list, APostInvitationVo.class);
        voList.forEach(t -> {
            AOperateCount aOperateCount = new AOperateCount();
            aOperateCount.settId(t.getId());
            aOperateCount.setUserId(String.valueOf(loginUser.getUserId()));
            aOperateCount.setIsOperate("1");
            List<AOperateCount> operateList = aOperateCountMapper.selectAOperateCountList(aOperateCount);
            List<String> operates = operateList.stream().map(AOperateCount::getOperateType).collect(Collectors.toList());
            if(operates.contains("0")){
                t.setBooView(true);
            }
            if(operates.contains("1")){
                t.setBooUpvote(true);
            }
        });
        pageInfo.setList(voList);
        return pageInfo;
    }

    /**
     * 查询【帖子信息表】列表
     *
     * @param dto 【帖子信息表】
     * @return 【帖子信息表】
     */
    @Override
    public List<APostInvitationVo> selectAPostInvitationList(APostInvitationDto dto)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        APostInvitation po = new APostInvitation();
        BeanUtil.copyProperties(dto, po);
        List<APostInvitation> list = aPostInvitationMapper.selectAPostInvitationList(po);
        List<APostInvitationVo>  voList = BeanUtil.copyToList(list, APostInvitationVo.class);
        voList.forEach(t -> {
            AOperateCount aOperateCount = new AOperateCount();
            aOperateCount.settId(t.getId());
            aOperateCount.setUserId(String.valueOf(loginUser.getUserId()));
            aOperateCount.setIsOperate("1");
            List<AOperateCount> operateList = aOperateCountMapper.selectAOperateCountList(aOperateCount);
            List<String> operates = operateList.stream().map(AOperateCount::getOperateType).collect(Collectors.toList());
            if(operates.contains("0")){
                t.setBooView(true);
            }
            if(operates.contains("1")){
                t.setBooUpvote(true);
            }
        });
        return voList;
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
        po.setUpvoteCount("0");
        po.setViewCount("0");
        po.setCriticCount("0");
        po.setDelFlag(Constants.DEL_FLAG_FALSE);
        po.setCreateTime(DateUtils.getNowDate());
        po.setCreateBy(loginUser.getUsername());
        return aPostInvitationMapper.insertAPostInvitation(po);
    }

    @Override
    public int updateAPostInvitation(APostInvitationUpdateDto dto) {
        return aPostInvitationMapper.updateAPostInvitation(dto);
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
