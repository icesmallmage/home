package com.circle.web.system.service;

import com.circle.web.system.domain.SysHatCity;
import java.util.List;

/**
 * 【国内城市】Service接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface ISysHatCityService 
{
    /**
     * 查询【国内城市】
     * 
     * @param cid 【国内城市】主键
     * @return 【国内城市】
     */
    public SysHatCity selectSysHatCityByCid(String cid);

    /**
     * 查询【国内城市】列表
     * 
     * @param sysHatCity 【国内城市】
     * @return 【国内城市】集合
     */
    public List<SysHatCity> selectSysHatCityList(SysHatCity sysHatCity);

    /**
     * 通过省份id， 查询【国内城市】列表
     * @param provinceID
     * @return
     */
    public List<SysHatCity> selectSysHatCityList(String provinceID);

    /**
     * 新增【国内城市】
     * 
     * @param sysHatCity 【国内城市】
     * @return 结果
     */
    public int insertSysHatCity(SysHatCity sysHatCity);

    /**
     * 修改【国内城市】
     * 
     * @param sysHatCity 【国内城市】
     * @return 结果
     */
    public int updateSysHatCity(SysHatCity sysHatCity);

    /**
     * 批量删除【国内城市】
     * 
     * @param cids 需要删除的【国内城市】主键集合
     * @return 结果
     */
    public int deleteSysHatCityByCids(String[] cids);

    /**
     * 删除【国内城市】信息
     * 
     * @param cid 【国内城市】主键
     * @return 结果
     */
    public int deleteSysHatCityByCid(String cid);
}
