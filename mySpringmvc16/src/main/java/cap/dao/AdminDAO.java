package cap.dao;

import cap.model.Admin;

import java.util.List;

public interface AdminDAO {
     Admin login(Admin admin);

     List<Admin>fingByPage(int pageNo,int pageSize);
     int getTotalCount();
}
