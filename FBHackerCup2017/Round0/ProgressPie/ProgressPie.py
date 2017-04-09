import numpy as np


def getAngleOfCircle(percentage):
    return np.around(2 * np.pi * percentage / 100.0, 5)


def pointWithinRadius(x, y):
    if (x**2 + y**2) <= 50 * 50:
        return True
    return False


def getPointAngle(x, y):
    ang1 = np.arctan2(1, 0)
    ang2 = np.arctan2(y, x)
    angle = np.around((ang1 - ang2) % (2 * np.pi), 5)
    return angle


def withinAngleOfCircle(circleAngle, pointAngle):
    if pointAngle <= circleAngle:
        return True
    return False


def check(p, x, y):
    if p == 0:
        return "white"
    if withinAngleOfCircle(getAngleOfCircle(p), getPointAngle(x, y)) and pointWithinRadius(x, y):
        return "black"
    return "white"


def __main__():
    f = open("progress_pie.txt", 'r')
    o = open('out.txt', 'w')
    noOfTests = int(f.readline())
    for i in range(0, noOfTests):
        input = f.readline().split()
        output = check(int(input[0]), int(input[1]) - 50, int(input[2]) - 50)
        o.write("Case #" + str(i + 1) + ": " + output + "\n")
    o.close()
    f.close()


if __name__ == '__main__':
    __main__()
