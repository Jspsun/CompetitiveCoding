def __main__():
    f = open("progress_pie.txt", 'r')
    o = open('out.txt', 'w')
    noOfCases = int(f.readline())

    for case in range(noOfCases):
        data = f.readline().split()
        days = int(data[0])
        noPiesPerDay = int(data[1])
        piesDay = {}
        for day in range(days):
            piesForTheDay = map(int, f.readline.split())
            piesForTheDay.sort()
            # calculate prices for each pie
            piesDay.append()


if __name__ == '__main__':
    __main__()
