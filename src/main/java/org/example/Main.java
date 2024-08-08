package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学年の情報を表示");
      System.out.println("6. 終了");
      System.out.print("選択してください: ");

      int choice = scanner.nextInt();
      //クリア
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.println("学生の名前を入力してください:");
          String newName = scanner.nextLine();
          System.out.println(newName + "の点数を入力してください");
          int newScore = scanner.nextInt();
          Student newStudent;
          newStudent = new Student(newName, newScore);
          studentList.add(newStudent);
          break;

        case 2:
          System.out.println("削除する学生の名前を入力してください:");
          String deleteName = scanner.nextLine();
          studentList.removeIf(student -> student.name.equals(deleteName));
          System.out.println(deleteName + "のデータを削除しました");
          break;

        case 3:
          System.out.println("点数の更新をする学生の名前を入力してください:");
          String updateScoreOfName = scanner.nextLine();
          for (Student student : studentList) {
            if (student.name.equals(updateScoreOfName)) {
              System.out.println("新しい点数を入力してください");
              int updateScore = scanner.nextInt();
              student = new Student(updateScoreOfName, updateScore);
              System.out.println(
                  "点数が更新されました [" + student.getName() + ":" + student.getScore() + "点]");
            } else {
              System.out.println("該当する学生はいません");
            }
          }
          break;

        case 4:
          double total = 0.0;
          for (Student student : studentList) {
            total += student.score;
          }
          double average = total / studentList.size();
          System.out.println("平均点:" + average + "点");
          break;

        case 5:
          System.out.println("学生一覧:");
          for (Student student : studentList) {
            System.out.println(student.name + ": " + student.score + "点");
          }
          break;

        case 6:
          System.out.println("プログラムを修了します。");
          scanner.close();
          return;

        default:
          System.out.println("無効な選択です。");
          break;
      }
    }
  }
}