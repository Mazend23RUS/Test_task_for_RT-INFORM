package grovy

class GroovyClass {

    static List<Integer> getCountOfNumberGroovy(List<?> firstInput, int[] secondInput) {
        List<Integer> workList = null

        if (firstInput == null && secondInput == null) {
            println("На вход должен подаваться хотя бы один список или массив!")
            throw new RuntimeException()
        } else if (secondInput == null) {
            workList = firstInput as List<Integer>
        } else if (firstInput == null) {
            workList = secondInput.toList()
        } else {
            println("На вход должен подаваться только один список или массив!")
            return
        }

        def inputData = workList.countBy { it }

        def result = inputData.collect { key, value -> "$key:$value" }

        return result as List<Integer>;
    }

}