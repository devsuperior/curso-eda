# Demonstração de funções built-in e métodos de string em Python

# Funções Built-in
print("Funções Built-in:")
s = "Olá, mundo!"
print("String original:", s)
print("len(s):", len(s))
print("str(100):", str(100))

# Métodos de Strings
print("\nMétodos de Strings:")
s = "python é incrível!"

print("\nManipulação de Caixa:")
print("s.capitalize():", s.capitalize())
print("s.upper():", s.upper())
print("s.lower():", s.lower())
print("s.title():", s.title())
print("s.swapcase():", s.swapcase())

print("\nRemoção de Espaços:")
s = "   espaços   "
print("s.strip(): '", s.strip(), "'", sep='')
print("s.rstrip(): '", s.rstrip(), "'", sep='')
print("s.lstrip(): '", s.lstrip(), "'", sep='')

print("\nBusca e Substituição:")
s = "um peixe, dois peixes, peixe vermelho, peixe azul"
print("s.find('peixe'):", s.find('peixe'))
print("s.rfind('peixe'):", s.rfind('peixe'))
print("s.count('peixe'):", s.count('peixe'))
print("s.replace('peixe', 'gato'):", s.replace('peixe', 'gato'))

print("\nDivisão e Junção:")
s = "um,dois,três,quatro"
print("s.split(','):", s.split(','))
print("' - '.join(['um', 'dois', 'três']):", ' - '.join(['um', 'dois', 'três']))

print("\nVerificação de Conteúdo:")
s = "12345"
print("s.isdigit():", s.isdigit())
s = "espaços"
print("s.isalpha():", s.isalpha())
s = "   "
print("s.isspace():", s.isspace())
s = "PYTHON"
print("s.isupper():", s.isupper())
s = "python"
print("s.islower():", s.islower())
s = "Python Is Cool"
print("s.istitle():", s.istitle())
