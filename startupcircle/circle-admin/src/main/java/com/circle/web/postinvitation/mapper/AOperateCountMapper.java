package com.circle.web.postinvitation.mapper;

import java.util.List;
import com.circle.web.postinvitation.domain.po.AOperateCount;

/**
 * 操作点赞,收藏的Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public interface AOperateCountMapper 
{
    /**
     * 查询操作点赞,收藏的
     * 
     * @param id 操作点赞,收藏的主键
     * @return 操作点赞,收藏的
     */
    public AOperateCount selectAOperateCountById(String id);

    /**
     * 查询操作点赞,收藏的列表
     * 
     * @param aOperateCount 操作点赞,收藏的
     * @return 操作点赞,收藏的集合
     */
    public List<AOperateCount> selectAOperateCountList(AOperateCount aOperateCount);

    /**
     * 新增操作点赞,收藏的
     * 
     * @param aOperateCount 操作点赞,收藏的
     * @return 结果
     */
    public int insertAOperateCount(AOperateCount aOperateCount);

    /**
     * 修改操作点赞,收藏的
     * 
     * @param aOperateCount 操作点赞,收藏的
     * @return 结果
     */
    public int updateAOperateCount(AOperateCount aOperateCount);

    /**
     * 删除操作点赞,收藏的
     * 
     * @param id 操作点赞,收藏的主键
     * @return 结果
     */
    public int deleteAOperateCountById(String id);

    /**
     * 批量删除操作点赞,收藏的
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAOperateCountByIds(String[] ids);
}
