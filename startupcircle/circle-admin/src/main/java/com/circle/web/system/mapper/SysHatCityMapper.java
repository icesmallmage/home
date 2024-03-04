package com.circle.web.system.mapper;

import com.circle.web.system.domain.SysHatCity;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface SysHatCityMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param cid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysHatCity selectSysHatCityByCid(String cid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysHatCity 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysHatCity> selectSysHatCityList(SysHatCity sysHatCity);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysHatCity 【请填写功能名称】
     * @return 结果
     */
    public int insertSysHatCity(SysHatCity sysHatCity);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysHatCity 【请填写功能名称】
     * @return 结果
     */
    public int updateSysHatCity(SysHatCity sysHatCity);

    /**
     * 删除【请填写功能名称】
     * 
     * @param cid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysHatCityByCid(String cid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param cids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysHatCityByCids(String[] cids);
}
