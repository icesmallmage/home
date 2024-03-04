package com.circle.web.system.mapper;

import com.circle.web.system.domain.SysHatArea;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface SysHatAreaMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param rid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysHatArea selectSysHatAreaByRid(String rid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysHatArea 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysHatArea> selectSysHatAreaList(SysHatArea sysHatArea);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysHatArea 【请填写功能名称】
     * @return 结果
     */
    public int insertSysHatArea(SysHatArea sysHatArea);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysHatArea 【请填写功能名称】
     * @return 结果
     */
    public int updateSysHatArea(SysHatArea sysHatArea);

    /**
     * 删除【请填写功能名称】
     * 
     * @param rid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysHatAreaByRid(String rid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysHatAreaByRids(String[] rids);
}
