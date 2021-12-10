import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {

    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTC("Josefina"), true),
                            new Pair<>( new ProfesorTC("Edonisio"), true),
                            new Pair<>( new ProfesorTC("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTC("Eduarda"), false),
                            new Pair<>( new ProfesorTC("Abelardo"), false),
                            new Pair<>( new ProfesorTC("Francisca"), false)
                    )
            )
    );

    public void nombreDeProfesoresQueAgreganPuntos(){
        System.out.println("Profesores de acuerdo a subir nota: ");
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
            for (Pair<Teacher, Boolean> teacher : teachers) {
                if (teacher.second() == true){
                    System.out.println(teacher.first());
                }
            }
        }
    }
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty() && hasReachedMinimumClasses) {
            return extracted(isHasToIncreaseOneExtraPoint(), getGradesSum(examsStudents), getGradesWeightSum(examsStudents));
        } else {
            return 0f;
        }
    }

    private boolean isHasToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second()) {
                        return true;
                    }
                }
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    private float extracted(boolean hasToIncreaseOneExtraPoint, float gradesSum, int gradesWeightSum) {
        if (gradesWeightSum == 100) {
            if (hasToIncreaseOneExtraPoint) {
                return Float.min(10f, gradesSum + 1);
            }
            return gradesSum;
        } else if (gradesWeightSum > 100) {
            return -1f;
        }
        return -2f;
    }

    private int getGradesWeightSum(List<Pair<Integer, Float>> examsStudents) {
        int gradesWeightSum = 0;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesWeightSum += examGrade.first();
        }
        return gradesWeightSum;
    }

    private float getGradesSum(List<Pair<Integer, Float>> examsStudents) {
        float gradesSum       = 0f;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
        }
        return gradesSum;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
