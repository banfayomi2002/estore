/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Austin
 */
@Entity
@Table(name = "EXPENSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpensesModel_1.findAll", query = "SELECT e FROM ExpensesModel_1 e"),
    @NamedQuery(name = "ExpensesModel_1.findById", query = "SELECT e FROM ExpensesModel_1 e WHERE e.id = :id"),
    @NamedQuery(name = "ExpensesModel_1.findByCategoryid", query = "SELECT e FROM ExpensesModel_1 e WHERE e.categoryid = :categoryid"),
    @NamedQuery(name = "ExpensesModel_1.findByDescription", query = "SELECT e FROM ExpensesModel_1 e WHERE e.description = :description"),
    @NamedQuery(name = "ExpensesModel_1.findByReceipt", query = "SELECT e FROM ExpensesModel_1 e WHERE e.receipt = :receipt"),
    @NamedQuery(name = "ExpensesModel_1.findByDateincurred", query = "SELECT e FROM ExpensesModel_1 e WHERE e.dateincurred = :dateincurred"),
    @NamedQuery(name = "ExpensesModel_1.findByAmount", query = "SELECT e FROM ExpensesModel_1 e WHERE e.amount = :amount")})
public class ExpensesModel_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CATEGORYID")
    private String categoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEIPT")
    private Boolean receipt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEINCURRED")
    @Temporal(TemporalType.DATE)
    private Date dateincurred;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Lob
    @Column(name = "RECEIPTSCAN")
    private Serializable receiptscan;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EmployeesModel_1 employeeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expenseid")
    private Collection<ExpensereportsitemsModel> expensereportsitemsModelCollection;

    public ExpensesModel_1() {
    }

    public ExpensesModel_1(Integer id) {
        this.id = id;
    }

    public ExpensesModel_1(Integer id, String categoryid, String description, Boolean receipt, Date dateincurred, BigDecimal amount) {
        this.id = id;
        this.categoryid = categoryid;
        this.description = description;
        this.receipt = receipt;
        this.dateincurred = dateincurred;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public Date getDateincurred() {
        return dateincurred;
    }

    public void setDateincurred(Date dateincurred) {
        this.dateincurred = dateincurred;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Serializable getReceiptscan() {
        return receiptscan;
    }

    public void setReceiptscan(Serializable receiptscan) {
        this.receiptscan = receiptscan;
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
        if (!(object instanceof ExpensesModel_1)) {
            return false;
        }
        ExpensesModel_1 other = (ExpensesModel_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ExpensesModel_1[ id=" + id + " ]";
    }
    
}
