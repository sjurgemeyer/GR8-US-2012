class ClosureSharedVariable1 {
    void test() {
        def var = 'String'
        def cl = { var = new Date() }
        cl()
        var = var.toUpperCase()
    }
}