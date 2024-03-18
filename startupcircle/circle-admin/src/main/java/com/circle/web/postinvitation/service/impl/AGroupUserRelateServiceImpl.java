package com.circle.web.postinvitation.service.impl;

import com.circle.common.utils.DateUtils;
import com.circle.web.postinvitation.domain.po.AGroupUserRelate;
import com.circle.web.postinvitation.mapper.AGroupUserRelateMapper;
import com.circle.web.postinvitation.service.IAGroupUserRelateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 【群聊与用户关系】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-08
 */
@Service
public class AGroupUserRelateServiceImpl implements IAGroupUserRelateService {

    @Resource
    private AGroupUserRelateMapper aGroupUserRelateMapper;

    /**
     * 查询【群聊与用户关系】
     *
     * @param id 【群聊与用户关系】主键
     * @return 【群聊与用户关系】
     */
    @Override
    public AGroupUserRelate selectAGroupUserRelateById(String id)
    {
        return aGroupUserRelateMapper.selectAGroupUserRelateById(id);
    }

    /**
     * 查询【群聊与用户关系】列表
     *
     * @param aGroupUserRelate 【群聊与用户关系】
     * @return 【群聊与用户关系】
     */
    @Override
    public List<AGroupUserRelate> selectAGroupUserRelateList(AGroupUserRelate aGroupUserRelate)
    {
        return aGroupUserRelateMapper.selectAGroupUserRelateList(aGroupUserRelate);
    }

    /**
     * 新增【群聊与用户关系】
     *
     * @param aGroupUserRelate 【群聊与用户关系】
     * @return 结果
     */
    @Override
    public int insertAGroupUserRelate(AGroupUserRelate aGroupUserRelate)
    {
        aGroupUserRelate.setCreateTime(DateUtils.getNowDate());
        return aGroupUserRelateMapper.insertAGroupUserRelate(aGroupUserRelate);
    }

    /**
     * 修改【群聊与用户关系】
     *
     * @param AGroupUserRelate 【群聊与用户关系】
     * @return 结果
     */
    @Override
    public int updateAGroupUserRelate(AGroupUserRelate aGroupUserRelate)
    {
        aGroupUserRelate.setUpdateTime(DateUtils.getNowDate());
        return aGroupUserRelateMapper.updateAGroupUserRelate(aGroupUserRelate);
    }

    /**
     * 批量删除【群聊与用户关系】
     *
     * @param ids 需要删除的【群聊与用户关系】主键
     * @return 结果
     */
    @Override
    public int deleteAGroupUserRelateByIds(String[] ids)
    {
        return aGroupUserRelateMapper.deleteAGroupUserRelateByIds(ids);
    }

    /**
     * 删除【群聊与用户关系】信息
     *
     * @param id 【群聊与用户关系】主键
     * @return 结果
     */
    @Override
    public int deleteAGroupUserRelateById(String id)
    {
        return aGroupUserRelateMapper.deleteAGroupUserRelateById(id);
    }
}
