package com.ruoyi.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.IndustryProject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.IndustryResources;
import com.ruoyi.system.service.IIndustryResourcesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产业资源Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/resources")
public class IndustryResourcesController extends BaseController
{
    private String prefix = "system/resources";

    @Autowired
    private IIndustryResourcesService industryResourcesService;

    @RequiresPermissions("system:resources:view")
    @GetMapping()
    public String resources()
    {
        return prefix + "/resources";
    }
    /**
     *
     */
    @GetMapping("/get")
    @ResponseBody
    public R<IndustryResources> getUser( long id)
    {
        return R.ok(industryResourcesService.selectIndustryResourcesById(id));
    }
    /**
     * 查询产业资源列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IndustryResources industryResources)
    {
        startPage();
        List<IndustryResources> list = industryResourcesService.selectIndustryResourcesList(industryResources);
        return getDataTable(list);
    }

    /**
     * 导出产业资源列表
     */
    @RequiresPermissions("system:resources:export")
    @Log(title = "产业资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IndustryResources industryResources)
    {
        List<IndustryResources> list = industryResourcesService.selectIndustryResourcesList(industryResources);
        ExcelUtil<IndustryResources> util = new ExcelUtil<IndustryResources>(IndustryResources.class);
        return util.exportExcel(list, "产业资源数据");
    }

    /**
     * 新增产业资源
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产业资源
     */
    @RequiresPermissions("system:resources:add")
    @Log(title = "产业资源", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IndustryResources industryResources)
    {
        try {
            industryResources.setMainWorks(java.net.URLDecoder.decode(industryResources.getMainWorks(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return toAjax(industryResourcesService.insertIndustryResources(industryResources));
    }

    /**
     * 修改产业资源
     */
    @RequiresPermissions("system:resources:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IndustryResources industryResources = industryResourcesService.selectIndustryResourcesById(id);
        mmap.put("industryResources", industryResources);
        return prefix + "/edit";
    }

    /**
     * 修改保存产业资源
     */
    @RequiresPermissions("system:resources:edit")
    @Log(title = "产业资源", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IndustryResources industryResources)
    {
        try {
            industryResources.setMainWorks(java.net.URLDecoder.decode(industryResources.getMainWorks(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return toAjax(industryResourcesService.updateIndustryResources(industryResources));
    }

    /**
     * 删除产业资源
     */
    @RequiresPermissions("system:resources:remove")
    @Log(title = "产业资源", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(industryResourcesService.deleteIndustryResourcesByIds(ids));
    }
}
