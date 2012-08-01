@groovy.transform.TypeChecked
class Example9 {
    boolean test() { true }
    void m() {
        int x = 1 + test()
    }
}
new Example9()