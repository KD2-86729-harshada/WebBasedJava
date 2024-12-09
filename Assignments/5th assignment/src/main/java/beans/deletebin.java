package beans;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import entities.Candidate;

public class deletebin {
    private int id;
    private int result;

    
    public deletebin() {
		
	}
    
    
	public deletebin(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int delete() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			this.result= candDao.deleteById(id);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return result;
	}
    
   
}
