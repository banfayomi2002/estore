/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ReportEJBDTO;
import dtos.ReportItemEJBDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.EmployeesModel;
import models.ExpensereportsitemsModel;
import models.ExpensereportsModel;
import models.ExpensesModel;

/**
 *
 * @author Austin
 */

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@Stateless
@LocalBean

public class ExpenseReportFacadeBean extends AbstractFacade<ExpensereportsModel> {
    @Resource
 private EJBContext context;

    @EJB
 private ExpenseReportFacadeBean efb;
 private final UtilityMethods util;
 @PersistenceContext
 private EntityManager em;
 @Override
 protected EntityManager getEntityManager() {
 return em;
 }
 public ExpenseReportFacadeBean() {
 super(ExpensereportsModel.class);
 util = new UtilityMethods();
 }
 /**
 * @param id - int representing employee id
 * @return List of DTOs representing all employees
 */
 public List<ReportEJBDTO> getAllForEmployee(int id) {
 ArrayList<ReportEJBDTO> allreportinfo = new ArrayList<>();
 try {
 EmployeesModel emod = em.find(EmployeesModel.class, id);
 Query qry = em.createNamedQuery("ExpensereportsModel.findByEmployee");
 qry.setParameter("employeeid", emod);
 List<ExpensereportsModel> reports = qry.getResultList();
 // report loop
 for (ExpensereportsModel report : reports) {
 ReportEJBDTO repDTO = new ReportEJBDTO();
repDTO.setEmployeeid(id);
 repDTO.setDatecreated(util.formatDate(report.getDategenerated()));
 repDTO.setId(report.getId());
 ArrayList<ReportItemEJBDTO> items = new ArrayList<>();
 // report item loop
for (ExpensereportsitemsModel item :
report.getExpensereportsitemsModelCollection()) {
 ReportItemEJBDTO lineinfo = new ReportItemEJBDTO();
 ExpensesModel exmod = em.find(ExpensesModel.class, item.getExpenseid().getId());
 lineinfo.setExpenseid(exmod.getId());
lineinfo.setReportid(report.getId());
lineinfo.setId(item.getId());
items.add(lineinfo);
 }
 repDTO.setItems(items);
 allreportinfo.add(repDTO);
 }
 } catch (Exception e) {
 //Handle other errors
 System.out.println("other issue " + e.getMessage());
 }
 return allreportinfo;
 }
 /**
 * @param id representing the report we're interested in
 * @return all details for single report
 */
 public ReportEJBDTO get(int id) {
 ArrayList<ReportItemEJBDTO> items;
 ExpensereportsModel repmod;
 ReportEJBDTO dto = new ReportEJBDTO();
 try {
 repmod = find(id);
 dto.setDatecreated(util.formatDate(repmod.getDategenerated()));
 dto.setId(repmod.getId());
 double tmpTotal = 0.0D;
 dto.setEmployeeid(repmod.getEmployeeid().getId());
 items = new ArrayList<>();
 // line item loop
 for (ExpensereportsitemsModel line : repmod.getExpensereportsitemsModelCollection()) {
 ReportItemEJBDTO lineinfo = new ReportItemEJBDTO();
 lineinfo.setReportid(id);
lineinfo.setExpenseid(line.getExpenseid().getId());
 items.add(lineinfo);
 }
 dto.setItems(items);
 dto.setTotal(BigDecimal.valueOf(tmpTotal));
 } catch (Exception e) {
     System.out.println("Error getting line info from ExpenseReportFacade - ");
 }
 return dto;
 }
 
 @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
 public int add(ReportEJBDTO dto) {
 ExpensereportsModel rep;
 EmployeesModel emod;
 int reportId = -1;
 try {
 emod = em.find(EmployeesModel.class, dto.getEmployeeid());
 rep = new ExpensereportsModel();
 rep.setDategenerated(new Date());
 rep.setEmployeeid(emod);
 create(rep);
 em.flush();
 reportId = rep.getId();
 Collection<ExpensereportsitemsModel> tmpLines = new ArrayList<>();

 for (ReportItemEJBDTO item : dto.getItems()) {
 ExpensereportsitemsModel replm = new ExpensereportsitemsModel();
ExpensesModel ex = em.find(ExpensesModel.class, item.getExpenseid());
 replm.setReportid(rep);
replm.setExpenseid(ex);
 tmpLines.add(replm);
 }
 // add to entity
 rep.setExpensereportsitemsModelCollection(tmpLines);
 create(rep);
  } catch (Exception e) {
 context.setRollbackOnly();
 System.out.println(e.getMessage());
 }
 return reportId;
 }
}
 