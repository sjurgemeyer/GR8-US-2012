@groovy.transform.TypeChecked
class Example1 {
    void foo() {}
    void bar() {}
    
    void method() {
        foo()
        baz()
    }
}
new Example1()