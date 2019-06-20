/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Austin
 */
@Entity
@Table(name = "EXPENSEREPORTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpensereportsModel_1.findAll", query = "SELECT e FROM ExpensereportsModel_1 e"),
    @NamedQuery(name = "ExpensereportsModel_1.findById", query = "SELECT e FROM ExpensereportsModel_1 e WHERE e.id = :id"),
    @NamedQuery(name = "ExpensereportsModel_1.findByDategenerated", query = "SELECT e FROM ExpensereportsModel_1 e WHERE e.dategenerated = :dategenerated")})
public class ExpensereportsModel_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEGENERATED")
    @Temporal(TemporalType.DATE)
    private Date dategenerated;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EmployeesModel_1 employeeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportid")
    private Collection<ExpensereportsitemsModel> expensereportsitemsModelCollection;

    public ExpensereportsModel_1() {
    }

    public ExpensereportsModel_1(Integer id) {
        this.id = id;
    }

    public ExpensereportsModel_1(Integer id, Date dategenerated) {
        this.id = id;
        this.dategenerated = dategenerated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDategenerated() {
        return dategenerated;
    }

    public void setDategenerated(Date dategenerated) {
        this.dategenerated = dategenerated;
    }

    public EmployeesModel_1 getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(EmployeesModel_1 employeeid) {
        this.employeeid = employeeid;
    }

    @XmlTransient
    public Collection<ExpensereportsitemsModel> getExpensereportsitemsModelCollection() {
        return expensereportsitemsModelCollection;
    }

    public void setExpensereportsitemsModelCollection(Collection<ExpensereportsitemsModel> expensereportsitemsModelCollection) {
        this.expensereportsitemsModelCollection = expensereportsitemsModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpensereportsModel_1)) {
            return false;
        }
        ExpensereportsModel_1 other = (ExpensereportsModel_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ExpensereportsModel_1[ id=" + id + " ]";
    }
    
}
