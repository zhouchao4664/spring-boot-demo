package com.zhouchao.elasticsearch.domain;

import java.io.Serializable;

/**
 * example
 * @author 
 */
public class Example implements Serializable {
    private Integer id;

    /**
     * 案例id
     */
    private String pid;

    /**
     * 项目名称
     */
    private String pname;

    /**
     * 说明
     */
    private String description;

    /**
     * 图标
     */
    private String icon;

    /**
     * 背景图
     */
    private String background;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 尺寸
     */
    private String projectSize;

    /**
     * 适用终端类型(20001-web/mobile,20002-open,20003-web,20004-mobile)
     */
    private Integer terminal;

    /**
     * 发布状态（10900未发布，10901发布,10904审核未通过，10905待审核，10906举报下线）
     */
    private Integer statusPublish;

    /**
     * 点赞量
     */
    private Integer likeNum;

    /**
     * 浏览量
     */
    private Integer browseNum;

    /**
     * 收藏数
     */
    private Integer collectNum;

    /**
     * 分享量
     */
    private Integer shareNum;

    /**
     * 是否为官方案例(10800非官方案例10801官方案例)
     */
    private Integer official;

    /**
     * 发布时间
     */
    private Long publishTime;

    /**
     * 文件夹id
     */
    private Integer folderId;

    /**
     * 数据状态
     */
    private Integer status;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 封面标题
     */
    private String coverTitle;

    /**
     * 自定义封面图url
     */
    private String customCoverUrl;

    /**
     * 封面使用的样式 默认-0无样式,其它由前端传过来什么就保存什么下标位置
     */
    private Integer coverStylePosition;

    /**
     * 自定义原生封面图url
     */
    private String customCoverOriginUrl;

    /**
     * 审核人
     */
    private String examiner;

    /**
     * 审核时间
     */
    private Long examineTime;

    /**
     * 10600 ipad-tool,10603 web-tool,10604 小程序，10610lite-ios,10611lite-android
     */
    private Integer source;

    /**
     * 是否允许项目视频和图片分享下载(0不允许1允许)
     */
    private Boolean ifDownload;

    /**
     * lite 1.3.0v
     */
    private String userName;

    public void setUserName(String userName){this.userName = userName;}

    public String getUserName(){return userName;}

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getProjectSize() {
        return projectSize;
    }

