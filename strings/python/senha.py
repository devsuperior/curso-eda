import re


def validate_password(string):
    regex = r"^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@&#]).{8,}$"
    return bool(re.match(regex, string))


print(validate_password("amerca1@"))
print(validate_password("amrca154682"))
