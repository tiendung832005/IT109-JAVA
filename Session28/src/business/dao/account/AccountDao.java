package business.dao.account;

import business.dao.AppDao;

public interface AccountDao extends AppDao {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
}
