@groovy.transform.TypeChecked
class Example12 {
    void test(Object val) {
        if (val instanceof String) {
            println val.toUpperCase()
        } else if (val instanceof Number) {
            println ('X'*val.intValue())
        }
    }
}
new Example12()