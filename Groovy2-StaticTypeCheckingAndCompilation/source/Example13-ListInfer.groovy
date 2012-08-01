@groovy.transform.TypeChecked
class Example13 {
    void test() {
        def list = ['a','b','c']
        println list[0].toUpperCase()
    }
}
new Example13().test()