import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /* Задание 1.1 */
        System.out.println("Задание 1.1");

        Point[] points = new Point[3];

        // Ввод координат точек
        for (int i = 0; i < 3; i++) {
            double x = 0, y = 0;
            while (true) {
                System.out.print("Введите координаты точки " + (i + 1) + " (X Y): ");
                if (in.hasNextDouble()) {
                    x = in.nextDouble();
                    if (in.hasNextDouble()) {
                        y = in.nextDouble();
                        points[i] = new Point(x, y);
                        break;
                    } else {
                        System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                        in.nextLine();
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                    in.nextLine();
                }
            }
        }

        // Вывод информации о точках
        for (int i = 0; i < 3; i++) {
            System.out.println("Точка " + (i + 1) + ": " + points[i].getPointString());
        }
        System.out.println();



        /* Задание 1.3 */
        System.out.println("Задание 1.3");
        System.out.print("Введите количество человек: ");

        int x_13 = 0;

        while (true) {
            if (in.hasNextInt()) {
                x_13 = in.nextInt();
                if (x_13 <= 0) {
                    System.out.println("Количество людей должно быть положительным");
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
                in.next();
            }
        }

        in.nextLine();


        Name[] names = new Name[x_13];
        for (int i = 0; i < x_13; i++) {
            System.out.print("Введите фамилию " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
            String SecName = in.nextLine();
            SecName = SecName.trim();
            if (SecName.isEmpty()) {
                SecName = null;
            }

            System.out.print("Введите имя " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
            String Fername = in.nextLine();
            Fername = Fername.trim();
            if (Fername.isEmpty()) {
                Fername = null;
            }

            System.out.print("Введите отчество " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
            String THName = in.nextLine();
            THName = THName.trim();
            if (THName.isEmpty()) {
                THName = null;
            }
            System.out.println();

            names[i] = new Name(SecName, Fername, THName);

        }

        // Вывод
        for (int i = 0; i < x_13; i++) {
            System.out.println(names[i]);
        }
        System.out.println();


        /* задание 2.1 */
        System.out.println("задание 2.1");

        // Массивы для хранения координат
        Point[] starts = new Point[2];
        Point[] ends = new Point[2];

        // Ввод координат начала и конца линий
        for (int i = 0; i < 2; i++) {
            double x = 0, y = 0;
            while (true) {
                System.out.print("Введите координаты начала " + (i + 1) + " линии (X Y): ");
                if (in.hasNextDouble()) {
                    x = in.nextDouble();
                    if (in.hasNextDouble()) {
                        y = in.nextDouble();
                        starts[i] = new Point(x, y);
                        break;
                    } else {
                        System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                        in.nextLine();
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                    in.nextLine();
                }
            }

            while (true) {
                System.out.print("Введите координаты конца " + (i + 1) + " линии (X Y): ");
                if (in.hasNextDouble()) {
                    x = in.nextDouble();
                    if (in.hasNextDouble()) {
                        y = in.nextDouble();
                        ends[i] = new Point(x, y);
                        break;
                    } else {
                        System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                        in.nextLine();
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                    in.nextLine();
                }
            }
        }

        Line line1 = new Line(starts[0], ends[0]);
        Line line2 = new Line(starts[1], ends[1]);
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        // Вывод информации о линиях
        System.out.println(line1.getLineString());
        System.out.println(line2.getLineString());
        System.out.println(line3.getLineString());


        // Изменение координат первой и второй линий
        for (int i = 0; i < 2; i++) {
            Line line;
            if (i == 0) {
                line = line1;
            } else {
                line = line2;
            }
            while (true) {
                System.out.print("Введите новую координату X начала " + (i + 1) + " линии: ");
                if (in.hasNextDouble()) {
                    line.getStart().setX(in.nextDouble());
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    in.nextLine();
                }
            }
            while (true) {
                System.out.print("Введите новую координату Y начала " + (i + 1) + " линии: ");
                if (in.hasNextDouble()) {
                    line.getStart().setY(in.nextDouble());
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    in.nextLine();
                }
            }
            while (true) {
                System.out.print("Введите новую координату X конца " + (i + 1) + " линии: ");
                if (in.hasNextDouble()) {
                    line.getEnd().setX(in.nextDouble());
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    in.nextLine();
                }
            }
            while (true) {
                System.out.print("Введите новую координату Y конца " + (i + 1) + " линии: ");
                if (in.hasNextDouble()) {
                    line.getEnd().setY(in.nextDouble());
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    in.nextLine();
                }
            }
        }

        // Обновление третьей линии
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());


        // Вывод информации о линиях после изменений
        System.out.println(line1.getLineString());
        System.out.println(line2.getLineString());
        System.out.println(line3.getLineString());


        // Изменение координат первой линии без изменения третьей линии
        double newX1 = 0, newY1 = 0;
        while (true) {
            System.out.print("Введите новые координаты начала первой линии (X Y): ");
            if (in.hasNextDouble()) {
                newX1 = in.nextDouble();
                if (in.hasNextDouble()) {
                    newY1 = in.nextDouble();
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                    in.nextLine();
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                in.nextLine();
            }
        }
        line1.setStart(new Point(newX1, newY1));

        double newX2 = 0, newY2 = 0;
        while (true) {
            System.out.print("Введите новые координаты конца первой линии (X Y): ");
            if (in.hasNextDouble()) {
                newX2 = in.nextDouble();
                if (in.hasNextDouble()) {
                    newY2 = in.nextDouble();
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                    in.nextLine(); // Очистка буфера ввода
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите числа.");
                in.nextLine(); // Очистка буфера ввода
            }
        }
        line1.setEnd(new Point(newX2, newY2));

        // Вывод информации о линиях после изменений
        System.out.println(line1.getLineString());
        System.out.println(line2.getLineString());
        System.out.println(line3.getLineString());
        System.out.println();



        /* Задание 5.5 */
        System.out.println("Задание 5.5 ");
        System.out.println();

        Fraction[] fractions = new Fraction[3];

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Введите числитель и знаменатель для дроби " + (i + 1) + " : ");
                if (in.hasNextInt()) {
                    int chisl = in.nextInt();
                    if (in.hasNextInt()) {
                        int znamen = in.nextInt();
                        if (znamen != 0) {
                            fractions[i] = new Fraction(chisl, znamen);
                            break;
                        } else {
                            System.out.println("Знаменатель не может быть равен 0. Попробуйте еще раз");
                        }
                    } else {
                        System.out.println("Знаменатель должен быть целым числом. Попробуйте еще раз");
                        in.next();
                    }
                } else {
                    System.out.println("Числитель должен быть целым числом");
                    in.next();
                }
            }
        }

        System.out.println("Результат: ");
        Fraction rez;

        // 1. Сумма
        System.out.println("Сумма");
        rez = fractions[0].summ(fractions[1]);
        System.out.println(fractions[0] + " + " + fractions[1] + " = " + rez);
        rez = fractions[0].summ(fractions[2]);
        System.out.println(fractions[0] + " + " + fractions[2] + " = " + rez);
        System.out.println();


        System.out.println("Разность");
        // 2. Вычитание
        rez = fractions[0].vichet(fractions[1]);
        System.out.println(fractions[0] + " - " + fractions[1] + " = " + rez);
        rez = fractions[0].vichet(fractions[2]);
        System.out.println(fractions[0] + " - " + fractions[2] + " = " + rez);
        System.out.println();


        System.out.println("Деление");
        // 3. Деление
        rez = fractions[0].del(fractions[1]);
        System.out.println(fractions[0] + " / " + fractions[1] + " = " + rez);
        rez = fractions[0].del(fractions[2]);
        System.out.println(fractions[0] + " / " + fractions[2] + " = " + rez);
        System.out.println();


        System.out.println("Умножение");
        // 4. Умножение
        rez = fractions[0].umnozhenie(fractions[1]);
        System.out.println(fractions[0] + " * " + fractions[1] + " = " + rez);
        rez = fractions[0].umnozhenie(fractions[2]);
        System.out.println(fractions[0] + " * " + fractions[2] + " = " + rez);
        System.out.println();


        // f1.sum(f2).div(f3).minus(5)

        Fraction f4 = new Fraction(5);
        System.out.println("Посчитать f1.sum(f2).div(f3).minus(5) ");
        rez = fractions[0].summ(fractions[1]);
        System.out.println("1. " + rez);
        rez = rez.del(fractions[2]);
        if (rez == null) {
            System.out.println("Деление на ноль невозможно (в курсах школьной математики)");
        } else {
            System.out.println("2. " + rez);
            rez = rez.vichet(f4);
            System.out.println("Ответ: " + rez);
        }
        in.close();
    }

}
