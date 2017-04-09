def __main__():
    f = open("in.txt", 'r')
    o = open("out.txt", 'w')

    noOfCases = int(f.readline())
    for testNo in range(noOfCases):
        counter = 0
        data = f.readline().split()
        output = solver()

        o.write("Case #" + str(testNo + 1) + ": " + str(output) + "\n")


def solver():
    return 0

if __name__ == '__main__':
    __main__()
