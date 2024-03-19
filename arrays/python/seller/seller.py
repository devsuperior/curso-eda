import json

def find_max_seller_amount(arr):
    max_amount = 0
    seller = None

    for item in arr:
        if item["amount"] > max_amount:
            max_amount = item["amount"]
            seller = item

    return seller

# Exemplo de uso
with open('file.json', 'r') as file:
    sellers = json.load(file)

max_seller = find_max_seller_amount(sellers)
print(max_seller)