name = "Alice"
age = 31
points = 8.347

# Simple literal
str1 = "Olá, mundo!"
str1_2 = "Olá mundo!"
print("str1:")
print(str1)

# Concatenation
str2 = "Cliente " + name + " tem idade " + str(age) + " anos e fez " + str(points) + " pontos."
print("str2:")
print(str2)

# Escape characters
str3 = "Cliente: " + name + "\nIdade: " + str(age)
str4 = "c:\\Program Files\\Windows"
str5 = "Senha = \"carro123\""
str5_2 = 'Senha = "carro123"'
str6 = "<html>\n\t<body>\n\t\t<p>Hello, World!</p>\n\t</body>\n</html>\n"
print("str3:")
print(str3)
print("str4:")
print(str4)
print("str5:")
print(str5)
print("str6:")
print(str6)

# Interpolation / formatting
str7 = "Cliente %s tem idade %d anos e fez %f pontos." % (name, age, points)
str8 = "Cliente %s tem idade %d anos e fez %.2f pontos." % (name, age, points)
str9 = "Cliente {} tem idade {} anos e fez {} pontos.".format(name, age, points)
str10 = f"Cliente {name} tem idade {age} anos e fez {points} pontos."
print("str7:")
print(str7)
print("str8:")
print(str8)
print("str9:")
print(str9)
print("str10:")
print(str10)

# Text blocks
str11 = '''<html>
    <body>
        <p>Hello, World!</p>
    </body>
</html>
'''
str12 = f'''<html>
    <body>
        <p>Hello, World {name}!</p>
    </body>
</html>
'''
print("str11:")
print(str11)
print("str12:")
print(str12)
