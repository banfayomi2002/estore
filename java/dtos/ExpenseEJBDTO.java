package dtos;
/**
* ExpenseEJBDTO - Container class that serializes expense information traveling
* to and From ExpenseModel/ExpenseResource classes
*/
import java.io.Serializable;
import java.math.BigDecimal;
public class ExpenseEJBDTO implements Serializable {
 public ExpenseEJBDTO() {
 }
 private int id;
 private int employeeid;
 private String categoryid;
 private String description;
 private boolean receipt;
 private byte[] receiptscan;
 private BigDecimal amount;
 private String dateincurred;
 public int getId() {
 return this.id;
 }
 public void setId(int inValue) {
 this.id = inValue;
 }
 public int getEmployeeid() {
 return this.employeeid;
 }
 public void setEmployeeid(int inValue) {
 this.employeeid = inValue;
 }
 public String getDescription() {
 return this.description;
 }
 public void setDescription(String inValue) {
 this.description = inValue;
 }
 public String getCategoryid() {
 return this.categoryid;
 }

 public void setCategoryid(String inValue) {
 this.categoryid = inValue;
 }
 public boolean getReceipt() {
 return this.receipt;
 }
 public void setReceipt(boolean inValue) {
 this.receipt = inValue;
 }
 public byte[] getReceiptscan() {
 return this.receiptscan;
 }
 public void setReceiptscan(byte[] inValue) {
 this.receiptscan = inValue;
 }
 public BigDecimal getAmount() {
 return this.amount;
 }
 public void setAmount(BigDecimal inValue) {
 this.amount = inValue;
 }

 public String getDateincurred() {
 return this.dateincurred;
 }
 public void setDateincurred(String inValue) {
 this.dateincurred = inValue;
 }
}
