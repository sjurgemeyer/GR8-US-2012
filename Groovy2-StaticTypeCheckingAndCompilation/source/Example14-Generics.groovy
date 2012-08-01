@groovy.transform.TypeChecked
class Example14 {
    void test() {
        List<String> list = ['a','b','c']
        println list[0].toUpperCase()
        List<Number> list2 = ['a','b','c']
    }
}
new Example14().test()