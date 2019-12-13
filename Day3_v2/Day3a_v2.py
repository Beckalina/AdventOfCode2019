# Two wires are connected to a central port and extend outward on a grid. Trace the path each wire takes as it
# leaves the central port. The wires twist and turn, but the two wires occasionally cross paths. To fix the circuit,
# find the intersection point closest to the central port, using the Manhattan distance.


def left(current, num, wire_path):
    # x-axis decreases
    new = current[0] - num
    # add all grid points passed to wire_path
    for i in range(new, current[0]):
        wire_path.add((i, current[1]))
    return new

def right(current, num, wire_path):
    # x-axis increases
    new = current[0] + num
    for i in range(current[0]+1, new+1):
        wire_path.add((i, current[1]))
    return new

def up(current, num, wire_path):
    # y-axis decreases
    new = current[1] - num
    for i in range(new, current[1]):
        wire_path.add((current[0], i))
    return new

def down(current, num, wire_path):
    # y-axis increases
    new = current[1] + num
    for i in range(current[1]+1, new+1):
        wire_path.add((current[0], i))
    return new


def follow_wire(wire):
    current = [0, 0]
    wire_path = set()
    for x in wire:
        print(current)
        print(x)
        if x[0] == "L":
            current[0] = left(current, int(x[1:]), wire_path)
        elif x[0] == "R":
            current[0] = right(current, int(x[1:]), wire_path)
        elif x[0] == "U":
            current[1] = up(current, int(x[1:]), wire_path)
        elif x[0] == "D":
            current[1] = down(current, int(x[1:]), wire_path)
        else:
            print("not found")
    return wire_path

def find_crossed(path1, path2):
    crossed = []
    for x in path1:
        if x in path2:
            crossed.append(x)
    return crossed

def find_closest(crossed):
    manhattan_distance = []
    for x in crossed:
        distance = abs(x[0]) + abs(x[1])
        manhattan_distance.append(distance)
    closest = min(manhattan_distance)
    return closest

def main():
    with open("Day3_input.txt", 'r') as f:
        wires = []
        for line in f:
            wires.append(line)
    wire_a = wires[0].split(",")
    wire_b = wires[1].split(",")

    a_path = follow_wire(wire_a)
    print("a_path = " + str(a_path))

    b_path = follow_wire(wire_b)
    print("b_path = " + str(b_path))

    crossed = find_crossed(a_path, b_path)
    print("Crossed = " + str(crossed))

    answer = find_closest(crossed)
    print("Closest crossed wire = " + str(answer))


if __name__ == "__main__":
    main()