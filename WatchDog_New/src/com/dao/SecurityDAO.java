package com.dao;

import java.util.List;

import com.pojos.Firm;
import com.pojos.Security;

public interface SecurityDAO {
	public int addSecurity(Security security);
	public List<Security> findAllSecurity();
//

}
