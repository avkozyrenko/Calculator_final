import java.util.Scanner;

public class Calculator {
        public static void main(String[] args) throws Exception {
            System.out.println("Добро пожаловать в арабско-римский калькулятор!");
            System.out.println("Калькулятор умеет работать с арабскими и римскими числами от 1 до 10.");
            System.out.println("Введите арифметическую операцию типа 1 + 1 или I + I (с пробелом), где вместо + могут быть -, *, /: ");
            Scanner console = new Scanner(System.in);
            String result = Main.calc(console.nextLine());
            System.out.println(result);
        }

        class Main {
            public static String calc(String input) throws Exception {

                String[] splitResult = input.split(" ");
                if (splitResult.length == 1) {
                    throw new Exception("throws Exception //т.к. строка не является математической операцией");
                }
                if (splitResult.length != 3) {
                    throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }

                String num1 = splitResult[0];
                String operation = splitResult[1];
                String num2 = splitResult[2];
                String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                String[] romanCovert = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                        "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI",
                        "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                        "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                        "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

                int x = 0;
                int y = 0;
                int a = 0;
                int b = 0;
                for (int i = 0; i < roman.length; i++) {
                    if (num1.equals(roman[i])) {
                        x = i + 1;
                    }
                }
                for (int i = 0; i < roman.length; i++) {
                    if (num2.equals(roman[i])) {
                        y = i + 1;
                    }
                }
                for (String s : arabic) {
                    if (num1.equals(s)) {
                        a = Integer.parseInt(num1);
                    }
                }
                for (String s : arabic) {
                    if (num2.equals(s)) {
                        b = Integer.parseInt(num2);
                    }
                }

                int result;
                String resultRoman = null;
                String resultArab = null;
                if ((x != 0 && b != 0) || a != 0 && y != 0) {
                    throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
                }
                if ((x == 0 && y == 0 && a == 0 && b != 0) || (x == 0 && y == 0 && a != 0 && b == 0) || (x == 0 && y != 0 &&
                        a == 0 && b == 0) || (x != 0 && y == 0 && a == 0 && b == 0) || (x == 0 && y == 0 && a == 0 && b == 0)) {
                    throw new Exception("throws Exception //т.к. введенные значения не удовлетворяют условию");
                }

                if (x != 0 && y != 0 && x > y) {
                    switch (operation) {
                        case "+" -> result = x + y;
                        case "-" -> result = x - y;
                        case "*" -> result = x * y;
                        case "/" -> result = x / y;
                        default -> throw new Exception("Неправильно введен символ операции, используйте только +, -, *, /");
                    }
                    int i = result;
                    resultRoman = (romanCovert[i - 1]);


                } else if (x != 0 && y != 0 && x <= y) {
                    switch (operation) {
                        case "+" -> result = x + y;
                        case "-" -> throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                        case "*" -> result = x * y;
                        case "/" -> result = x / y;
                        default -> throw new Exception("Неправильно введен символ операции, используйте только +, -, *, /");
                    }
                    int i = result;
                    if (i < 1) {
                        throw new Exception("throws Exception //т.к. в римской системе минимальное значение равно I");
                    } else {
                        resultRoman = romanCovert[i - 1];
                    }
                }
                if (a != 0 && b != 0) {
                    switch (operation) {
                        case "+" -> result = a + b;
                        case "-" -> result = a - b;
                        case "*" -> result = a * b;
                        case "/" -> result = a / b;
                        default -> throw new Exception("Неправильно введен символ операции, используйте только +, -, *, /");
                    }
                    resultArab = Integer.toString(result);

                }
                if (resultArab != null) {
                    return resultArab;
                } else
                    return resultRoman;
            }
        }
    }

