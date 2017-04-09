'''
Created on Jan 6, 2017

@author: TigerZhao
'''


f1 = open("out.txt", "r")
f2 = open("lazyloading.out", "r")

count = 0
for i in xrange(0, 1005):
    if f1.readline().strip() != f2.readline().strip():
        print i
        count += 1
print "total", count
f1.close()
f2.close()
