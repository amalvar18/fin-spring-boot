package com.finomyr.finomyrapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The persistent class for the taxation database table.
 * 
 * @version 0.2
 * @since 0.7.1
 * @author amalvar
 */
@Entity
@Table(name = "taxation", schema = "finomyrs")
public class Taxation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6103873188679130663L;

    /* @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
     "taxation_taxationId_seq")
     @SequenceGenerator(name = "taxation_taxationId_seq", schema = "finomyrs",
     sequenceName = "\"taxation_taxationId_seq\"", allocationSize = 1)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"taxationId\"", unique = true, nullable = false)
    private Integer taxationId;

    @Column(name = "category")
    @NotBlank(message = "Please provide a category name")
    private String category;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "\"assetClass\"")
    @NotBlank(message = "Please provide an asset class")
    private String assetClass;

    @Column(name = "\"taxRate\"")
    private BigDecimal taxRate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "\"indexationAllowed\"")
    @ColumnDefault("false")
    private boolean indexationAllowed;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @Column(name = "\"createdBy\"")
    private String createdBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "\"lastUpdated\"")
    private Date lastUpdated;

    @Column(name = "\"lastUpdatedBy\"")
    private String lastUpdatedBy;

    public Integer getTaxationId() {
        return taxationId;
    }

    public void setTaxationId(Integer taxationId) {
        this.taxationId = taxationId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isIndexationAllowed() {
        return indexationAllowed;
    }

    public void setIndexationAllowed(boolean indexationAllowed) {
        this.indexationAllowed = indexationAllowed;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Taxation [taxationId=").append(taxationId)
                .append(", category=").append(category).append(", name=")
                .append(name).append(", assetClass=").append(assetClass)
                .append(", taxRate=").append(taxRate).append(", active=")
                .append(active).append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", lastUpdated=").append(lastUpdated)
                .append(", lastUpdatedBy=").append(lastUpdatedBy).append("]");
        return builder.toString();
    }

}
