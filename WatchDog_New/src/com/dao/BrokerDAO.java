package com.dao;

import java.util.List;
import com.pojos.Broker;

public interface BrokerDAO {
	public int addBroker(Broker broker);
	public List<Broker> findAllBrokers();
}
