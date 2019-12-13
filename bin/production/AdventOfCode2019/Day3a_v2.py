



def left(current, num, wire_path):
    new = current[0] - num
    for i in range(new, current[0]):
        wire_path.append((i, current[1]))
    return new

def right(current, num, wire_path):
    new = current[0] + num
    for i in range(current[0]+1, new+1):
        wire_path.append((i, current[1]))
    return new

def up(current, num, wire_path):
    new = current[1] - num
    for i in range(new, current[1]):
        wire_path.append((current[0], i))
    return new

def down(current, num, wire_path):
    new = current[1] + num
    for i in range(current[1]+1, new+1):
        wire_path.append((current[0], i))
    return new


def follow_wire(wire):
    current = [0, 0]
    wire_path = []
    for x in wire:
        print(x)
        print(current)
        if x[0] == "L":
            current[0] = left(current, int(x[1]), wire_path)
        elif x[0] == "R":
            current[0] = right(current, int(x[1]), wire_path)
        elif x[0] == "U":
            current[1] = up(current, int(x[1]), wire_path)
        elif x[0] == "D":
            current[1] = down(current, int(x[1]), wire_path)
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

if __name__ == "__main__":
    wire_a = ("R75,D30,R83,U83,L12,D49,R71,U7,L72").split(",")
    wire_b = ("U62,R66,U55,R34,D71,R55,D58,R83").split(",")

    a_path = follow_wire(wire_a)
    print("a_path = " + str(a_path))
    b_path = follow_wire(wire_b)
    print("b_path = " + str(b_path))

    crossed = find_crossed(a_path, b_path)
    print("Crossed = " + str(crossed))
    answer = find_closest(crossed)
    print("Closest crossed wire = " + str(answer))

