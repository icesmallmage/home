package com.circle.web.system.mapper;

import com.circle.web.system.domain.SysHatProvince;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface SysHatProvinceMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param sid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysHatProvince selectSysHatProvinceBySid(String sid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysHatProvince 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysHatProvince> selectSysHatProvinceList(SysHatProvince sysHatProvince);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysHatProvince 【请填写功能名称】
     * @return 结果
     */
    public int insertSysHatProvince(SysHatProvince sysHatProvince);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysHatProvince 【请填写功能名称】
     * @return 结果
     */
    public int updateSysHatProvince(SysHatProvince sysHatProvince);

    /**
     * 删除【请填写功能名称】
     * 
     * @param sid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysHatProvinceBySid(String sid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysHatProvinceBySids(String[] sids);
}
