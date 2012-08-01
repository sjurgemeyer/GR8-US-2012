HashMap map = [:]
map['a'] = 1
map.b = 2
//map.b = b
assert map.get('a') == 1
assert map.get('b') == 2
