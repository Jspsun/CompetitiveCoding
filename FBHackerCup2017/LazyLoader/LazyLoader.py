f = open("lazy_loading.txt", 'r')
o = open('out.txt', 'w')
noOfDays = int(f.readline())
for testNo in range(0, noOfDays):
    noOfItems = int(f.readline())
    items = []
    for itemNo in range(0, noOfItems):
        items.append(int(f.readline()))
    items.sort()

    # iterate through each end
    counter = 0

    # while top items can have wieght of 50
    while len(items) > 0 and items[-1] * len(items) > 50:
        topWeight = items[-1]
        noOfItems = 50 / topWeight
        items = items[noOfItems:-1]
        counter += 1
    o.write("Case #" + str(testNo + 1) + ": " + str(counter) + "\n")
