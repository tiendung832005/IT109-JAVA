package business.service.account;

import business.service.AppService;

public interface AccountService extends AppService {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
}
