package controller;

import service.AccountService;
import vo.AccountVO;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowBalanceController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("--- 잔액을 조회합니다 ---");
        ArrayList<AccountVO> list = AccountService.getInstance().getAllAccount();
        
        int balance = 0;
        for (AccountVO vo : list) {
            if (vo.getType().equals("수입")) {
                balance += vo.getAmount();
            } else if (vo.getType().equals("지출")) {
                balance -= vo.getAmount();
            }
        }
        
        System.out.printf("현재 잔액은 %,d원입니다.", balance);
        System.out.println();
    }
}
