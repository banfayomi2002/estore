/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
public class ReportEJBDTO implements Serializable {
 private int id;
 private int employeeid;
 private ArrayList<ReportItemEJBDTO> items;
 private BigDecimal total;
 private String datecreated;
 public int getEmployeeid() {
 return employeeid;
 }
 public int getId() {
 return id;
 }
 public ArrayList<ReportItemEJBDTO> getItems() {
 return items;
 }
 public BigDecimal getTotal() {
 return total;
 }
 public String getDatecreated() {
 return datecreated;
 }

 public void setEmployeeid(int value) {
 employeeid = value;
 }
 public void setId(int value) {
 id = value;
 }
 public void setTotal(BigDecimal value) {
 total = value;
 }
 public void setItems(ArrayList<ReportItemEJBDTO> value) {
 items = value;
 }
 public void setDatecreated(String value) {
 datecreated = value;
 }
}

