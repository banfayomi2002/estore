/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
public class ReportItemEJBDTO implements Serializable {
 private int id;
 private int reportid;
 private int expenseid;
 public int getId() {
 return id;
 }
 public void setId(int value) {
 id = value;
 }
 public int getExpenseid() {
 return expenseid;
 }
 public void setExpenseid(int value) {
 expenseid = value;
 }

 public int getReportid() {
 return reportid;
 }

 public void setReportid(int value) {
 reportid = value;
 }
}
