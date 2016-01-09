package carrent;

import domain.Emp;

import java.util.List;

public interface EmpDAO {

    Emp addEmp(Emp emp);
    void deleteEmp(Emp emp);
    Emp updateEmp(Emp emp);
    List<Emp> getAllEmp();
    Emp getEmpByID(Long id);

}