    public void setProjectSize(String projectSize) {
        this.projectSize = projectSize;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public Integer getStatusPublish() {
        return statusPublish;
    }

    public void setStatusPublish(Integer statusPublish) {
        this.statusPublish = statusPublish;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getOfficial() {
        return official;
    }

    public void setOfficial(Integer official) {
        this.official = official;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCoverTitle() {
        return coverTitle;
    }

    public void setCoverTitle(String coverTitle) {
        this.coverTitle = coverTitle;
    }

    public String getCustomCoverUrl() {
        return customCoverUrl;
    }

    public void setCustomCoverUrl(String customCoverUrl) {
        this.customCoverUrl = customCoverUrl;
    }

    public Integer getCoverStylePosition() {
        return coverStylePosition;
    }

    public void setCoverStylePosition(Integer coverStylePosition) {
        this.coverStylePosition = coverStylePosition;
    }

    public String getCustomCoverOriginUrl() {
        return customCoverOriginUrl;
    }

    public void setCustomCoverOriginUrl(String customCoverOriginUrl) {
        this.customCoverOriginUrl = customCoverOriginUrl;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public Long getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Long examineTime) {
        this.examineTime = examineTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Boolean getIfDownload() {
        return ifDownload;
    }

    public void setIfDownload(Boolean ifDownload) {
        this.ifDownload = ifDownload;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Example other = (Example) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getBackground() == null ? other.getBackground() == null : this.getBackground().equals(other.getBackground()))
            && (this.getVideoUrl() == null ? other.getVideoUrl() == null : this.getVideoUrl().equals(other.getVideoUrl()))
            && (this.getProjectSize() == null ? other.getProjectSize() == null : this.getProjectSize().equals(other.getProjectSize()))
            && (this.getTerminal() == null ? other.getTerminal() == null : this.getTerminal().equals(other.getTerminal()))
            && (this.getStatusPublish() == null ? other.getStatusPublish() == null : this.getStatusPublish().equals(other.getStatusPublish()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getBrowseNum() == null ? other.getBrowseNum() == null : this.getBrowseNum().equals(other.getBrowseNum()))
            && (this.getCollectNum() == null ? other.getCollectNum() == null : this.getCollectNum().equals(other.getCollectNum()))
            && (this.getShareNum() == null ? other.getShareNum() == null : this.getShareNum().equals(other.getShareNum()))
            && (this.getOfficial() == null ? other.getOfficial() == null : this.getOfficial().equals(other.getOfficial()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getFolderId() == null ? other.getFolderId() == null : this.getFolderId().equals(other.getFolderId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCoverTitle() == null ? other.getCoverTitle() == null : this.getCoverTitle().equals(other.getCoverTitle()))
            && (this.getCustomCoverUrl() == null ? other.getCustomCoverUrl() == null : this.getCustomCoverUrl().equals(other.getCustomCoverUrl()))
            && (this.getCoverStylePosition() == null ? other.getCoverStylePosition() == null : this.getCoverStylePosition().equals(other.getCoverStylePosition()))
            && (this.getCustomCoverOriginUrl() == null ? other.getCustomCoverOriginUrl() == null : this.getCustomCoverOriginUrl().equals(other.getCustomCoverOriginUrl()))
            && (this.getExaminer() == null ? other.getExaminer() == null : this.getExaminer().equals(other.getExaminer()))
            && (this.getExamineTime() == null ? other.getExamineTime() == null : this.getExamineTime().equals(other.getExamineTime()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getIfDownload() == null ? other.getIfDownload() == null : this.getIfDownload().equals(other.getIfDownload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getBackground() == null) ? 0 : getBackground().hashCode());
        result = prime * result + ((getVideoUrl() == null) ? 0 : getVideoUrl().hashCode());
        result = prime * result + ((getProjectSize() == null) ? 0 : getProjectSize().hashCode());
        result = prime * result + ((getTerminal() == null) ? 0 : getTerminal().hashCode());
        result = prime * result + ((getStatusPublish() == null) ? 0 : getStatusPublish().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getBrowseNum() == null) ? 0 : getBrowseNum().hashCode());
        result = prime * result + ((getCollectNum() == null) ? 0 : getCollectNum().hashCode());
        result = prime * result + ((getShareNum() == null) ? 0 : getShareNum().hashCode());
        result = prime * result + ((getOfficial() == null) ? 0 : getOfficial().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getFolderId() == null) ? 0 : getFolderId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCoverTitle() == null) ? 0 : getCoverTitle().hashCode());
        result = prime * result + ((getCustomCoverUrl() == null) ? 0 : getCustomCoverUrl().hashCode());
        result = prime * result + ((getCoverStylePosition() == null) ? 0 : getCoverStylePosition().hashCode());
        result = prime * result + ((getCustomCoverOriginUrl() == null) ? 0 : getCustomCoverOriginUrl().hashCode());
        result = prime * result + ((getExaminer() == null) ? 0 : getExaminer().hashCode());
        result = prime * result + ((getExamineTime() == null) ? 0 : getExamineTime().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getIfDownload() == null) ? 0 : getIfDownload().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", description=").append(description);
        sb.append(", icon=").append(icon);
        sb.append(", background=").append(background);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", projectSize=").append(projectSize);
        sb.append(", terminal=").append(terminal);
        sb.append(", statusPublish=").append(statusPublish);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", browseNum=").append(browseNum);
        sb.append(", collectNum=").append(collectNum);
        sb.append(", shareNum=").append(shareNum);
        sb.append(", official=").append(official);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", folderId=").append(folderId);
        sb.append(", status=").append(status);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", coverTitle=").append(coverTitle);
        sb.append(", customCoverUrl=").append(customCoverUrl);
        sb.append(", coverStylePosition=").append(coverStylePosition);
        sb.append(", customCoverOriginUrl=").append(customCoverOriginUrl);
        sb.append(", examiner=").append(examiner);
        sb.append(", examineTime=").append(examineTime);
        sb.append(", source=").append(source);
        sb.append(", ifDownload=").append(ifDownload);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}