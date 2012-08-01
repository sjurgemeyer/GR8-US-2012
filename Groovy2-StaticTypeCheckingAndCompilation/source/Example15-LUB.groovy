@groovy.transform.TypeChecked
class Example15 {
    void test() {
        List<? extends Comparable> list = ['a', 123]
    }
}
new Example15().test()