package com.circle.web.system.service.impl;

import java.util.List;
import com.circle.web.system.domain.SysHatProvince;
import com.circle.web.system.mapper.SysHatProvinceMapper;
import com.circle.web.system.service.ISysHatProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【国内省份】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@Service
public class SysHatProvinceServiceImpl implements ISysHatProvinceService
{
    @Autowired
    private SysHatProvinceMapper sysHatProvinceMapper;

    /**
     * 查询【国内省份】
     * 
     * @param sid 【国内省份】主键
     * @return 【国内省份】
     */
    @Override
    public SysHatProvince selectSysHatProvinceBySid(String sid)
    {
        return sysHatProvinceMapper.selectSysHatProvinceBySid(sid);
    }

    /**
     * 查询【国内省份】列表
     * 
     * @param sysHatProvince 【国内省份】
     * @return 【国内省份】
     */
    @Override
    public List<SysHatProvince> selectSysHatProvinceList(SysHatProvince sysHatProvince)
    {
        return sysHatProvinceMapper.selectSysHatProvinceList(sysHatProvince);
    }

    /**
     * 新增【国内省份】
     * 
     * @param sysHatProvince 【国内省份】
     * @return 结果
     */
    @Override
    public int insertSysHatProvince(SysHatProvince sysHatProvince)
    {
        return sysHatProvinceMapper.insertSysHatProvince(sysHatProvince);
    }

    /**
     * 修改【国内省份】
     * 
     * @param sysHatProvince 【国内省份】
     * @return 结果
     */
    @Override
    public int updateSysHatProvince(SysHatProvince sysHatProvince)
    {
        return sysHatProvinceMapper.updateSysHatProvince(sysHatProvince);
    }

    /**
     * 批量删除【国内省份】
     * 
     * @param sids 需要删除的【国内省份】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatProvinceBySids(String[] sids)
    {
        return sysHatProvinceMapper.deleteSysHatProvinceBySids(sids);
    }

    /**
     * 删除【国内省份】信息
     * 
     * @param sid 【国内省份】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatProvinceBySid(String sid)
    {
        return sysHatProvinceMapper.deleteSysHatProvinceBySid(sid);
    }
}
