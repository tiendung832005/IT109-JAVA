package business.service.account;

import business.dao.account.AccountDao;
import business.dao.account.AccountDaoImp;

public class AccountServiceImp implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImp() {
        accountDao = new AccountDaoImp();
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        return accountDao.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
    }
}