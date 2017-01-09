from __future__ import print_function

handle = input()
tipL = input()
space = input()

# spikes
for i in range(0, tipL):
    for j in range(0, space * 2 + 3):
        if j == 0 or j == (space * 2 + 3) / 2 or j == space * 2 + 2:
            print ("*", end='')
        else:
            print (" ", end='')
    print("")
# bottom
for i in range(0, space * 2 + 3):
    print("*", end="")
print("")

# handle
for i in range(0, handle):
    for j in range(0, space * 2 + 3):
        if j == (space * 2 + 3) / 2:
            print ("*", end='')
        else:
            print (" ", end='')
    print("")
