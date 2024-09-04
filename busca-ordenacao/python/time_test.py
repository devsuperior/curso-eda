import time


def my_function():
    x = 10.0
    for i in range(100000000):
        x = -x


start = time.time()
my_function()
end = time.time()
time_elapsed = (end - start) * 1000
print(f"Duration: {time_elapsed:.3f}ms")
