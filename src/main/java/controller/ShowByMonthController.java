package controller;

import service.AccountService;
import vo.AccountVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ShowByMonthController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("--- 월별 내역을 조회합니다. ---");
        
        int targetMonth = 0;
        while (true) {
            System.out.print("조회하고 싶은 월을 입력하세요(1-12) : ");
            try {
                targetMonth = Integer.parseInt(sc.nextLine());
                if (targetMonth >= 1 && targetMonth <= 12) {
                    break;
                }
                System.out.println("1에서 12 사이의 숫자를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }

        ArrayList<AccountVO> list = AccountService.getInstance().getAllAccount();
        boolean found = false;

        System.out.println("\nID | 구분 | 금액 | 내용 | 카테고리 | 날짜");
        System.out.println("------------------------------------------");

        for (AccountVO vo : list) {
            if (vo.getDate().get(Calendar.MONTH) == (targetMonth - 1)) {
                System.out.println(vo.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println(targetMonth + "월 내역이 없습니다.");
        }
        System.out.println();
    }
}
