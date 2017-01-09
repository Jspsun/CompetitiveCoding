'''
Created on Jan 6, 2017

@author: TigerZhao
'''


f1 = open("outAlex.txt", "r")
f2 = open("testout.txt", "r")

count = 0
for i in xrange(0, 1000001):
    if f1.readline().strip() != f2.readline().strip():
        print i
        count += 1
print count
f1.close()
f2.close()
