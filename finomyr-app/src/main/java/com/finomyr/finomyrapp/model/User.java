package com.finomyr.finomyrapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

/**
 * The persistent class for the users database table.
 * 
 * @version 0.2
 * @since 0.6.5
 * @author amalvar
 */
@Entity
@Table(name = "users", schema = "finomyrs")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

    private static final long serialVersionUID = 863256903406460207L;

    /* private static final String seq = "\"users_userId_seq\""; */

    /*
     * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
     * "users_userId_seq")
     * 
     * @SequenceGenerator(name = "users_userId_seq", schema = "finomyrs",
     * sequenceName = "\"users_userId_seq\"", allocationSize = 1)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"userId\"", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    private String password;

    @Column(name = "\"firstName\"")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "\"lastName\"")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "\"userRole\"", schema = "finomyrs",
        joinColumns = @JoinColumn(name = "\"userId\""),
        inverseJoinColumns = @JoinColumn(name = "\"roleId\""),
        foreignKey = @ForeignKey(name = "\"fk_userRole_users\""),
        inverseForeignKey = @ForeignKey(name = "\"fk_userRole_roles\""),
        uniqueConstraints = {
                @UniqueConstraint(name = "\"userRole_pkey\"",
                    columnNames = {"\"userId\"", "\"roleId\""})})
    private Set<Role> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=").append(userId).append(", email=")
                .append(email).append(", password=").append(password)
                .append(", firstName=").append(firstName).append(", lastName=")
                .append(lastName).append(", active=").append(active)
                .append(", roles=").append(roles).append("]");
        return builder.toString();
    }

}
