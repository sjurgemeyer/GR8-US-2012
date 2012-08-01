@groovy.transform.TypeChecked
class Example5 {
    void method() {
        Date[] arr = new Date[2]
        arr[0] = new Date()
        arr[1] = 'Hello'
    }
}
new Example5()