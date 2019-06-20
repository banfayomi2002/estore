package ejbs;
import javax.persistence.EntityManager;
import models.EmployeesModel;
import dtos.EmployeeEJBDTO;
import dtos.ExpenseEJBDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.ExpensesModel;
/**
* @author Evan
*/
public class UtilityMethods {

 public EmployeesModel loadModelFromDTO(EmployeeEJBDTO dto, EmployeesModel mod, EntityManager
em) {
 mod.setTitle(dto.getTitle());
 mod.setFirstname(dto.getFirstname());
 mod.setLastname(dto.getLastname());
 mod.setPhoneno(dto.getPhoneno());
 mod.setEmail(dto.getEmail());
 return mod;
 }
 public EmployeeEJBDTO loadDTOFromModel(EmployeeEJBDTO dto, EmployeesModel mod, EntityManager
em) {
 dto.setTitle(mod.getTitle());
 dto.setFirstname(mod.getFirstname());
 dto.setLastname(mod.getLastname());
 dto.setPhoneno(mod.getPhoneno());
 dto.setEmail(mod.getEmail());
 dto.setId(mod.getId());
 return dto;
 }
 public ExpensesModel loadModelFromDTO(ExpenseEJBDTO dto, ExpensesModel mod, EntityManager em)
{
 mod.setCategoryid(dto.getCategoryid());
 EmployeesModel empmod = em.find(EmployeesModel.class, dto.getEmployeeid());
 mod.setEmployeeid(empmod);
 mod.setDescription(dto.getDescription());
 mod.setReceipt(dto.getReceipt());
 mod.setDateincurred(formatDate(dto.getDateincurred()));
 mod.setAmount(dto.getAmount());
 mod.setReceiptscan(dto.getReceiptscan());
 return mod;
 }
 public ExpenseEJBDTO loadDTOFromModel(ExpenseEJBDTO dto, ExpensesModel mod, EntityManager em)
{
 dto.setId(mod.getId());
 dto.setEmployeeid(mod.getEmployeeid().getId());
 dto.setCategoryid(mod.getCategoryid());
 dto.setDescription(mod.getDescription());
 dto.setReceipt(mod.getReceipt());
 dto.setReceiptscan((byte[]) mod.getReceiptscan());
 dto.setDateincurred(formatDate(mod.getDateincurred()));
 dto.setAmount(mod.getAmount());
 dto.setId(mod.getId());
 return dto;
 }
 
 

 public String formatDate(Date date) {
 String formattedDate = "";
 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 try {
 formattedDate = df.format(date);
 } catch (Exception e) {
 }
 return formattedDate;
 }
 public Date formatDate(String date) {
 Date formattedDate = null;
 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 try {
 formattedDate = df.parse(date);
 } catch (Exception e) {
 }
 return formattedDate;
 }

}