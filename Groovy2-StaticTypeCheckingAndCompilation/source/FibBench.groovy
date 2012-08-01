@Grab('com.googlecode.gbench:gbench:0.3.1-groovy-2.0')
import gbench.*

int fib(int n) {
    n<2?1:fib(n-2)+fib(n-1)
}

@groovy.transform.CompileStatic
int fib2(int n) {
    n<2?1:fib2(n-2)+fib2(n-1)
}

new BenchmarkBuilder().run {
    'Fib dynamic' { fib(40) }
    'Fib static' { fib2(40) }
}.prettyPrint()