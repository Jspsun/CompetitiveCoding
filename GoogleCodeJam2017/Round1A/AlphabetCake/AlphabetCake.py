def __main__():
    f = open("in.txt", 'r')
    o = open("out.txt", 'w')

    noOfCases = int(f.readline())
    for testNo in range(noOfCases):
        data = f.readline().split()
        r = int(data[0])
        c = int(data[1])
        grid = []
        for row in range(r):
            grid.append(list(f.readline())[:-1])

        output = solver(grid)

        o.write("Case #" + str(testNo + 1) + ":\n")
        for row in range(len(output)):
            o.write(''.join(output[row]) + "\n")


def solver(grid):
    noR = len(grid)
    noC = len(grid[0])

    # fill in letters to the right
    for r in range(noR):
        for c in range(noC):
            if c < noC - 1 and grid[r][c + 1] == '?':
                grid[r][c + 1] = grid[r][c]

    # fill in letters to the left
    for r in range(noR):
        for c in range(noC):
            if grid[r][c] != '?':
                while c >= 1:
                    grid[r][c - 1] = grid[r][c]
                    c -= 1
                break

    for r in range(noR):
        if r + 1 < noR and grid[r + 1][0] == '?':
            grid[r + 1] = grid[r]

    for r in range(noR):
        if grid[r][0] != '?':
            while r >= 1:
                grid[r - 1] = grid[r]
                r -= 1
            break

    return grid

if __name__ == '__main__':
    __main__()
