@groovy.transform.TypeChecked
class Example10 {
    String test() { new StringBuilder('transparently converted to String') }
    void m() {
        println "${test()}"
    }
}
new Example10().test()