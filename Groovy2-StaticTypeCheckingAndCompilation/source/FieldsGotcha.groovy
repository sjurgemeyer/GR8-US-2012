class Something {
    def foo = 'foo' // assignment is compatible, yet we will still use the declaration type
    
    void doSomething() {
        println foo.toUpperCase() // won't pass STC
    }
}
new Something().doSomething()