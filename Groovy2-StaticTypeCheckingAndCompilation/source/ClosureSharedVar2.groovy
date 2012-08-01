class A { void foo() {} }
class B extends A { void bar() {} }

class ClosureSharedVariable2 {
   void test() {
        def var = new A()
        def cl = { var = new B() }
        cl()
        var.foo()
    }
}
new ClosureSharedVariable2().test()