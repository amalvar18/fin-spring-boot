package com.finomyr.finomyrapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

/**
 * The persistent class for the users investmentType table.
 * 
 * @version 0.1
 * @since 0.7.2
 * @author amalvar
 */
@Entity
@Table(name = "\"investmentType\"", schema = "finomyrs")
@NamedQuery(name = "InvestmentType.findAll", query = "SELECT i FROM InvestmentType i")
public class InvestmentType {

    @Id
    @Column(name = "\"investmentTypeId\"", unique = true, nullable = false)
    @SequenceGenerator(name = "investmentType_investmentTypeId_seq", schema = "finomyrs",
        sequenceName = "\"investmentType_investmentTypeId_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "investmentType_investmentTypeId_seq")
    private Integer investmentTypeId;

    @Column(name = "active")
    @ColumnDefault("true")
    private boolean active;

    @Column(name = "\"parentId\"")
    private int parentId;

    @Column(name = "\"rootId\"")
    private int rootId;

    @Column(name = "\"displayName\"")
    private String displayName;

    @Column(name = "comments")
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"taxationId\"",
        foreignKey = @ForeignKey(name = "\"fk_taxation_taxationId\""))
    private Taxation taxation;

    public Integer getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(Integer investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Taxation getTaxation() {
        return taxation;
    }

    public void setTaxation(Taxation taxation) {
        this.taxation = taxation;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InvestmentType [investmentTypeId=").append(investmentTypeId)
                .append(", active=").append(active).append(", parentId=").append(parentId)
                .append(", rootId=").append(rootId).append(", displayName=").append(displayName)
                .append(", comments=").append(comments).append("]");
        return builder.toString();
    }

}
