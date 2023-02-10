package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.IndustryProject;

/**
 * 产业项目Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface IIndustryProjectService 
{
    /**
     * 查询产业项目
     * 
     * @param id 产业项目主键
     * @return 产业项目
     */
    public IndustryProject selectIndustryProjectById(Long id);

    /**
     * 查询产业项目列表
     * 
     * @param industryProject 产业项目
     * @return 产业项目集合
     */
    public List<IndustryProject> selectIndustryProjectList(IndustryProject industryProject);

    /**
     * 新增产业项目
     * 
     * @param industryProject 产业项目
     * @return 结果
     */
    public int insertIndustryProject(IndustryProject industryProject);

    /**
     * 修改产业项目
     * 
     * @param industryProject 产业项目
     * @return 结果
     */
    public int updateIndustryProject(IndustryProject industryProject);

    /**
     * 批量删除产业项目
     * 
     * @param ids 需要删除的产业项目主键集合
     * @return 结果
     */
    public int deleteIndustryProjectByIds(String ids);

    /**
     * 删除产业项目信息
     * 
     * @param id 产业项目主键
     * @return 结果
     */
    public int deleteIndustryProjectById(Long id);
}
