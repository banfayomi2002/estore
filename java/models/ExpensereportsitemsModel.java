/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Austin
 */
@Entity
@Table(name = "EXPENSEREPORTITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpensereportsitemsModel.findAll", query = "SELECT e FROM ExpensereportsitemsModel e"),
    @NamedQuery(name = "ExpensereportsitemsModel.findById", query = "SELECT e FROM ExpensereportsitemsModel e WHERE e.id = :id")})
public class ExpensereportsitemsModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "REPORTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ExpensereportsModel reportid;
    @JoinColumn(name = "EXPENSEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ExpensesModel expenseid;

    public ExpensereportsitemsModel() {
    }

    public ExpensereportsitemsModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExpensereportsModel getReportid() {
        return reportid;
    }

    public void setReportid(ExpensereportsModel reportid) {
        this.reportid = reportid;
    }

    public ExpensesModel getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(ExpensesModel expenseid) {
        this.expenseid = expenseid;
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
        if (!(object instanceof ExpensereportsitemsModel)) {
            return false;
        }
        ExpensereportsitemsModel other = (ExpensereportsitemsModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ExpensereportsitemsModel[ id=" + id + " ]";
    }
    
}
