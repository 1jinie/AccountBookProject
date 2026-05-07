package main;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- 가계부 프로그램을 실행합니다 -----");
        System.out.println("1. 수입 입력");
        System.out.println("2. 지출 입력");
        System.out.println("3. 전체 내역 조회");
        System.out.println("4. 월별 내역 조회");
        System.out.println("5. 잔액 확인");
        System.out.println("0. 종료");
        System.out.println();
        System.out.print("실행할 번호를 입력하세요 : ");
        while (true) {
            int no = sc.nextInt();

            if (no == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
