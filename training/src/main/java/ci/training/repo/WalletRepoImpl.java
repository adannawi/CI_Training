package ci.training.repo;

import java.util.ArrayList;

import ci.training.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	
	private ArrayList<Customer> custList = new ArrayList<Customer>();

	public boolean save(Customer c) {
		return custList.add(c);
	}

	public Customer find(String phoneNumber) {
		return null;
	}

}
