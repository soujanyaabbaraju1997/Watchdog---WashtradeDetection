package com.dao;

import java.util.List;

import com.pojos.Firm;

public interface FirmDAO {
	public int addfirm(Firm firm);
	public List<Firm> findAllFirms();

}
