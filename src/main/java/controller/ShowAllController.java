package controller;

import service.AccountService;
import vo.AccountVO;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowAllController implements Controller {

    @Override
    public void execute(Scanner sc) {
        System.out.println("--- 전체 내역을 조회합니다 ---");
        ArrayList<AccountVO> list = AccountService.getInstance().getAllAccount();

        if(list.isEmpty()){
            System.out.println("기록 내역이 없습니다.");
            return;
        }

        System.out.println("ID | 구분 | 금액 | 내용 | 카테고리 | 날짜");
        System.out.println("------------------------------------------");

        for(AccountVO vo : list){
            System.out.println(vo.toString());
        }

        System.out.println();
    }
}
