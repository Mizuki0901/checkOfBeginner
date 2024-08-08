package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println("1番目の整数を入力してください:");
      int number1 = scanner.nextInt();

      System.out.println("演算子を入力してください(+,-,*,/):");
      String operator = scanner.next();

      System.out.println("2番目の整数を入力してください:");
      int number2 = scanner.nextInt();

      // 除法があるため合計は小数点以下まで表示
      double total = 0;
      boolean validOperation = true;

      switch (operator) {
        case "+":
          total = number1 + number2;
          break;
        case "-":
          total = number1 - number2;
          break;
        case "*":
          total = number1 * number2;
          break;
        case "/":
          if (number2 != 0) {
            total = (double) number1 / number2;
          } else {
            System.out.println("0で割ることはできません");
            validOperation = false;
          }
          break;
        default:
          System.out.println("無効な演算子です");
          validOperation = false;
          break;
      }

      if (validOperation) {
        System.out.println(number1 + " " + operator + " " + number2 + " = " + total);
      }
    } catch (InputMismatchException e) {
      System.out.println("初めからやりなおしてください。");
    }
  }
}