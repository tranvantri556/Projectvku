package Final_Project;

import java.util.ArrayList;

public class AccountManager {
	ArrayList<Account> accounList = new ArrayList<>();
    public boolean isIdExist(long numberAccount) {
        for (Account st : accounList) {
            if (st.getNumberAccount() == numberAccount) {
            	return true;
            }
        }
        return false;
    }
    public void addAccount(Account account) {
    	if(!isIdExist(account.getNumberAccount())) {
    		this.accounList.add(account);
    		System.out.println("Account added successfully.");
    	}else {
    		System.out.println("This ID already exits!");
    	}
    }
    public void updateAccount(long numberAccount, Account update) {
    	for(Account account : accounList) {
    		if(account.getNumberAccount() == numberAccount) {
    			account.setNumberAccount(update.getNumberAccount());
    			account.setPassword(update.getPassword());
    			account.setMoney(update.getMoney());
    			System.out.println("Account information updated successfully.");
    			return;
    		}
    	}
    	System.out.println("No account found with this ID.");
    }
    public void deleteAccount(long numberAccount) {
    	boolean found = false;
    	for(Account status : accounList) {
    		if(status.getNumberAccount() == numberAccount){
    			accounList.remove(status);
    			System.out.println("Account deleted successfully.");
    			found = true;
    			break;
    		}
    	}
    	if(!found) {
    		System.out.println("No account found with this ID.");
    	}
    }

    public ArrayList<Account> getAccountList() {
        return accounList;
    }
}
