import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
@Epic("Calculator Test Epic")
@Feature("Calculating Some Valid Values")
public class CalcTest extends TestCfg {

    /* Для добавления кодировки UTF-8 что бы не валились тесты,
    иначе знаки деление и умножение отображаются кракозяблями. :(
    Run -> Edit configuration -> CalcTest -> Modify options -> Add VM option -> VM option -> -Dfile.encoding=UTF-8 */
    @Owner("Mazay - Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Division of some values")
    @Description("Calculate the division of some values")
    @DisplayName("Division calculation")
    @Test
    public void divideTest() {
        calc.nine().zero().divide().three().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "90÷3";
        expectedExprRes = "= 30";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }

    @Owner("Mazay - Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Multiplication of some values")
    @Description("Calculate the multiplication of some values")
    @DisplayName("Multiply calculation")
    @Test
    public void multiplyTest() {
        calc.clear().clear().one().eight().multiply().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "18×9";
        expectedExprRes = "= 162";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }

    @Owner("Mazay - Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Summing of some values")
    @Description("Calculate the summing of some values")
    @DisplayName("Summing calculation")
    @Test
    public void sumTest() {
        calc.clear().clear().one().eight().nine().plus().two().seven().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "189+279";
        expectedExprRes = "= 468";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }

    @Owner("Mazay -  Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Difference between two values")
    @Description("Calculate the difference between two values")
    @DisplayName("Subtraction calculation")
    @Test
    public void subTest() {
        calc.clear().clear().three().nine().six().sub().six().three().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "396-639";
        expectedExprRes = "= -243";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }
    @Owner("Mazay - Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Division of some values with mistakes")
    @Description("Calculate the division of some values")
    @DisplayName("Specially adding wrong data before division calculation")
    @Test
    public void divideFailureTest() {
        calc.nine().nine().divide().three().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "90÷3";
        expectedExprRes = "= 30";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }

    @Owner("Mazay - Aston_AQA_Academy_Student")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Multiplication of some values with mistakes")
    @Description("Calculate the multiplication of some values")
    @DisplayName("Specially adding wrong data before multiply calculation")
    @Test
    public void multiplyFailureTest() {
        calc.clear().clear().eight().multiply().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "18×9";
        expectedExprRes = "= 162";
        Assertions.assertEquals(expectedExpr, actualExpr);
        Assertions.assertEquals(expectedExpr, actualExpr);
    }

}
