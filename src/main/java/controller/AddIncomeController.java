package controller;

import service.AccountService;
import vo.AccountVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public record AddIncomeController() implements Controller {

    @Override
    public void execute(Scanner sc) {
        System.out.println("--- 수입 내역을 입력합니다 ---");
        AccountService service = AccountService.getInstance();

        try {
            System.out.print("금액 : ");
            int amount = Integer.parseInt(sc.nextLine());
            System.out.print("내용 : ");
            String description = sc.nextLine();
            System.out.print("카테고리 : ");
            String category = sc.nextLine();
            System.out.print("날짜 (yyyy-MM-dd, 미입력 시 오늘 날짜) : ");
            String dateStr = sc.nextLine();

            ArrayList<AccountVO> list = service.getAllAccount();
            int id = list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1;
            
            Calendar date;
            if (dateStr.trim().isEmpty()) {
                date = Calendar.getInstance();
            } else {
                date = service.setDate(dateStr);
            }

            AccountVO vo = new AccountVO(id, "수입", amount, description, category, date);
            list.add(vo);

            System.out.println("수입 내역이 추가되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("금액은 숫자로 입력해주세요.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
