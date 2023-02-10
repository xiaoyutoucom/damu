package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产业资源对象 Industry_resources
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class IndustryResources extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 资源类型 */
    @Excel(name = "资源类型")
    private String type;

    /** 名字 */
    @Excel(name = "名字")
    private String projectName;

    /** 简介 */
    @Excel(name = "简介")
    private String synopsis;

    /** 导演作品 */
    @Excel(name = "导演作品")
    private String directorWorks;

    /** 主要作品 */
    @Excel(name = "主要作品")
    private String mainWorks;

    /** 电影 */
    @Excel(name = "电影")
    private String movie;

    /** 电视剧 */
    @Excel(name = "电视剧")
    private String series;

    /** 网络剧 */
    @Excel(name = "网络剧")
    private String networkPlay;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrl;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Long imageSort;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modified;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setSynopsis(String synopsis) 
    {
        this.synopsis = synopsis;
    }

    public String getSynopsis() 
    {
        return synopsis;
    }
    public void setDirectorWorks(String directorWorks) 
    {
        this.directorWorks = directorWorks;
    }

    public String getDirectorWorks() 
    {
        return directorWorks;
    }
    public void setMainWorks(String mainWorks) 
    {
        this.mainWorks = mainWorks;
    }

    public String getMainWorks() 
    {
        return mainWorks;
    }
    public void setMovie(String movie) 
    {
        this.movie = movie;
    }

    public String getMovie() 
    {
        return movie;
    }
    public void setSeries(String series) 
    {
        this.series = series;
    }

    public String getSeries() 
    {
        return series;
    }
    public void setNetworkPlay(String networkPlay) 
    {
        this.networkPlay = networkPlay;
    }

    public String getNetworkPlay() 
    {
        return networkPlay;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setImageSort(Long imageSort) 
    {
        this.imageSort = imageSort;
    }

    public Long getImageSort() 
    {
        return imageSort;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }
    public void setModified(Date modified) 
    {
        this.modified = modified;
    }

    public Date getModified() 
    {
        return modified;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("projectName", getProjectName())
            .append("synopsis", getSynopsis())
            .append("directorWorks", getDirectorWorks())
            .append("mainWorks", getMainWorks())
            .append("movie", getMovie())
            .append("series", getSeries())
            .append("networkPlay", getNetworkPlay())
            .append("imageUrl", getImageUrl())
            .append("imageSort", getImageSort())
            .append("created", getCreated())
            .append("modified", getModified())
            .toString();
    }
}
