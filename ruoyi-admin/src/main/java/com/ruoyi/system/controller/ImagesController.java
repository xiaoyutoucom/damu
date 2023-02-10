package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.system.domain.Images;
import com.ruoyi.system.service.IImagesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-10-13
 */
@Api("轮播图信息管理")
@Controller
@RequestMapping("/system/images")
public class ImagesController extends BaseController
{
    private String prefix = "system/images";

    @Autowired
    private IImagesService imagesService;

    @RequiresPermissions("system:images:view")
    @GetMapping()
    public String images()
    {
        return prefix + "/images";
    }
    /**
     *
     */
    @GetMapping("/get")
    @ResponseBody
    public R<Images> getUser(@PathVariable long id)
    {
            return R.ok(imagesService.selectImagesById(id));
    }
    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("获取列表")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Images images)
    {
        startPage();
        List<Images> list = imagesService.selectImagesList(images);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Images images)
    {
        List<Images> list = imagesService.selectImagesList(images);
        ExcelUtil<Images> util = new ExcelUtil<Images>(Images.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【添加】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Images images)
    {

        return toAjax(imagesService.insertImages(images));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Images images = imagesService.selectImagesById(id);
        mmap.put("images", images);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Images images)
    {
        return toAjax(imagesService.updateImages(images));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(imagesService.deleteImagesByIds(ids));
    }
}
