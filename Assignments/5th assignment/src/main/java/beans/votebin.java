package beans;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import entities.User;

public class votebin {

	private int candid;
	private int userid;
	private boolean result;
	

	public votebin() {
	
	}
	public int getCandid() {
		return candid;
	}
	public void setCandid(int candid) {
		this.candid = candid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
public void vote() {
	this.result=false;
	try(CandidateDao candDao=new CandidateDaoImpl()){
		int count = candDao.incrVote(this.candid);
		
		if(count==1) {
			try(UserDao userDao=new UserDaoImpl()){
				User user=userDao.findById(userid);
				if(user != null) {
					user.setStatus(1);
					
					count=userDao.update(user);
					
					if(count==1) {
						this.result=true;
					}
					
				}
			}
		}
	} catch (Exception e) {
	
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}
	
}
