package com.circle.web.system.service.impl;

import java.util.List;
import com.circle.web.system.domain.SysHatCity;
import com.circle.web.system.mapper.SysHatCityMapper;
import com.circle.web.system.service.ISysHatCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【国内城市】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@Service
public class SysHatCityServiceImpl implements ISysHatCityService
{
    @Autowired
    private SysHatCityMapper sysHatCityMapper;

    /**
     * 查询【国内城市】
     * 
     * @param cid 【国内城市】主键
     * @return 【国内城市】
     */
    @Override
    public SysHatCity selectSysHatCityByCid(String cid)
    {
        return sysHatCityMapper.selectSysHatCityByCid(cid);
    }

    /**
     * 查询【国内城市】列表
     * 
     * @param sysHatCity 【国内城市】
     * @return 【国内城市】
     */
    @Override
    public List<SysHatCity> selectSysHatCityList(SysHatCity sysHatCity)
    {
        return sysHatCityMapper.selectSysHatCityList(sysHatCity);
    }

    @Override
    public List<SysHatCity> selectSysHatCityList(String provinceID) {
        SysHatCity sysHatCity = new SysHatCity();
        sysHatCity.setFather(provinceID);
        return this.selectSysHatCityList(sysHatCity);
    }

    /**
     * 新增【国内城市】
     * 
     * @param sysHatCity 【国内城市】
     * @return 结果
     */
    @Override
    public int insertSysHatCity(SysHatCity sysHatCity)
    {
        return sysHatCityMapper.insertSysHatCity(sysHatCity);
    }

    /**
     * 修改【国内城市】
     * 
     * @param sysHatCity 【国内城市】
     * @return 结果
     */
    @Override
    public int updateSysHatCity(SysHatCity sysHatCity)
    {
        return sysHatCityMapper.updateSysHatCity(sysHatCity);
    }

    /**
     * 批量删除【国内城市】
     * 
     * @param cids 需要删除的【国内城市】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatCityByCids(String[] cids)
    {
        return sysHatCityMapper.deleteSysHatCityByCids(cids);
    }

    /**
     * 删除【国内城市】信息
     * 
     * @param cid 【国内城市】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatCityByCid(String cid)
    {
        return sysHatCityMapper.deleteSysHatCityByCid(cid);
    }
}
