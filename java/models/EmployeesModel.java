/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Austin
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeesModel.findAll", query = "SELECT e FROM EmployeesModel e"),
    @NamedQuery(name = "EmployeesModel.findById", query = "SELECT e FROM EmployeesModel e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeesModel.findByTitle", query = "SELECT e FROM EmployeesModel e WHERE e.title = :title"),
    @NamedQuery(name = "EmployeesModel.findByFirstname", query = "SELECT e FROM EmployeesModel e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "EmployeesModel.findByLastname", query = "SELECT e FROM EmployeesModel e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "EmployeesModel.findByPhoneno", query = "SELECT e FROM EmployeesModel e WHERE e.phoneno = :phoneno"),
    @NamedQuery(name = "EmployeesModel.findByEmail", query = "SELECT e FROM EmployeesModel e WHERE e.email = :email")})
public class EmployeesModel implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<ExpensereportsModel> expensereportsModelCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<ExpensesModel> expensesModelCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 4)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 25)
    @Column(name = "PHONENO")
    private String phoneno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    public EmployeesModel() {
    }

    public EmployeesModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof EmployeesModel)) {
            return false;
        }
        EmployeesModel other = (EmployeesModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EmployeesModel[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ExpensesModel> getExpensesModelCollection() {
        return expensesModelCollection;
    }

    public void setExpensesModelCollection(Collection<ExpensesModel> expensesModelCollection) {
        this.expensesModelCollection = expensesModelCollection;
    }

    @XmlTransient
    public Collection<ExpensereportsModel> getExpensereportsModelCollection() {
        return expensereportsModelCollection;
    }

    public void setExpensereportsModelCollection(Collection<ExpensereportsModel> expensereportsModelCollection) {
        this.expensereportsModelCollection = expensereportsModelCollection;
    }
    
}
