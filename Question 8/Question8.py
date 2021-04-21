# Name: Minh Nguyen
# PantherID: 002-46-4288

def func1 ():
    a = 1
    b = 1
    c = 1
    print("Inside func1:")
    print("a = " + str(a))
    print("b = " + str(b))
    print("c = " + str(c))

    def func2 ():
        b = 2
        print("Inside func2:")
        print("a = " + str(a))
        print("b = " + str(b))
        print("c = " + str(c))

        def func3 ():
            c = 3
            print("Inside func3:")
            print("a = " + str(a))
            print("b = " + str(b))
            print("c = " + str(c))
            # End func3()

        func3() # Call func3() inside func2()

        # End func2()

    func2() # Call func2() inside func1()

# End func1()

func1() # Main calling func1()