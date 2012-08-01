def foo(Object a) { 'OBJECT' }
def foo(String a) { 'STRING' }
def foo(Date a) { 'DATE' }

def bar(Object o) { foo(o) }

println foo('string')
println bar('string')
