cookies = {}

cookies["user"] = "maria34"
cookies["email"] = "ana@gmail.com"
cookies["email"] = "maria@gmail.com"
cookies["last-login"] = "2024-07-04T21:42:40.353283800Z"

print("Values:")
for value in cookies.values():
    print(value)

print("\nKeys & values:")
for key, value in cookies.items():
    print(f"{key}: {value}")

print("\nIs empty:", len(cookies) == 0)
print("Size:", len(cookies))

print("\nContains 'email':", "email" in cookies)
removed = cookies.pop("email", None)
print("Remove:", removed)

print("\nContains 'email':", "email" in cookies)
removed = cookies.pop("email", None)
print("Remove:", removed)
