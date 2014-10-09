package edu.javacourse.spring.spel;

import edu.javacourse.spring.bean.User;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionExample {

    // Простая строка
    public void simpleString() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    // Конкатенация строк
    public void concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello '.concat('World')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    // Верхний регистр
    public void upperCase() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
    }

    // Простая математика
    public void math1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("10 + 10/2 + 10*2");
        Double value = exp.getValue(Double.class);
        System.out.println(value);
    }

    // Обратиться к классу Math
    public void math2() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(java.lang.Math).random() * 100.0");
        Double value = exp.getValue(Double.class);
        System.out.println(value);
    }

    // Обратиться к полю обхекта
    public void field() {
        User jobs = new User("Steve1", "Jobs", 56);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("firstName");
        String name = exp1.getValue(jobs, String.class);
        System.out.println(name);

        Expression exp2 = parser.parseExpression("firstName=='Steve'");
        System.out.println(exp2.getValue(jobs, Boolean.class));
    }
}
