@groovy.transform.TypeChecked
class Example11 {
    int test(String val) {
        val.toInteger()
    }
}
assert new Example11().test('123') == 123
