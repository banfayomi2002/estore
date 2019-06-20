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
import models.ExpensereportsitemsModel;

/**
 *
 * @author Austin
 */
@Entity
@Table(name = "EXPENSEREPORTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpensereportsModel.findByEmployee", query = "SELECT e FROM ExpensereportsModel e WHERE e.employeeid = :employeeid"),
    @NamedQuery(name = "ExpensereportsModel.findAll", query = "SELECT e FROM ExpensereportsModel e"),
    @NamedQuery(name = "ExpensereportsModel.findById", query = "SELECT e FROM ExpensereportsModel e WHERE e.id = :id"),
    @NamedQuery(name = "ExpensereportsModel.findByDategenerated", query = "SELECT e FROM ExpensereportsModel e WHERE e.dategenerated = :dategenerated")})
public class ExpensereportsModel implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportid")
    private Collection<ExpensereportsitemsModel> expensereportsitemsModelCollection;

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
    private EmployeesModel employeeid;
    
    public ExpensereportsModel() {
    }

    public ExpensereportsModel(Integer id) {
        this.id = id;
    }

    public ExpensereportsModel(Integer id, Date dategenerated) {
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

    public EmployeesModel getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(EmployeesModel employeeid) {
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
        if (!(object instanceof ExpensereportsModel)) {
            return false;
        }
        ExpensereportsModel other = (ExpensereportsModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ExpensereportsModel[ id=" + id + " ]";
    }

   
    
}
