package ejbs;
import dtos.EmployeeEJBDTO;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.EmployeesModel;
import java.util.ArrayList;
import java.util.List;
/**
* @author Evan
*/
@Stateless
@LocalBean
public class EmployeeFacadeBean extends AbstractFacade<EmployeesModel> {
 @PersistenceContext
 private EntityManager em;
 @Override
 protected EntityManager getEntityManager() {
 return em;
 }
 private final UtilityMethods util;
 public EmployeeFacadeBean() {
 super(EmployeesModel.class);
 util = new UtilityMethods();
 }
 /**
 * @param dto employee DTO of all new information
 * @return int representing the PK of the new employee row.
 */
 public int add(EmployeeEJBDTO dto) {
 EmployeesModel mod = util.loadModelFromDTO(dto, new EmployeesModel(), em);
 create(mod);
 em.flush();
 return mod.getId();
 }
 
 /**
 * @param id int represent employee PK
 * @return int representing the number of rows deleted.
 */
 public int delete(int id) {
 int rowsDeleted = -1;
 try {
 remove(find(id));
 em.flush();
 rowsDeleted = 1;
 } catch (Exception e) {
 System.out.println("problem deleting " + e.getMessage());
 }
 return rowsDeleted;
 }
 /**
 * @param dto employee DTO of all updated information
 * @return int representing the number of rows updated.
 */
 public int update(EmployeeEJBDTO dto) {
 int empUpdated = -1;
 try {
 edit(util.loadModelFromDTO(dto, find(dto.getId()), em));
 em.flush();
 empUpdated = 1;
 } catch (Exception e) {
     System.out.println("Error " + e.getMessage());
 }
 return empUpdated;
 }
 /**
 * @return List of DTOs representing all employees
 */
 public List<EmployeeEJBDTO> getAll() {
 List<EmployeeEJBDTO> employeesDTO = new ArrayList();
 try {
 for (EmployeesModel entity : findAll()){
 employeesDTO.add(util.loadDTOFromModel(new EmployeeEJBDTO(), entity, em));
 }
 } catch (Exception e) {
 //Handle other errors
 System.out.println("other issue " + e.getMessage());
 }
 return employeesDTO;
 }

 /**
 * @param id int representing PK of expense table
 * @return DTO representing a single expense
 */
 public EmployeeEJBDTO getOne(int id) {
 return util.loadDTOFromModel(new EmployeeEJBDTO(), find(id), em);
 }
 
}