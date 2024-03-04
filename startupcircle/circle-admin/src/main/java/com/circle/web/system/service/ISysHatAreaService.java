package com.circle.web.system.service;

import com.circle.web.system.domain.SysHatArea;
import java.util.List;

/**
 * 【国内城市区号】Service接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface ISysHatAreaService 
{
    /**
     * 查询【国内城市区号】
     * 
     * @param rid 【国内城市区号】主键
     * @return 【国内城市区号】
     */
    public SysHatArea selectSysHatAreaByRid(String rid);

    /**
     * 查询【国内城市区号】列表
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 【国内城市区号】集合
     */
    public List<SysHatArea> selectSysHatAreaList(SysHatArea sysHatArea);

    /**
     * 新增【国内城市区号】
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 结果
     */
    public int insertSysHatArea(SysHatArea sysHatArea);

    /**
     * 修改【国内城市区号】
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 结果
     */
    public int updateSysHatArea(SysHatArea sysHatArea);

    /**
     * 批量删除【国内城市区号】
     * 
     * @param rids 需要删除的【国内城市区号】主键集合
     * @return 结果
     */
    public int deleteSysHatAreaByRids(String[] rids);

    /**
     * 删除【国内城市区号】信息
     * 
     * @param rid 【国内城市区号】主键
     * @return 结果
     */
    public int deleteSysHatAreaByRid(String rid);
}
