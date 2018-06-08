/**
 * 
 */
package com.finomyr.finomyrapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the role database table.
 * 
 * @version 0.1
 * @since 0.7.1
 * @author amalvar
 */
@Entity
@Table(name = "roles", schema = "finomyrs",
    uniqueConstraints = @UniqueConstraint(columnNames = "\"roleId\"", name = "pk_roles_roleId"))
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

    private static final long serialVersionUID = 8177308261972495382L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"roleId\"", unique = true, nullable = false)
    private Integer roleId;

    @Column(name = "role")
    private String role;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [roleId=").append(roleId).append(", role=")
                .append(role).append("]");
        return builder.toString();
    }
}