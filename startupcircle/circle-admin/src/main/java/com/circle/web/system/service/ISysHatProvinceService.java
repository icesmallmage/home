package com.circle.web.system.service;

import com.circle.web.system.domain.SysHatProvince;
import java.util.List;

/**
 * 【国内省份】Service接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface ISysHatProvinceService
{
    /**
     * 查询【国内省份】
     * 
     * @param sid 【国内省份】主键
     * @return 【国内省份】
     */
    public SysHatProvince selectSysHatProvinceBySid(String sid);

    /**
     * 查询【国内省份】列表
     * 
     * @param sysHatProvince 【国内省份】
     * @return 【国内省份】集合
     */
    public List<SysHatProvince> selectSysHatProvinceList(SysHatProvince sysHatProvince);

    /**
     * 新增【国内省份】
     * 
     * @param sysHatProvince 【国内省份】
     * @return 结果
     */
    public int insertSysHatProvince(SysHatProvince sysHatProvince);

    /**
     * 修改【国内省份】
     * 
     * @param sysHatProvince 【国内省份】
     * @return 结果
     */
    public int updateSysHatProvince(SysHatProvince sysHatProvince);

    /**
     * 批量删除【国内省份】
     * 
     * @param sids 需要删除的【国内省份】主键集合
     * @return 结果
     */
    public int deleteSysHatProvinceBySids(String[] sids);

    /**
     * 删除【国内省份】信息
     * 
     * @param sid 【国内省份】主键
     * @return 结果
     */
    public int deleteSysHatProvinceBySid(String sid);
}
