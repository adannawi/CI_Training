package ci.training.repo;

import java.util.ArrayList;
import java.util.Optional;

import ci.training.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	
	private ArrayList<Customer> custList = new ArrayList<Customer>();

	public boolean save(Customer c) {
		return custList.add(c);
	}

	public Customer find(String phoneNumber) {
		Optional<Customer> op = custList.stream().filter(c -> c.getPhoneNumber().equals(phoneNumber)).findFirst();
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

}
