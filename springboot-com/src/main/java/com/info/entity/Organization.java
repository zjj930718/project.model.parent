package com.info.entity;

import javax.persistence.*;

public class Organization {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织编码
     */
    private String orgcoding;

    /**
     * 组织名称
     */
    @Column(name = "orgName")
    private String orgname;

    /**
     * 组织后缀
     */
    @Column(name = "devCoding")
    private String devcoding;

    /**
     * 组织全称
     */
    @Column(name = "organizeAllName")
    private String organizeallname;

    /**
     * 组织机构代码
     */
    @Column(name = "unitCode")
    private String unitcode;

    /**
     * 是否接入 0 表示未接入，1表示接入
     */
    private String jion;

    /**
     * 父节点
     */
    @Column(name = "parent_orgcoding")
    private String parentOrgcoding;

    /**
     * 分类
     */
    @Column(name = "tag_type")
    private String tagType;

    /**
     * 分类名
     */
    @Column(name = "tag_name")
    private String tagName;

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取组织编码
     *
     * @return orgcoding - 组织编码
     */
    public String getOrgcoding() {
        return orgcoding;
    }

    /**
     * 设置组织编码
     *
     * @param orgcoding 组织编码
     */
    public void setOrgcoding(String orgcoding) {
        this.orgcoding = orgcoding;
    }

    /**
     * 获取组织名称
     *
     * @return orgName - 组织名称
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 设置组织名称
     *
     * @param orgname 组织名称
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * 获取组织后缀
     *
     * @return devCoding - 组织后缀
     */
    public String getDevcoding() {
        return devcoding;
    }

    /**
     * 设置组织后缀
     *
     * @param devcoding 组织后缀
     */
    public void setDevcoding(String devcoding) {
        this.devcoding = devcoding;
    }

    /**
     * 获取组织全称
     *
     * @return organizeAllName - 组织全称
     */
    public String getOrganizeallname() {
        return organizeallname;
    }

    /**
     * 设置组织全称
     *
     * @param organizeallname 组织全称
     */
    public void setOrganizeallname(String organizeallname) {
        this.organizeallname = organizeallname;
    }

    /**
     * 获取组织机构代码
     *
     * @return unitCode - 组织机构代码
     */
    public String getUnitcode() {
        return unitcode;
    }

    /**
     * 设置组织机构代码
     *
     * @param unitcode 组织机构代码
     */
    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    /**
     * 获取是否接入 0 表示未接入，1表示接入
     *
     * @return jion - 是否接入 0 表示未接入，1表示接入
     */
    public String getJion() {
        return jion;
    }

    /**
     * 设置是否接入 0 表示未接入，1表示接入
     *
     * @param jion 是否接入 0 表示未接入，1表示接入
     */
    public void setJion(String jion) {
        this.jion = jion;
    }

    /**
     * 获取父节点
     *
     * @return parent_orgcoding - 父节点
     */
    public String getParentOrgcoding() {
        return parentOrgcoding;
    }

    /**
     * 设置父节点
     *
     * @param parentOrgcoding 父节点
     */
    public void setParentOrgcoding(String parentOrgcoding) {
        this.parentOrgcoding = parentOrgcoding;
    }

    /**
     * 获取分类
     *
     * @return tag_type - 分类
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * 设置分类
     *
     * @param tagType 分类
     */
    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    /**
     * 获取分类名
     *
     * @return tag_name - 分类名
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置分类名
     *
     * @param tagName 分类名
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}