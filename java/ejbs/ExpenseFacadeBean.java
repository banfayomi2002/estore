package ejbs;
import dtos.ExpenseEJBDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.ExpensesModel;
/**
* @author Evan
*/
@Stateless
public class ExpenseFacadeBean extends AbstractFacade<ExpensesModel> {
 @PersistenceContext
 private EntityManager em;
 @Override
 protected EntityManager getEntityManager() {
 return em;
 }

 private final UtilityMethods util;

 public ExpenseFacadeBean() {
 super(ExpensesModel.class);
 util = new UtilityMethods();
 }
 /**
 * @param id int represent expense PK
 * @return int representing the number of rows deleted.
 */
 public int delete(int id) {
 int rowsDeleted = -1;
 try {
 remove(find(id));
 rowsDeleted = 1;
 } catch (Exception e) {
 System.out.println("problem deleting " + e.getMessage());
 }
 return rowsDeleted;
 }
 /**
 * @param dto expense DTO of all new information
 * @return int representing the PK of the new expense row.
 */
 public int add(ExpenseEJBDTO dto) {
 ExpensesModel mod = util.loadModelFromDTO(dto, new ExpensesModel(),em);
 create(mod);
 em.flush();
 return mod.getId();
 }
 /**
 * @param dto expense DTO of all updated information
 * @return int representing the number of rows updated.
 */
 public int update(ExpenseEJBDTO dto) {
 int empUpdated = -1;
 try {
 edit(util.loadModelFromDTO(dto, find(dto.getId()),em));
 em.flush();
 empUpdated = 1;
 } catch (Exception e) {
 System.out.println("Error " + e.getMessage());
 }
 return empUpdated;
 }
/**
 * @return List of DTOs representing all expenses
 */
 public List<ExpenseEJBDTO> getAll() {
 List<ExpenseEJBDTO> expensesDTO = new ArrayList();
 try {
 for (ExpensesModel e : findAll()) {
 expensesDTO.add(util.loadDTOFromModel(new ExpenseEJBDTO(), e, em));
 }
 } catch (Exception e) {
 //Handle other errors
 System.out.println("other issue " + e.getMessage());
 }
 return expensesDTO;
 }

 
 /**
 * @param id int representing PK of expense table
 * @return DTO representing a single expense
 */
 public ExpenseEJBDTO getOne(int id) {
 return util.loadDTOFromModel(new ExpenseEJBDTO(), find(id), em);
 }
}
