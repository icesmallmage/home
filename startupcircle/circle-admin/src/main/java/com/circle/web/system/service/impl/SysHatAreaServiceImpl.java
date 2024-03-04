package com.circle.web.system.service.impl;

import java.util.List;
import com.circle.web.system.domain.SysHatArea;
import com.circle.web.system.mapper.SysHatAreaMapper;
import com.circle.web.system.service.ISysHatAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【国内城市区号】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@Service
public class SysHatAreaServiceImpl implements ISysHatAreaService
{
    @Autowired
    private SysHatAreaMapper sysHatAreaMapper;

    /**
     * 查询【国内城市区号】
     * 
     * @param rid 【国内城市区号】主键
     * @return 【国内城市区号】
     */
    @Override
    public SysHatArea selectSysHatAreaByRid(String rid)
    {
        return sysHatAreaMapper.selectSysHatAreaByRid(rid);
    }

    /**
     * 查询【国内城市区号】列表
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 【国内城市区号】
     */
    @Override
    public List<SysHatArea> selectSysHatAreaList(SysHatArea sysHatArea)
    {
        return sysHatAreaMapper.selectSysHatAreaList(sysHatArea);
    }

    /**
     * 新增【国内城市区号】
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 结果
     */
    @Override
    public int insertSysHatArea(SysHatArea sysHatArea)
    {
        return sysHatAreaMapper.insertSysHatArea(sysHatArea);
    }

    /**
     * 修改【国内城市区号】
     * 
     * @param sysHatArea 【国内城市区号】
     * @return 结果
     */
    @Override
    public int updateSysHatArea(SysHatArea sysHatArea)
    {
        return sysHatAreaMapper.updateSysHatArea(sysHatArea);
    }

    /**
     * 批量删除【国内城市区号】
     * 
     * @param rids 需要删除的【国内城市区号】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatAreaByRids(String[] rids)
    {
        return sysHatAreaMapper.deleteSysHatAreaByRids(rids);
    }

    /**
     * 删除【国内城市区号】信息
     * 
     * @param rid 【国内城市区号】主键
     * @return 结果
     */
    @Override
    public int deleteSysHatAreaByRid(String rid)
    {
        return sysHatAreaMapper.deleteSysHatAreaByRid(rid);
    }
}
