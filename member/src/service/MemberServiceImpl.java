package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.MemberBean;
import dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{

	private static MemberService service = new MemberServiceImpl();
    private MemberServiceImpl() {}
    public static MemberServiceImpl getInstance(){
        return (MemberServiceImpl) service;
    }
    
    Map<String,Object> map = new HashMap<String,Object>();
    MemberBean bean = new MemberBean();
 
    @Override
    public int join(MemberBean bean) {
        return MemberDaoImpl.getInstance().insert(bean);
    }
  
    @Override
    public List<Object> memberList() {
        MemberDaoImpl dao = MemberDaoImpl.getInstance();
        return dao.list();
    }
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public MemberBean memberDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateMember(MemberBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String login(String id, String password) {
		// TODO Auto-generated method stub
		String msg = "";
		bean = (MemberBean) MemberDaoImpl.getInstance().getElementById(id);
		
		
		
		return msg;
	}
}
