package cap.service.impl;

import cap.dao.AdminDAO;
import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDAO adminDAO;

    @Override
    public Admin login(Admin admin) {
        return adminDAO.login(admin);
    }

    @Override
    public PageBean findByPage(int pageNo, int pageSize) {
        PageBean pageBean=new PageBean();
        List<Admin>adminList=adminDAO.fingByPage(pageNo,pageSize);
        int totalCount=adminDAO.getTotalCount();
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);
        pageBean.setList(adminList);
        pageBean.setTotalRecords(totalCount);
        return pageBean;
    }

    @Override
    public void deleteById(Integer id) {
       // String sql="delete from admin where id=?";
       adminDAO.deleteById(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }


}
