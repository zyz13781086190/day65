package com.qf.service.impl;

import com.qf.dao.TransferDao;
import com.qf.dao.UserDao;
import com.qf.entity.Transfer;
import com.qf.entity.User;
import com.qf.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDao transferDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void transfer(String sourceCode, String descCode, Double money) {

        User sourceUser = userDao.findByCode(sourceCode);
        User descUser = userDao.findByCode(descCode);

        if (sourceCode.equals(descCode)) {
            throw new RuntimeException("转账卡号与目标卡号不能相同");
        }

        if (descUser == null) {
            System.out.println("==========");
            throw new RuntimeException("转账卡号输入有误");
        }

        if (sourceUser.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }

        Transfer sTransfer = new Transfer();
        sTransfer.setUid(sourceUser.getUid());
        sTransfer.setMoney(0 - money);
        sTransfer.setBalance(sourceUser.getBalance() - money);
        transferDao.add(sTransfer);

        Transfer dTransfer = new Transfer();
        dTransfer.setUid(descUser.getUid());
        dTransfer.setMoney(money);
        dTransfer.setBalance(descUser.getBalance() + money);
        transferDao.add(dTransfer);

    }
}
