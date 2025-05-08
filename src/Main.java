import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Задание 1.1");
		Point[] points = new Point[3];

		for (int i = 0; i < 3; i++) {
			double x, y;
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
		for (int i = 0; i < 3; i++) {
			System.out.println("Точка " + (i + 1) + ": " + points[i].getPointString());
		}
		System.out.println();

		System.out.println("Задание 1.3");
		System.out.print("Введите количество человек: ");
		int personCount = 0;

		while (personCount <= 0) {
			if (in.hasNextInt()) {
				personCount = in.nextInt();
				if (personCount <= 0) {
					System.out.println("Количество людей должно быть положительным");
				}
			} else {
				System.out.println("Некорректный ввод. Попробуйте еще раз");
				in.next();
			}
		}
		in.nextLine();

		Name[] names = new Name[personCount];
		for (int i = 0; i < personCount; i++) {
			System.out.print("Введите фамилию " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
			String secondName = in.nextLine().trim();
			if (secondName.isEmpty()) secondName = null;

			System.out.print("Введите имя " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
			String firstName = in.nextLine().trim();
			if (firstName.isEmpty()) firstName = null;

			System.out.print("Введите отчество " + (i + 1) + "(чтобы пропустить нажмите Enter): ");
			String lastName = in.nextLine().trim();
			if (lastName.isEmpty()) lastName = null;
			names[i] = new Name(secondName, firstName, lastName);
		}
		for (Name name : names) {
			System.out.println(name);
		}

		System.out.println("Задание 2.1");
		Line[] lines = new Line[3];

		for (int i = 0; i < 2; i++) {
			Point start = null, end = null;

			while (start == null) {
				System.out.print("Введите координаты начала " + (i + 1) + " линии (X Y): ");
				if (in.hasNextDouble()) {
					double x = in.nextDouble();
					if (in.hasNextDouble()) start = new Point(x, in.nextDouble());
					else in.nextLine();
				} else in.nextLine();
			}

			while (end == null) {
				System.out.print("Введите координаты конца " + (i + 1) + " линии (X Y): ");
				if (in.hasNextDouble()) {
					double x = in.nextDouble();
					if (in.hasNextDouble()) end = new Point(x, in.nextDouble());
					else in.nextLine();
				} else in.nextLine();
			}

			lines[i] = new Line(start, end);
		}

		lines[2] = new Line(lines[0].getStart(), lines[1].getEnd());
		for (int i = 0; i < 3; i++)
			System.out.println("Линия " + (i + 1) + ": " + lines[i].getLineString());

		for (int i = 0; i < 2; i++) {
			System.out.println("Изменение линии " + (i + 1));
			Line l = lines[i];
			while(true) {
				System.out.print("Введите новые X Y начала через пробел: ");
				if(in.hasNextDouble()) {
					double x = in.nextDouble();
					if(in.hasNextDouble()) {
						l.getStart().setX(x);
						l.getStart().setY(in.nextDouble());
						in.nextLine();
						break;
					}
				}
				System.out.println("Ошибка ввода! Нужно два числа через пробел");
				in.nextLine();
			}

			while(true) {
				System.out.print("Введите новые X Y конца через пробел: ");
				if(in.hasNextDouble()) {
					double x = in.nextDouble();
					if(in.hasNextDouble()) {
						l.getEnd().setX(x);
						l.getEnd().setY(in.nextDouble());
						in.nextLine();
						break;
					}
				}
				System.out.println("Ошибка ввода! Нужно два числа через пробел");
				in.nextLine();
			}
		}

		System.out.println("Полное изменение первой линии:");
		Point newStart = null, newEnd = null;
		while(newStart == null) {
			System.out.print("Введите X и Y начала через пробел: ");
			if(in.hasNextDouble()) {
				double x = in.nextDouble();
				if(in.hasNextDouble()) {
					newStart = new Point(x, in.nextDouble());
					in.nextLine();
				} else {
					System.out.println("Некорректный ввод Y! Повторите ввод.");
					in.nextLine();
				}
			} else {
				System.out.println("Некорректный ввод! Введите два числа.");
				in.nextLine();
			}
		}
		while(newEnd == null) {
			System.out.print("Введите X и Y конца через пробел: ");
			if(in.hasNextDouble()) {
				double x = in.nextDouble();
				if(in.hasNextDouble()) {
					newEnd = new Point(x, in.nextDouble());
					in.nextLine();
				} else {
					System.out.println("Некорректный ввод Y! Повторите ввод.");
					in.nextLine();
				}
			} else {
				System.out.println("Некорректный ввод! Введите два числа.");
				in.nextLine();
			}
		}
		lines[0].setStart(newStart);
		lines[0].setEnd(newEnd);

		for (int i = 0; i < 3; i++) {
			System.out.println("Линия " + (i + 1) + ": " + lines[i].getLineString());
		}

		System.out.println("Задание 3.3");
		City a = new City("A");
		City b = new City("B");
		City c = new City("C");
		City d = new City("D");
		City e = new City("E");
		City f = new City("F");

		a.addRoute(b, 5);
		a.addRoute(d, 6);
		a.addRoute(f, 1);

		b.addRoute(a, 5);
		b.addRoute(c, 3);

		c.addRoute(b, 3);
		c.addRoute(d, 4);

		d.addRoute(a, 6);
		d.addRoute(c, 4);
		d.addRoute(e, 2);

		e.addRoute(f, 2);

		f.addRoute(b, 1);
		f.addRoute(e, 2);

		System.out.println(a.getDescription());
		System.out.println("\n" + b.getDescription());
		System.out.println("\n" + c.getDescription());
		System.out.println("\n" + d.getDescription());
		System.out.println("\n" + e.getDescription());
		System.out.println("\n" + f.getDescription());

		System.out.println("Задание 4.8");
		NewCity newCityA = new NewCity("A");

		Map<NewCity, Integer> bRoutes = new LinkedHashMap<>();
		NewCity newCityB = new NewCity("B");
		NewCity newCityC = new NewCity("C");
		bRoutes.put(newCityA, 5);
		bRoutes.put(newCityC, 3);
		NewCity newCityD = new NewCity("D", bRoutes);

		newCityA.addRoute(newCityB, 5);
		newCityA.addRoute(newCityD, 2);
		newCityC.addRoute(newCityA, 4);
		newCityD.addRoute(newCityC, 1);

		System.out.println(newCityA.getDescription());
		System.out.println("\n" + newCityB.getDescription());
		System.out.println("\n" + newCityC.getDescription());
		System.out.println("\n" + newCityD.getDescription());

		System.out.println("Задание 5.5 ");
		System.out.println();
		Fraction[] fractions = new Fraction[3];

		for (int i = 0; i < 3; i++) {
			while (true) {
				System.out.print("Введите числитель и знаменатель для дроби " + (i + 1) + " : ");
				if (in.hasNextInt()) {
					int numerator = in.nextInt();
					if (in.hasNextInt()) {
						int denominator = in.nextInt();
						if (denominator != 0) {
							fractions[i] = new Fraction(numerator, denominator);
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
		Fraction result;

		System.out.println("Сумма");
		result = fractions[0].add(fractions[1]);
		System.out.println(fractions[0] + " + " + fractions[1] + " = " + result);
		result = fractions[0].add(fractions[2]);
		System.out.println(fractions[0] + " + " + fractions[2] + " = " + result);
		System.out.println();

		System.out.println("Разность");
		result = fractions[0].subtract(fractions[1]);
		System.out.println(fractions[0] + " - " + fractions[1] + " = " + result);
		result = fractions[0].subtract(fractions[2]);
		System.out.println(fractions[0] + " - " + fractions[2] + " = " + result);
		System.out.println();

		System.out.println("Деление");
		result = fractions[0].divide(fractions[1]);
		System.out.println(fractions[0] + " / " + fractions[1] + " = " + result);
		result = fractions[0].divide(fractions[2]);
		System.out.println(fractions[0] + " / " + fractions[2] + " = " + result);
		System.out.println();

		System.out.println("Умножение");
		result = fractions[0].multiply(fractions[1]);
		System.out.println(fractions[0] + " * " + fractions[1] + " = " + result);
		result = fractions[0].multiply(fractions[2]);
		System.out.println(fractions[0] + " * " + fractions[2] + " = " + result);
		System.out.println();

		// f1.add(f2).divide(f3).subtract(5)
		Fraction f4 = new Fraction(5);
		System.out.println("Посчитать f1.sum(f2).div(f3).minus(5) ");
		result = fractions[0].add(fractions[1]);
		System.out.println("1. " + result);
		result = result.divide(fractions[2]);
		if (result == null) {
			System.out.println("Деление на ноль невозможно (в курсах школьной математики)");
		} else {
			System.out.println("2. " + result);
			result = result.subtract(f4);
			System.out.println("Ответ: " + result);
		}
		in.close();
	}
}
