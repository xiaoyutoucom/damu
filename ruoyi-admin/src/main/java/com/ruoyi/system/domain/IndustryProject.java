package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产业项目对象 Industry_project
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class IndustryProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 产业项目 */
    @Excel(name = "产业项目")
    private String type;

    /** 名字 */
    @Excel(name = "名字")
    private String projectName;

    /** 导演名称 */
    @Excel(name = "导演名称")
    private String directorName;

    /** 编剧 */
    @Excel(name = "编剧")
    private String writersName;

    /** 主演 */
    @Excel(name = "主演")
    private String starring;

    /** 上映时间/播出时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上映时间/播出时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 剧情概要 */
    @Excel(name = "剧情概要")
    private String synopsis;

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

    /** 播出平台 */
    @Excel(name = "播出平台")
    private String platform;

    /** 节目类型 */
    @Excel(name = "节目类型")
    private String programType;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrl;

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
    public void setDirectorName(String directorName) 
    {
        this.directorName = directorName;
    }

    public String getDirectorName() 
    {
        return directorName;
    }
    public void setWritersName(String writersName) 
    {
        this.writersName = writersName;
    }

    public String getWritersName() 
    {
        return writersName;
    }
    public void setStarring(String starring) 
    {
        this.starring = starring;
    }

    public String getStarring() 
    {
        return starring;
    }
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }
    public void setSynopsis(String synopsis) 
    {
        this.synopsis = synopsis;
    }

    public String getSynopsis() 
    {
        return synopsis;
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
    public void setPlatform(String platform) 
    {
        this.platform = platform;
    }

    public String getPlatform() 
    {
        return platform;
    }
    public void setProgramType(String programType) 
    {
        this.programType = programType;
    }

    public String getProgramType() 
    {
        return programType;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("projectName", getProjectName())
            .append("directorName", getDirectorName())
            .append("writersName", getWritersName())
            .append("starring", getStarring())
            .append("releaseTime", getReleaseTime())
            .append("synopsis", getSynopsis())
            .append("imageSort", getImageSort())
            .append("created", getCreated())
            .append("modified", getModified())
            .append("platform", getPlatform())
            .append("programType", getProgramType())
            .append("imageUrl", getImageUrl())
            .toString();
    }
}
